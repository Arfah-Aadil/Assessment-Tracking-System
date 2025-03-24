package com.example.Assessment.Tracking.forms;

public interface ExternalFormRepository {
    ExternalForm findExternal(String moduleCode);
    void addExternalForm(ExternalForm externalForm);
    void updateExternalForm(ExternalForm externalForm);
}