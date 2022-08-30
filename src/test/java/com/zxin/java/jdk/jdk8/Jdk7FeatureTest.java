package com.zxin.java.jdk.jdk8;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author zxin
 */
public class Jdk7FeatureTest {

    void intNew(){
        int a = 123_456;	// 下划线分割
        System.out.println(a);

        int binary = 0b11;	// 二进制 字面量
        int hex = 0xea;     // 十六进制
        int octal = 074;    // 八进制
        System.out.println(binary);
    }

    void tryWithResource() { // try with resource
        try (FileReader fr = new FileReader("E:\\zikao\\file\\cs.txt"); FileWriter fw = new FileWriter("E:\\zikao\\file\\cs1.txt")) {
            int ch = 0;
            while ((fr.read()) != -1) {
                fw.write(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void switchStr(){ // switch支持String
        int num = 0;
        String str = "h";
        switch (str) {
            case "a": num = 1; break;
            case "z": num = 26; break;
            default: num = -1; break;
        }
        System.out.println(num);
    }

    void other(){
        // 泛型简化
        ArrayList<String> array = new ArrayList<>();

        // 异常的多个catch合并
    }

}
