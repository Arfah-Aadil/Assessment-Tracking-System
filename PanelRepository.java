package com.example.Assessment.Tracking.forms;

public interface PanelRepository {
    PanelForm findPanel(String moduleCode);
    void addPanel(PanelForm panel);
    void updatePanel(PanelForm panel);
}
