package com.example.Assessment.Tracking.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class PanelForm {
    @NotBlank(message = "Module Title is required.")
    private String moduleTitle;

    @NotBlank(message = "Module Code is required.")
    private String moduleCode;

    @NotBlank(message = "Assessment Period is required.")
    private String assessmentPeriod;

    @NotBlank(message = "Type Of Assessment is required.")
    private String assessmentType;

    @NotBlank(message = "Module Leader is required.")
    private String moduleLeader;

    @NotBlank(message = "Internal Moderator is required.")
    private String internalModerator;

    @NotBlank(message = "External Moderator is required.")
    private String externalModerator;

    private Boolean part4;
    private String datePart4;
    private String panelComments;
    private Boolean assessmentApproved;
    private Boolean assessmentApprovedMinor;
    private Boolean assessmentReconsider;
    private Boolean assessmentResend;
    private Boolean moduleLeaderNotified;
    private String dateP1;
    private Boolean moderatorSetterNotified;
    private String dateP2;

    public PanelForm() {
        this.moduleTitle = "";
        this.moduleCode = "";
        this.assessmentPeriod = "";
        this.assessmentType = "";
        this.moduleLeader = "";
        this.internalModerator = "";
        this.externalModerator = "";
        this.part4 = false;
        this.datePart4 = "";
        this.panelComments = "";
        this.assessmentApproved = false;
        this.assessmentApprovedMinor = false;
        this.assessmentReconsider = false;
        this.assessmentResend = false;
        this.moduleLeaderNotified = false;
        this.dateP1 = "";
        this.moderatorSetterNotified = false;
        this.dateP2 = "";
    }

}
