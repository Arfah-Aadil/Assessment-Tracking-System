package com.example.Assessment.Tracking.admin;

import java.util.List;

public interface AdminRepository {
    void addUsers(Admin admin);
    List<AssessmentStatus> getAssessmentStatuses();   
}
