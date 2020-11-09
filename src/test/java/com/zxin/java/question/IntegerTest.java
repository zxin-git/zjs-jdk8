package com.zxin.java.question;

/**
 * @author zxin
 */
public class IntegerTest {
    public static void main(String[] args) {
        Integer b1 = Integer.valueOf(1);
        Integer c1 = Integer.valueOf("1");
        Integer d1 = Integer.parseInt("1");
        Integer a1 = new Integer(1);
        Integer e1 = 1;

        System.out.println("a1 == b1:" + (a1 == b1));
        System.out.println("b1 == c1:" + (b1 == c1));
        System.out.println("b1 == d1:" + (b1 == d1));
        System.out.println("c1 == d1:" + (c1 == d1));
        System.out.println("b1 == e1:" + (b1 == e1));

        Integer b2 = Integer.valueOf(128);
        Integer c2 = Integer.valueOf("128");
        System.out.println("b2 == c2:" + (b2 == c2));
    }
}
