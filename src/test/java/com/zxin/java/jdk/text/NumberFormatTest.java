package com.zxin.java.jdk.text;

import org.junit.Test;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Arrays;

public class NumberFormatTest {

    @Test
    public void test() {
        double d = 1234567.12345;
        NumberFormat numberFormat = NumberFormat.getInstance();
        String defaultStr = numberFormat.format(d);

        String currency = NumberFormat.getCurrencyInstance().format(d);
        String percent = NumberFormat.getPercentInstance().format(d);

        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setRoundingMode(RoundingMode.HALF_EVEN);

        System.out.println(Arrays.asList(defaultStr, currency, percent));

    }
}
