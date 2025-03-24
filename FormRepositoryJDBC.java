package com.example.Assessment.Tracking.forms;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

// Repository class for handling database operations related to TrackingForm
@Repository
public class FormRepositoryJDBC implements FormRepository {

    private JdbcTemplate jdbc; // JdbcTemplate for database interaction
    private RowMapper<TrackingForm> formMapper; // Mapper to convert SQL results to TrackingForm objects

    // Constructor for initialising with a JdbcTemplate instance
    public FormRepositoryJDBC(JdbcTemplate aJdbc) {
        this.jdbc = aJdbc;
        setFormMapper(); // Set up the form mapper
    }

    // Sets up the RowMapper to map SQL result set to TrackingForm object
    private void setFormMapper() {
        formMapper = (rs, rowNum) -> new TrackingForm(
                // Map each column of the result set to the TrackingForm fields
                rs.getString("Module_Title"), rs.getString("Module_Code"),
                rs.getString("Assessment_Period"), rs.getString("Type_Of_Assessment"),
                rs.getString("Module_Leader"), rs.getString("Internal_Moderator"),
                rs.getString("External_Moderator"), rs.getBoolean("Part1"),
                rs.getString("Date_Part1"), rs.getBoolean("Part2"),
                rs.getString("Date_Part2"), rs.getBoolean("Criteria1"),
                rs.getBoolean("Criteria2"), rs.getBoolean("Criteria3"),
                rs.getBoolean("Criteria4"), rs.getBoolean("Criteria5"),
                rs.getBoolean("Criteria6"), rs.getBoolean("Criteria7"),
                rs.getBoolean("Criteria8"), rs.getString("Summary"),
                rs.getBoolean("Part3"), rs.getString("Date_Part3")
        );
    }

    // Method to add a new TrackingForm to the database
    @Override
    public void addForm(TrackingForm form) {
        String sql = "INSERT INTO internal_form (Module_Title, Module_Code, Assessment_Period, Type_Of_Assessment, Module_Leader, Internal_Moderator, External_Moderator, Part1, Date_Part1, Part2, Date_Part2, Criteria1, Criteria2, Criteria3, Criteria4, Criteria5, Criteria6, Criteria7, Criteria8, Summary, Part3, Date_Part3) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // Adding to the database with form inputs
        jdbc.update(sql, form.getModuleTitle(), form.getModuleCode(),
                form.getAssessmentPeriod(), form.getTypeOfAssessment(),
                form.getModuleLeader(), form.getInternalModerator(),
                form.getExternalModerator(), form.getPart1() ? 1 : 0,
                form.getDatePart1(), form.getPart2() ? 1 : 0,
                form.getDatePart2(), form.getCriteria1() ? 1 : 0,
                form.getCriteria2() ? 1 : 0, form.getCriteria3() ? 1 : 0,
                form.getCriteria4() ? 1 : 0, form.getCriteria5() ? 1 : 0,
                form.getCriteria6() ? 1 : 0, form.getCriteria7() ? 1 : 0,
                form.getCriteria8() ? 1 : 0, form.getSummary(),
                form.getPart3() ? 1 : 0, form.getDatePart3());
    }

    // Method to find a TrackingForm by module code
    @Override
    public TrackingForm findInternal(String moduleCode) {
        String internalFormSql = "SELECT * FROM internal_form WHERE Module_Code = ?";
        return jdbc.queryForObject(internalFormSql, formMapper, moduleCode);
    }

    // Method to update an existing TrackingForm
    public void updateForm(TrackingForm form) {
        String sql = "UPDATE internal_form SET Module_Title = ?, Assessment_Period = ?, Type_Of_Assessment = ?, Module_Leader = ?, Internal_Moderator = ?, External_Moderator = ?, Part1 = ?, Date_Part1 = ?, Part2 = ?, Date_Part2 = ?, Criteria1 = ?, Criteria2 = ?, Criteria3 = ?, Criteria4 = ?, Criteria5 = ?, Criteria6 = ?, Criteria7 = ?, Criteria8 = ?, Summary = ?, Part3 = ?, Date_Part3 = ? WHERE Module_Code = ?";

        // Updating the database with new form inputs
        jdbc.update(sql, form.getModuleTitle(), form.getAssessmentPeriod(),
                form.getTypeOfAssessment(), form.getModuleLeader(),
                form.getInternalModerator(), form.getExternalModerator(),
                form.getPart1() ? 1 : 0, form.getDatePart1(),
                form.getPart2() ? 1 : 0, form.getDatePart2(),
                form.getCriteria1() ? 1 : 0, form.getCriteria2() ? 1 : 0,
                form.getCriteria3() ? 1 : 0, form.getCriteria4() ? 1 : 0,
                form.getCriteria5() ? 1 : 0, form.getCriteria6() ? 1 : 0,
                form.getCriteria7() ? 1 : 0, form.getCriteria8() ? 1 : 0,
                form.getSummary(), form.getPart3() ? 1 : 0,
                form.getDatePart3(), form.getModuleCode());
    }
}