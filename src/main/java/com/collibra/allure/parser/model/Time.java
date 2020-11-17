package com.collibra.allure.parser.model;

import lombok.Setter;

@Setter
public class Time {

    private long duration;

    public static String getHeaders() {
        return "duration";
    }

    @Override
    public String toString() {
        return Long.toString(duration);
    }
}
