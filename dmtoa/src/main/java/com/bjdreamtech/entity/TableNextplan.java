package com.bjdreamtech.entity;

public class TableNextplan {
    private String nextplanId;

    private String nextplanThing;

    private String nextplanOvertime;

    private String nextplanLeading;

    private String nextplanParting;

    private String nextplanWeeklyId;

    private String nextplanStarttime;

    public String getNextplanId() {
        return nextplanId;
    }

    public void setNextplanId(String nextplanId) {
        this.nextplanId = nextplanId == null ? null : nextplanId.trim();
    }

    public String getNextplanThing() {
        return nextplanThing;
    }

    public void setNextplanThing(String nextplanThing) {
        this.nextplanThing = nextplanThing == null ? null : nextplanThing.trim();
    }

    public String getNextplanOvertime() {
        return nextplanOvertime;
    }

    public void setNextplanOvertime(String nextplanOvertime) {
        this.nextplanOvertime = nextplanOvertime == null ? null : nextplanOvertime.trim();
    }

    public String getNextplanLeading() {
        return nextplanLeading;
    }

    public void setNextplanLeading(String nextplanLeading) {
        this.nextplanLeading = nextplanLeading == null ? null : nextplanLeading.trim();
    }

    public String getNextplanParting() {
        return nextplanParting;
    }

    public void setNextplanParting(String nextplanParting) {
        this.nextplanParting = nextplanParting == null ? null : nextplanParting.trim();
    }

    public String getNextplanWeeklyId() {
        return nextplanWeeklyId;
    }

    public void setNextplanWeeklyId(String nextplanWeeklyId) {
        this.nextplanWeeklyId = nextplanWeeklyId == null ? null : nextplanWeeklyId.trim();
    }

    public String getNextplanStarttime() {
        return nextplanStarttime;
    }

    public void setNextplanStarttime(String nextplanStarttime) {
        this.nextplanStarttime = nextplanStarttime == null ? null : nextplanStarttime.trim();
    }
}