package com.zxin.java.jdk.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;
import java.util.Scanner;

/**
 * @author zxin
 */
@Slf4j
public class ScannerTest {

    @Test
    public void scan(){
        File file = new File("C:\\Users\\zxin\\Documents\\tmp\\output.xml");
        try(Scanner scanner = new Scanner(file);) {
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println(line);
                Thread.sleep(10);
            }
        } catch (Exception e) {
            log.warn("", e);
        }
    }

}
