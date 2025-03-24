package com.example.Assessment.Tracking.ModuleLead;

import java.util.List;

public interface ModuleLeadRepository {
    void addModuleLeaderForm(ModuleLead moduleLead);
    List<ModuleLead> getAssessmentDetails();
}
