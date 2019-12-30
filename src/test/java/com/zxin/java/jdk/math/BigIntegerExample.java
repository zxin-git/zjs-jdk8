package com.zxin.java.jdk.math;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;

/**
 *
 * <ul>
 *     <li>1. -16到16的常量缓存</li>
 *     <li>2. 存储结构为int数组，高位在[0]</li>
 * </ul>
 *
 * @author zxin
 */
public class BigIntegerExample {

    @Test
    public void constructor() {
        // -16 16 缓存 MAX_CONSTANT
        BigInteger constantBI = BigInteger.valueOf(10);
        BigInteger longBI = BigInteger.valueOf(1000L);
        BigInteger strBI = new BigInteger("333");   //decimal（十进制）
        BigInteger strHexBI = new BigInteger("ff", 16);

        System.out.println(Arrays.asList(constantBI, longBI, strBI, strHexBI));
    }

    @Test
    public void field() {
        BigInteger bi = new BigInteger("111");
        long longValue = bi.longValue();
        String string = bi.toString();
        String radixString = bi.toString(8);

        System.out.println(Arrays.asList(longValue, string, radixString));
    }

    @Test
    public void action(){
        BigInteger a = new BigInteger("111");
        BigInteger b = new BigInteger("222");

        a.abs();

        //算术
        BigInteger addBI = a.add(b);
        BigInteger subtractBI = a.subtract(b);
        BigInteger multiplyBI = a.multiply(b);
        BigInteger divideBI = a.divide(b);

        BigInteger modBI = a.mod(b);
        BigInteger powBI = a.pow(20);

        //位运算
        a.and(b);
        a.or(b);
        a.not();
        a.xor(b); //异或

        a.andNot(b);

        //GCD（最大公约数）
        a.gcd(b);
    }

}
