package com.kidslearningapp;

public class HistoryClass {
    String activityName, timeAndDate;

    public HistoryClass(String activityName, String timeAndDate) {
        this.activityName = activityName;
        this.timeAndDate = timeAndDate;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getTimeAndDate() {
        return timeAndDate;
    }

    public void setTimeAndDate(String timeAndDate) {
        this.timeAndDate = timeAndDate;
    }
}
