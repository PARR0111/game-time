package com.group9.gametime.api.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser<T> {
    private Class<T> type;

    public JsonParser(Class<T> type) {
        this.type = type;
    }

    public T parse(String jsonPayload) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonPayload, type);
    }
}
