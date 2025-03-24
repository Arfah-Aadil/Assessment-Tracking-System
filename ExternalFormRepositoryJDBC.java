package com.example.Assessment.Tracking.forms;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

// Repository class for handling database operations related to ExternalForm
@Repository
public class ExternalFormRepositoryJDBC implements ExternalFormRepository {
    private JdbcTemplate jdbc; // JdbcTemplate for database interaction
    private RowMapper<ExternalForm> externalFormMapper; // Mapper to convert SQL results to ExternalForm objects

    // Constructor for initialising with a JdbcTemplate instance
    public ExternalFormRepositoryJDBC(JdbcTemplate aJdbc) {
        this.jdbc = aJdbc;
        setExternalFormMapper();// Set up the external form mapper
    }

    // Sets up the RowMapper to map SQL result set to ExternalForm object
    private void setExternalFormMapper() {
        externalFormMapper = (rs, i) -> new ExternalForm(
                rs.getString("Module_Title"),
                rs.getString("Module_Code"),
                rs.getString("Assessment_Period"),
                rs.getString("Type_Of_Assessment"),
                rs.getString("Module_Leader"),
                rs.getString("Internal_Moderator"),
                rs.getString("External_Moderator"),
                rs.getString("Assessment_approved"),
                rs.getBoolean("Approved_to_minor_modification"),
                rs.getBoolean("Assessment_to_be_reconsidered"),
                rs.getBoolean("Assessment_to_be_resent"),
                rs.getBoolean("Feedback"),
                rs.getString("Date_Completed")
        );
    }

    // Method to add a new ExternalForm to the database
    @Override
    public void addExternalForm(ExternalForm externalForm) {
        String sql = "insert into external_form (Module_Title, Module_Code, Assessment_Period, Type_Of_Assessment, Module_Leader, Internal_Moderator, External_Moderator, Assessment_approved, Approved_to_minor_modification, Assessment_to_be_reconsidered, Assessment_to_be_resent, Feedback, Date_Completed) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbc.update(sql, externalForm.getModuleTitle(), externalForm.getModuleCode(), externalForm.getAssessmentPeriod(), externalForm.getAssessmentType(), externalForm.getModuleLeader(), externalForm.getInternalModerator(), externalForm.getExternalModerator(), externalForm.getAssessmentApproved(), externalForm.getApprovedToMinorModification(), externalForm.getAssessmentToBeReconsidered(), externalForm.getAssessmentToBeResent(), externalForm.getFeedback(), externalForm.getDate());
    }

    @Override
    public ExternalForm findExternal(String moduleCode) {
        String sql = "select * from external_form WHERE Module_Code = ?";
        return jdbc.queryForObject(sql, externalFormMapper, moduleCode);
    }

    @Override
    public void updateExternalForm(ExternalForm externalForm) {
        String sqlExternal = "UPDATE external_form SET Module_Title = ?, Module_Code = ?, Assessment_Period = ?, Type_Of_Assessment = ?, Module_Leader = ?, Internal_Moderator = ?, External_Moderator = ?, Assessment_approved = ?, Approved_to_minor_modification = ?, Assessment_to_be_reconsidered = ?, Assessment_to_be_resent = ?, Feedback = ?, Date_Completed = ? WHERE Module_Code = ?";
        jdbc.update(sqlExternal, externalForm.getModuleTitle(), externalForm.getModuleCode(), externalForm.getAssessmentPeriod(), externalForm.getAssessmentType(), externalForm.getModuleLeader(), externalForm.getInternalModerator(), externalForm.getExternalModerator(), externalForm.getAssessmentApproved(), externalForm.getApprovedToMinorModification(), externalForm.getAssessmentToBeReconsidered(), externalForm.getAssessmentToBeResent(), externalForm.getFeedback(), externalForm.getDate());
    }
}