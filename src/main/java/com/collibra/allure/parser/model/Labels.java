package com.collibra.allure.parser.model;

import java.util.ArrayList;

public class Labels extends ArrayList<Label> {

    public static String getHeaders() {
        return "labels";
    }

    public String parentSuitOrToString() {
        return this.stream()
                .filter(label -> label.getName().equals("host"))
                .findAny()
                .map(Label::getValue)
                .orElse(super.toString());
    }
}
