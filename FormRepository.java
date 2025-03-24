package com.example.Assessment.Tracking.forms;

public interface FormRepository {
    TrackingForm findInternal(String moduleCode);
    void addForm(TrackingForm form);
    void updateForm(TrackingForm form);
}