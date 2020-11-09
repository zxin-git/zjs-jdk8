package com.zxin.java.cs;

import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * @author zxin
 */
public class CharTest {

    public static void main(String[] args) {
        String s = "中";
        char c = '中';
        System.out.println(Arrays.toString(s.getBytes(Charset.forName("UTF-8"))));
        System.out.println(Arrays.toString(s.getBytes(Charset.forName("UTF-16"))));
        System.out.println(Arrays.toString(s.getBytes(Charset.forName("GBK"))));
        System.out.println();
    }

    public String hex(Byte[] bytes){
        return null;
    }
}
