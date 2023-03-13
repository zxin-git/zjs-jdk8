package com.zxin.java.jdk.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author zxin
 */
public class FileTest {

    @Test
    public void test() throws IOException {
        // 本地临时文件
        File file = File.createTempFile("file-a", ".txt");
        System.out.println(file);
    }

    public static void main(String[] args) {
        fileTest();

    }

    public static void fileTest(){
        try {
            File file = new File("E:/zxin/developer/tmp/file");
            System.out.println(file.getName());	//名称
            System.out.println(file.getParent());	//父全路径
            System.out.println(file.getPath());
            System.out.println(file.getParentFile());
            System.out.println(file.listFiles());	//数组
            System.out.println(file.getFreeSpace());
            System.out.println(file.getCanonicalPath());//抽象路径
            System.out.println(file.getAbsolutePath());//抽象路径
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    
    @Test
    public void testPath(){
    
    }

}
