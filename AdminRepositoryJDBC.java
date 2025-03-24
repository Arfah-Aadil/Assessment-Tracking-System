package com.example.Assessment.Tracking.admin;
import java.security.SecureRandom;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRepositoryJDBC implements AdminRepository {

    private JdbcTemplate jdbc;
    private RowMapper<Admin> adminMapper;
    private RowMapper<AssessmentStatus> statusMapper;

    public AdminRepositoryJDBC(JdbcTemplate aJdbc) {
        this.jdbc = aJdbc;
        setAdminMapper();
    }

    private void setAdminMapper() {
        adminMapper = (rs, i) -> new Admin(
                rs.getString("name"),
                rs.getString("password"),
                rs.getString("role")
        );
        
        statusMapper = (rs,i) -> new AssessmentStatus(
            rs.getString("AssessmentName"),
            rs.getString("Status")
        );
    }

    public String encode(String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder =
                new BCryptPasswordEncoder(10, new SecureRandom());
        return bCryptPasswordEncoder.encode(password);
    
    }

    @Override
    public void addUsers(Admin admin) {
        String userSql = "insert into users (UserName, Password,enabled) values (?,?,1)";
        jdbc.update(userSql, admin.getName(), encode(admin.getPassword()));
        String authoritySql = "insert into user_authorities (UserName,authority) values (?,?)";
        jdbc.update(authoritySql,admin.getName(),admin.getRole());
        
        String userAuthoritySql = "insert into user_authorities (UserName,authority) values (?,'ROLE_USER')";
        jdbc.update(userAuthoritySql,admin.getName());
    }

    @Override
    public List<AssessmentStatus> getAssessmentStatuses(){
        String statusSql = "select * from Assessments";
        return jdbc.query(statusSql, statusMapper);
    }
}
