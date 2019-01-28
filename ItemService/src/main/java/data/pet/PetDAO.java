package data.pet;

import data.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class PetDAO
{
    @Autowired
    public PetDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Pet> findAll()
    {
        return jdbcTemplate.query("select Id, Name, Price from item where type = 0", new PetRowMapper());
    }

    public List<Pet> findPetByID(int id)
    {
        return jdbcTemplate.query("select Id, Name, Price from item where type = 0 and Id =" + id , new PetRowMapper());
    }

    private class PetRowMapper implements RowMapper<Pet>
    {
        @Override
        public Pet mapRow(ResultSet resultSet, int i) throws SQLException
        {
            int id = resultSet.getInt("Id");
            String petName = resultSet.getString("Name");
            double price = resultSet.getDouble("price");

            return new Pet(id, price, petName);
        }
    }

    private final JdbcTemplate jdbcTemplate;
}
