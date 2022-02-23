package com.group9.gametime.api;

public enum ApiSetting {
    BASE_URL("https://livescore-api.com/api-client/");

    ApiSetting(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }
}
