package data.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import data.Item;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class CartDAO
{
    @Autowired
    public CartDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Item> findAll(int userId)
    {
        return jdbcTemplate.query("select * from Cart where userid = " + userId, new RowMapper<Item>(){

            @Override
            public Item mapRow(ResultSet resultSet, int i) throws SQLException {
                int id = resultSet.getInt("cartid");
                int userId = resultSet.getInt("userId");
                int itemId = resultSet.getInt("itemId");
                return new Item(id,userId,itemId);
            }
        });
    }

    public void addItem(int itemId, double price, int userId)
    {
        jdbcTemplate.execute("insert into Cart(userid, itemid) values(" + userId + "," + itemId + ")");
        jdbcTemplate.execute("update totalprices set price = price + " + price + " where userid = " + userId);
    }

    public void deleteItem(int id, int userId)
    {
        jdbcTemplate.execute("delete from Cart where itemid =" + id + " and userID = " + userId);
    }

    public void deleteAll(int userId)
    {
        jdbcTemplate.execute("delete from Cart where userid = " + userId);
        jdbcTemplate.execute("update totalprices set price = 0 where userid = " + userId);
    }

    public int getTotalPrice(int userId)
    {
        String query = "SELECT * FROM TOTALPRICES where userid = " + userId;

        List<Price> totalPrice = jdbcTemplate.query(query, new RowMapper<Price>()
        {
            @Override
            public Price mapRow(ResultSet resultSet, int i) throws SQLException
            {
                return new Price(resultSet.getInt("price"));
            }
        });

        return totalPrice.get(0).money;
    }

    class Price
    {
        Price(int money){
            this.money = money;
        }
        int money;
    }

    private final JdbcTemplate jdbcTemplate;
}
