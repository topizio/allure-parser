package com.collibra.allure.parser.model;

import com.collibra.allure.parser.ParserApplication;
import lombok.Setter;

import java.util.StringJoiner;

@Setter
public class AllureEntry {

    private String fullName;
    private Time time;
    private String status;
    private boolean flaky;
    private boolean newFailed;
    private Extra extra;
    private Labels labels;

    @Override
    public String toString() {
        return new StringJoiner(ParserApplication.SEPARATOR)
                .add(fullName)
                .add(time.toString())
                .add(status)
                .add(Boolean.toString(flaky))
                .add(Boolean.toString(newFailed))
                .add(extra.toString())
                .add(labels.parentSuitOrToString())
                .toString();
    }

    public static String getHeaders() {
        return new StringJoiner(ParserApplication.SEPARATOR)
                .add("fullName")
                .add(Time.getHeaders())
                .add("status")
                .add("flaky")
                .add("newFailed")
                .add(Extra.getHeaders())
                .add(Labels.getHeaders())
                .toString();
    }
}
