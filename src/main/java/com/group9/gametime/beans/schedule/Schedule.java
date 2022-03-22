package com.group9.gametime.beans.schedule;

public class Schedule {
    private boolean success;
    private ScheduleData data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ScheduleData getData() {
        return data;
    }

    public void setData(ScheduleData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "success=" + success +
                ", data=" + data +
                '}';
    }
}
