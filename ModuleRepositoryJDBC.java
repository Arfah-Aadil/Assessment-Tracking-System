package com.example.Assessment.Tracking.modules;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ModuleRepositoryJDBC implements ModuleRepository{
    private JdbcTemplate jdbc;
    private RowMapper<Module> moduleMapper;

    public ModuleRepositoryJDBC(JdbcTemplate aJdbc) {
        this.jdbc = aJdbc;
        setModuleMapper();
    }

    private void setModuleMapper() {
        moduleMapper = (rs, i) -> new Module(
                rs.getString("moduleName"),
                rs.getString("assessmentTitle"),
                rs.getString("moduleLead"),
                rs.getString("externalModulator"),
                rs.getString("internalModulator"),
                rs.getString("panel")
            );
    }
    
    @Override
    public List<Module> getAllModules() {
        String sql = "select * from Modules";
        return jdbc.query(sql, moduleMapper);
    }

    @Override
    public void submitModuleForm(Module module){
        String sql = "insert into Modules (ModuleName, AssessmentTitle, ModuleLead, ExternalModulator, InternalModulator, Panel) values (?, ?, ?, ? ,? , ?)";    
        jdbc.update(sql, module.getModuleName(), module.getAssessmentTitle(), module.getModuleLead(), module.getExternalModulator(), module.getInternalModulator(), module.getPanel());
    }
}
