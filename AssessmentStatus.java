package com.example.Assessment.Tracking.admin;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AssessmentStatus {
    private String assessmentName;

    private String assessmentStatus;

    public AssessmentStatus() {
        this.assessmentName = "";
        this.assessmentStatus = "";
    }
}
