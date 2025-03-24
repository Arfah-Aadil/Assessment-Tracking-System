package com.example.Assessment.Tracking.admin;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Admin {
    @NotEmpty(message = "The username cannot be empty.")
    private String name;

    @NotEmpty(message = "The password cannot be empty.")
    private String password;

    @NotEmpty(message = "The Role cannot be empty.")
    private String role;

    public Admin() {
        this.name = "";
        this.password = "";
        this.role = "";
    }
}
