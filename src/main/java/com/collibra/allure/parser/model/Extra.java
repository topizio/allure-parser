package com.collibra.allure.parser.model;

import lombok.Setter;

@Setter
public class Extra {

    private History history;

    public static String getHeaders() {
        return History.getHeaders();
    }

    @Override
    public String toString() {
        return history.getStatistic().toString();
    }
}
