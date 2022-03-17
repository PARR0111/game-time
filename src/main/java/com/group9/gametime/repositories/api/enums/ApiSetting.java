package com.group9.gametime.repositories.api.enums;

public enum ApiSetting {
    BASE_URL("https://livescore-api.com/api-client/"),
    KEY("key=NUS2mBNqkmup6Fbr"),
    SECRET("secret=OaSpX6XRI64PJoXxjPAFrn5LKAbQfni3");

    ApiSetting(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }
}
