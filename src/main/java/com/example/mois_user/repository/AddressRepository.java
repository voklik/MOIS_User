package com.example.mois_user.repository;

import com.example.mois_user.domain.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AddressRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Address getAddressById(long id) throws SQLException {
        Map<String, Object> params = new HashMap<>();

        String sql = "select "
                + "City, PostCode "
                + "from address where "
                + "IDAddress = :addressId";
        params.put("addressId", id);
        return jdbcTemplate.queryForObject(sql, new Object[]{id},
                BeanPropertyRowMapper.newInstance(Address.class));
    }
}
