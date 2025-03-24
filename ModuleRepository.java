package com.example.Assessment.Tracking.modules;

import java.util.List;

public interface ModuleRepository {
    List<Module> getAllModules();
    void submitModuleForm(Module module);
}
