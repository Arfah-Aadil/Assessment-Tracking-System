package com.example.Assessment.Tracking.ModuleLead;

import org.springframework.jdbc.core.RowMapper;

import java.util.List;

// import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ModuleLeadRepositoryJDBC implements ModuleLeadRepository{
    private JdbcTemplate jdbc;
    private RowMapper<ModuleLead> moduleLeadMapper;

    public ModuleLeadRepositoryJDBC(JdbcTemplate aJdbc) {
        this.jdbc = aJdbc;
        setModuleLeadMapper(); 
    }

    private void setModuleLeadMapper(){
        moduleLeadMapper = (rs, i) -> new ModuleLead(
            rs.getString("Module_Code"),
            rs.getString("Module_Title"),
            rs.getString("Lecturer"),
            rs.getString("Assessment_Title"),
            rs.getString("Assessment_Number"),
            rs.getString("Date_Set"),
            rs.getString("Submission_Date_and_Time"),
            rs.getString("Feedback_Return_Date"),
            rs.getString("PDF_Link")
        );
    }

    @Override
    public void addModuleLeaderForm(ModuleLead moduleLead){
        String sql = "insert into module_leader_form (Module_Code, Module_Title, Lecturer, Assessment_Title, Assessment_Number, Date_Set, Submission_Date_and_Time, Feedback_Return_Date, PDF_Link) values (?, ?, ?, ? ,? , ?, ?, ?, ?)";    
        jdbc.update(sql, moduleLead.getModuleCode(), moduleLead.getModuleTitle(), moduleLead.getLecturer(), moduleLead.getAssessmentTitle(), moduleLead.getAssessmentNumber(), moduleLead.getDateSet(), moduleLead.getSubmissionDate(), moduleLead.getFeedbackDate(), moduleLead.getPdfLink());
    }

    @Override
    public List<ModuleLead> getAssessmentDetails() {
        String sql = "select * from module_leader_form";
        return jdbc.query(sql, moduleLeadMapper);
    }
}
