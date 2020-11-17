package com.collibra.allure.parser.model;

import lombok.Data;

@Data
public class History {

    private Statistic statistic;

    public static String getHeaders() {
        return Statistic.getHeaders();
    }
}
