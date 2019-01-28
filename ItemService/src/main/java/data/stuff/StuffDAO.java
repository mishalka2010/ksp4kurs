package data.stuff;


import data.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class StuffDAO
{
    @Autowired
    public StuffDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Nullable
    public List<Staff> findAll()
    {
        return jdbcTemplate.query("select * from item where type = 1", new StaffRowMapper());
    }

    @Nullable
    public List<Staff> findStaffByID(int id)
    {
        return jdbcTemplate.query("select Id, Name, Price from item where type = 1 and Id =" + id , new StaffRowMapper());
    }

    class StaffRowMapper implements RowMapper<Staff>
    {
        @Override
        public Staff mapRow(ResultSet resultSet, int i) throws SQLException
        {
            int id = resultSet.getInt("Id");
            String staffName = resultSet.getString("Name");
            double price = resultSet.getDouble("price");

            return new Staff(id, price, staffName);
        }
    }

    private final JdbcTemplate jdbcTemplate;
}
