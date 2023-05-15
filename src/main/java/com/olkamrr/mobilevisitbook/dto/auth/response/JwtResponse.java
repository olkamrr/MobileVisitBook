package com.olkamrr.mobilevisitbook.dto.auth.response;

import com.olkamrr.mobilevisitbook.models.Group;
import com.olkamrr.mobilevisitbook.models.Teacher;

import java.util.List;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private int id;
    private String username;
    private List<String> roles;
    private boolean active;

    public JwtResponse(String accessToken, int id, String username, List<String> roles, boolean active) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.roles = roles;
        this.active = active;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
