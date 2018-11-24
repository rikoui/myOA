package com.bjdreamtech.entity;

public class SysAuthvali {
    private String authvaliId;

    private String authvaliAction;

    private String authvaliMenuId;

    public String getAuthvaliId() {
        return authvaliId;
    }

    public void setAuthvaliId(String authvaliId) {
        this.authvaliId = authvaliId == null ? null : authvaliId.trim();
    }

    public String getAuthvaliAction() {
        return authvaliAction;
    }

    public void setAuthvaliAction(String authvaliAction) {
        this.authvaliAction = authvaliAction == null ? null : authvaliAction.trim();
    }

    public String getAuthvaliMenuId() {
        return authvaliMenuId;
    }

    public void setAuthvaliMenuId(String authvaliMenuId) {
        this.authvaliMenuId = authvaliMenuId == null ? null : authvaliMenuId.trim();
    }
}