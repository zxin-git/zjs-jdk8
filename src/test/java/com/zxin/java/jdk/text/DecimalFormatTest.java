package com.zxin.java.jdk.text;

import org.junit.Test;

import java.text.DecimalFormat;
import java.util.Arrays;

public class DecimalFormatTest {

    @Test
    public void test() {
        double d = 1234567.123456789;
        DecimalFormat decimalFormat = new DecimalFormat(",###.##%");
        String percent = decimalFormat.format(d);

        decimalFormat.applyPattern(",###.###\u2030");
        String milleStr = decimalFormat.format(d);

        decimalFormat.applyPattern(".##");
        String twoScale = decimalFormat.format(d);

        decimalFormat.applyPattern(",###");
        String integerStr = decimalFormat.format(d);

        System.out.println(Arrays.asList(percent, milleStr, twoScale, integerStr));

        // 不足自动填充0
        decimalFormat.applyPattern("0000000000");
        String fill = decimalFormat.format(12345);
        System.out.println(fill);

    }
}
