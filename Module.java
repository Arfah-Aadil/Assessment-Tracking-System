package com.example.Assessment.Tracking.modules;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Module {
    @NotEmpty(message = "The module name cannot be empty")
    private String moduleName;

    @NotEmpty(message = "The assessment title cannot be empty")
    private String AssessmentTitle;

    @NotEmpty(message = "The module lead name cannot be empty")
    private String moduleLead;

    @NotEmpty(message = "The external modulator name cannot be empty")
    private String externalModulator;

    @NotEmpty(message = "The internal modulator cannot be empty")
    private String internalModulator;

    @NotEmpty(message = "The panel name cannot be empty")
    private String panel;

    public Module() {
        this.moduleName ="";
        this.AssessmentTitle ="";
        this.moduleLead ="";
        this.externalModulator ="";
        this.internalModulator ="";
        this.panel ="";
    }

}
