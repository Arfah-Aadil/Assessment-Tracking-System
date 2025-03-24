package com.example.Assessment.Tracking.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class TrackingForm {
    @NotBlank(message = "Module Title is required.")
    private String moduleTitle;

    @NotBlank(message = "Module Code is required.")
    private String moduleCode;

    @NotBlank(message = "Assessment Period is required.")
    private String assessmentPeriod;

    @NotBlank(message = "Type Of Assessment is required.")
    private String typeOfAssessment;

    @NotBlank(message = "Module Leader is required.")
    private String moduleLeader;

    @NotBlank(message = "Internal Moderator is required.")
    private String internalModerator;

    @NotBlank(message = "External Moderator is required.")
    private String externalModerator;

    private Boolean part1;
    private String datePart1;
    private Boolean part2;
    private String datePart2;
    private Boolean criteria1;
    private Boolean criteria2;
    private Boolean criteria3;
    private Boolean criteria4;
    private Boolean criteria5;
    private Boolean criteria6;
    private Boolean criteria7;
    private Boolean criteria8;
    private String summary;
    private Boolean part3;
    private String datePart3;

    public TrackingForm() {
        this.moduleTitle = "";
        this.moduleCode = "";
        this.assessmentPeriod = "";
        this.typeOfAssessment = "";
        this.moduleLeader = "";
        this.internalModerator = "";
        this.externalModerator = "";
        this.part1 = false;
        this.datePart1 = "";
        this.part2 = false;
        this.datePart2 = "";
        this.criteria1 = false;
        this.criteria2 = false;
        this.criteria3 = false;
        this.criteria4 = false;
        this.criteria5 = false;
        this.criteria6 = false;
        this.criteria7 = false;
        this.criteria8 = false;
        this.summary = "";
        this.part3 = false;
        this.datePart3 = "";
    }
}

