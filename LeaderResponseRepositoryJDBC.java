package com.example.Assessment.Tracking.forms;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class LeaderResponseRepositoryJDBC implements LeaderResponseRepository{
    private JdbcTemplate jdbc;
    private RowMapper<LeaderResponse> leaderResponseMapper;

    public LeaderResponseRepositoryJDBC(JdbcTemplate aJdbc){
        this.jdbc = aJdbc;
        setLeaderResponseMapper();
    }

    private void setLeaderResponseMapper() {
        leaderResponseMapper = (rs,i) -> new LeaderResponse(
            rs.getString("moduleTitle"),
            rs.getString("moduleCode"),
            rs.getString("moduleLeader"),
            rs.getString("moderator"),
            rs.getString("response"),
            rs.getString("date")
        );
    }

    @Override
    public void addLeaderResponseForm(LeaderResponse leaderResponse) {
        String sql = "insert into leader_response_form (Module_Title, Module_Code, Module_Leader, Moderator, Response_to_moderator_comments, Date_Completed) values (?, ?, ?, ?, ?, ?)";
        jdbc.update(sql, leaderResponse.getModuleTitle(), leaderResponse.getModuleCode(), leaderResponse.getModuleLeader(), leaderResponse.getModerator(), leaderResponse.getResponse(), leaderResponse.getDate());
    }
    
    
}
