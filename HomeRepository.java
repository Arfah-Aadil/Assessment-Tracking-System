package com.example.Assessment.Tracking.home;

import java.util.List;
import java.security.Principal;


public interface HomeRepository {
    List<RoleData> getRole(Principal principal);
}
