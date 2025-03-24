package com.example.Assessment.Tracking.forms;

public interface FormSubmissionManager {
    void processFormSubmission(TrackingForm trackingForm);
    
    void processFormSubmission(ExternalForm externalForm);
}
