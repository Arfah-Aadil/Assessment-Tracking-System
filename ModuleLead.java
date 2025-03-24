package com.example.Assessment.Tracking.ModuleLead;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ModuleLead {
    @NotEmpty(message = "Module Code can not be empty")
    private String moduleCode;
    @NotEmpty(message = "Module Title can not be empty")
    private String moduleTitle;
    @NotEmpty(message = "Lecturer can not be empty")
    private String lecturer;
    @NotEmpty(message = "Assessment Title can not be empty")
    private String assessmentTitle;
    @NotEmpty(message = "Assessment Number can not be empty")
    private String assessmentNumber;
    @NotEmpty(message = "Date Set can not be empty")
    private String dateSet;
    @NotEmpty(message = "Submission Date and Time can not be empty")
    private String submissionDate;
    @NotEmpty(message = "Feedback Return Date can not be empty")
    private String feedbackDate;
    @NotEmpty(message = "PDF Link can not be empty")
    private String pdfLink;

    public ModuleLead() {
        this.moduleCode="";
        this.moduleTitle="";
        this.lecturer="";
        this.assessmentTitle="";
        this.assessmentNumber="";
        this.dateSet="";
        this.submissionDate="";
        this.feedbackDate="";
        this.pdfLink="";
    }
}
