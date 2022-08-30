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

}
