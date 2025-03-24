package com.example.Assessment.Tracking.home;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoleData {
    private String authority;

    public RoleData() {
        this.authority="";
    }
}
