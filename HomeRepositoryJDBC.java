package com.example.Assessment.Tracking.home;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.security.Principal;

import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class HomeRepositoryJDBC implements HomeRepository{
    private JdbcTemplate jdbc;
    private RowMapper<RoleData> homeMapper; 

    public HomeRepositoryJDBC(JdbcTemplate aJdbc) {
        this.jdbc = aJdbc;
        setHomeMapper();
    }

    private void setHomeMapper() {
        homeMapper = (rs, i) -> new RoleData(
                rs.getString("authority")
        );
    }

    @Override
    public List<RoleData> getRole(Principal principal) {
        String roleSql = "select authority from user_authorities where UserName='" + principal.getName()+"' and authority!='ROLE_ADMIN' and authority!='ROLE_USER'";
        System.out.println(jdbc.query(roleSql,homeMapper));
        return jdbc.query(roleSql,homeMapper);
    }
    
}
