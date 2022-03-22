package com.group9.gametime.beans;

public class CompetitionResponse {
    private boolean success;
    private CompetitionData data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public CompetitionData getData() {
        return data;
    }

    public void setData(CompetitionData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Competitions{" +
                "success=" + success +
                ", data=" + data +
                '}';
    }
}
