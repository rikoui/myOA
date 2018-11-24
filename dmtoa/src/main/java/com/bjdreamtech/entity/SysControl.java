package com.bjdreamtech.entity;

public class SysControl {
    private String controlId;

    private String controlAdminId;

    private String controlSessionid;

    private String controlLogintime;

    public String getControlId() {
        return controlId;
    }

    public void setControlId(String controlId) {
        this.controlId = controlId == null ? null : controlId.trim();
    }

    public String getControlAdminId() {
        return controlAdminId;
    }

    public void setControlAdminId(String controlAdminId) {
        this.controlAdminId = controlAdminId == null ? null : controlAdminId.trim();
    }

    public String getControlSessionid() {
        return controlSessionid;
    }

    public void setControlSessionid(String controlSessionid) {
        this.controlSessionid = controlSessionid == null ? null : controlSessionid.trim();
    }

    public String getControlLogintime() {
        return controlLogintime;
    }

    public void setControlLogintime(String controlLogintime) {
        this.controlLogintime = controlLogintime == null ? null : controlLogintime.trim();
    }
}