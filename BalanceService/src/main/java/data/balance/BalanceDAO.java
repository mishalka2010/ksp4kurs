package data.balance;

import data.Balance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class BalanceDAO
{
    @Autowired
    public BalanceDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Balance> getBalanceByUserID(int userID)
    {
        return jdbcTemplate.query("select * from Balance where userid =" + userID, new RowMapper<Balance>()
        {
            @Override
            public Balance mapRow(ResultSet resultSet, int i) throws SQLException {
                int money = resultSet.getInt("money");
                return new Balance(money);
            }
        });
    }

    public void updateUserBalance(int newBalance, int userID)
    {
        jdbcTemplate.execute("UPDATE Balance set money = " + newBalance + " where userid = " + userID);
    }

    private final JdbcTemplate jdbcTemplate;
}
