package com.example.Assessment.Tracking.forms;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

// Repository class for handling database operations related to PanelForm
@Repository
public class PanelRepositoryJDBC implements PanelRepository {
    private JdbcTemplate jdbc; // JdbcTemplate for database interaction
    private RowMapper<PanelForm> panelMapper; // Mapper to convert SQL results to TrackingForm objects

    // Constructor for initialising with a JdbcTemplate instance
    public PanelRepositoryJDBC(JdbcTemplate aJdbc) {
        this.jdbc = aJdbc;
        setPanelMapper(); // Set up the panel mapper
    }

    // Sets up the RowMapper to map SQL result set to PanelForm object
    private void setPanelMapper() {
        panelMapper = (rs, i) -> new PanelForm(
                // Map each column of the result set to the PanelForm fields
                rs.getString("Module_Title"), rs.getString("Module_Code"),
                rs.getString("Assessment_Period"), rs.getString("Assessment_Type"),
                rs.getString("Module_Leader"), rs.getString("Internal_Moderator"),
                rs.getString("External_Moderator"), rs.getBoolean("Part4"),
                rs.getString("Date_Part4"), rs.getString("Panel_Comments"),
                rs.getBoolean("Assessment_Approved"), rs.getBoolean("Assessment_Approved_Minor"),
                rs.getBoolean("Assessment_Reconsider"), rs.getBoolean("Assessment_Resend"),
                rs.getBoolean("Module_Leader_Notified"), rs.getString("Date_P1"),
                rs.getBoolean("Moderator_Setter_Notified"), rs.getString("Date_P2")
        );
    }

    // Method to add a new PanelForm to the database
    public void addPanel(PanelForm panel) {
        String panelFormSql = "INSERT INTO panel_form (Module_Title, Module_Code, Assessment_Period, Assessment_Type, Module_Leader, Internal_Moderator, External_Moderator, Part4, Date_Part4, Panel_Comments, Assessment_Approved, Assessment_Approved_Minor, Assessment_Reconsider, Assessment_Resend, Module_Leader_Notified, Date_P1, Moderator_Setter_Notified, Date_P2) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // Adding to the database with form inputs
        jdbc.update(panelFormSql,
                panel.getModuleTitle(), panel.getModuleCode(),
                panel.getAssessmentPeriod(), panel.getAssessmentType(),
                panel.getModuleLeader(), panel.getInternalModerator(),
                panel.getExternalModerator(), panel.getPart4() ? 1 : 0,
                panel.getDatePart4(), panel.getPanelComments(),
                panel.getAssessmentApproved() ? 1 : 0, panel.getAssessmentApprovedMinor() ? 1 : 0,
                panel.getAssessmentReconsider() ? 1 : 0, panel.getAssessmentResend() ? 1 : 0,
                panel.getModuleLeaderNotified() ? 1 : 0, panel.getDateP1(),
                panel.getModeratorSetterNotified() ? 1 : 0, panel.getDateP2()
        );
    }

    // Method to find a PanelForm by module code
    @Override
    public PanelForm findPanel(String moduleCode) {
        String panelFormSql = "SELECT * FROM panel_form WHERE Module_Code = ?";
        return jdbc.queryForObject(panelFormSql, panelMapper, moduleCode);
    }

    // Method to update an existing PanelForm
    public void updatePanel(PanelForm panel) {
        String panelFormSql = "UPDATE panel_form SET Module_Title = ?, Assessment_Period = ?, Assessment_Type = ?, Module_Leader = ?, Internal_Moderator = ?, External_Moderator = ?, Part4 = ?, Date_Part4 = ?, Panel_Comments = ?, Assessment_Approved = ?, Assessment_Approved_Minor = ?, Assessment_Reconsider = ?, Assessment_Resend = ?, Module_Leader_Notified = ?, Date_P1 = ?, Moderator_Setter_Notified = ?, Date_P2 = ? WHERE Module_Code = ?";

        // Updating the database with new form inputs
        jdbc.update(panelFormSql,
                panel.getModuleTitle(), panel.getAssessmentPeriod(),
                panel.getAssessmentType(), panel.getModuleLeader(),
                panel.getInternalModerator(), panel.getExternalModerator(),
                panel.getPart4() ? 1 : 0, panel.getDatePart4(),
                panel.getPanelComments(), panel.getAssessmentApproved() ? 1 : 0,
                panel.getAssessmentApprovedMinor() ? 1 : 0, panel.getAssessmentReconsider() ? 1 : 0,
                panel.getAssessmentResend() ? 1 : 0, panel.getModuleLeaderNotified() ? 1 : 0,
                panel.getDateP1(), panel.getModeratorSetterNotified() ? 1 : 0,
                panel.getDateP2(), panel.getModuleCode()
        );
    }
}