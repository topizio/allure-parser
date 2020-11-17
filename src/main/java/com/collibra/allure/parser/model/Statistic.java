package com.collibra.allure.parser.model;

import com.collibra.allure.parser.ParserApplication;
import lombok.Setter;

import java.util.StringJoiner;

@Setter
public class Statistic {

    private int failed;
    private int broken;
    private int skipped;
    private int passed;
    private int unknown;
    private int total;

    public static String getHeaders() {
        return new StringJoiner(ParserApplication.SEPARATOR)
                .add("failed")
                .add("broken")
                .add("skipped")
                .add("passed")
                .add("unknown")
                .add("total")
                .toString();
    }

    @Override
    public String toString() {
        return new StringJoiner(ParserApplication.SEPARATOR)
                .add(Integer.toString(failed))
                .add(Integer.toString(broken))
                .add(Integer.toString(skipped))
                .add(Integer.toString(passed))
                .add(Integer.toString(unknown))
                .add(Integer.toString(total))
                .toString();
    }
}
