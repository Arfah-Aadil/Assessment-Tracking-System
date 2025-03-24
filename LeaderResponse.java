package com.example.Assessment.Tracking.forms;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LeaderResponse {
    @NotEmpty(message = "Module Title is required.")
    private String moduleTitle;

    @NotEmpty(message = "Module Code is required.")
    private String moduleCode;

    @NotEmpty(message = "Module Leader is required.")
    private String moduleLeader;

    @NotEmpty(message = "Moderator is required.")
    private String moderator;

    private String response;
    
    private String date;

    public LeaderResponse() {
        this.moduleTitle = "";
        this.moduleCode = "";
        this.moduleLeader = "";
        this.moderator = "";
        this.response = "";
        this.date = "";
    }

    
}
