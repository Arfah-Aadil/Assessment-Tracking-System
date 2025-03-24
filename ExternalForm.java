package com.example.Assessment.Tracking.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class ExternalForm {
    @NotEmpty(message = "Module Title is required.")
    private String moduleTitle;

    @NotEmpty(message = "Module Code is required.")
    private String moduleCode;

    @NotEmpty(message = "Assessment Period is required.")
    private String assessmentPeriod;

    @NotEmpty(message = "Type Of Assessment is required.")
    private String assessmentType;

    @NotEmpty(message = "Module Leader is required.")
    private String moduleLeader;

    @NotEmpty(message = "Internal Moderator is required.")
    private String internalModerator;

    @NotEmpty(message = "External Moderator is required.")
    private String externalModerator;

    private String feedback;
    private Boolean assessmentApproved;
    private Boolean approvedToMinorModification;
    private Boolean assessmentToBeReconsidered;
    private Boolean assessmentToBeResent;
    private String date;

    public ExternalForm() {
        this.moduleTitle = "";
        this.moduleCode = "";
        this.assessmentPeriod = "";
        this.assessmentType = "";
        this.moduleLeader = "";
        this.internalModerator = "";
        this.externalModerator = "";
        this.feedback = "";
        this.assessmentApproved = false;
        this.approvedToMinorModification = false;
        this.assessmentToBeReconsidered = false;
        this.assessmentToBeResent = false;
        this.date = "";
    }
}