package com.zxin.java.jdk.math;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Arrays;

/**
 *
 * @author  zxin
 */
public class BigDecimalExample {

    @Test
    public void constructor(){
        BigDecimal stringBD = new BigDecimal("1.34");
        BigDecimal doubleBD = BigDecimal.valueOf(1.45D);
        BigDecimal longBD = BigDecimal.valueOf(1000L);
    }

    @Test
    public void action() {
        BigDecimal a = new BigDecimal("0.98");
        BigDecimal b = new BigDecimal("1.04");

        BigDecimal addBD = a.add(b);
        BigDecimal subBD = a.subtract(b);
        BigDecimal multiplyBD = a.multiply(b);

        BigDecimal divideBD = a.divide(b);
        a.divide(b, RoundingMode.HALF_DOWN);
        a.divide(b, 2, RoundingMode.HALF_EVEN);

        a.pow(2);

        a.max(b);
        a.min(b);
        a.compareTo(b);

        a.negate();
    }

    @Test
    public void perform() {
        BigDecimal a = new BigDecimal("1.0123456789");
        String str = a.toString();
        String plainStr = a.toPlainString(); // ?
        String percentStr = NumberFormat.getPercentInstance().format(a);
        String currencyStr = NumberFormat.getCurrencyInstance().format(a);
        System.out.println(Arrays.asList(str, plainStr, percentStr, currencyStr));
    }
}
