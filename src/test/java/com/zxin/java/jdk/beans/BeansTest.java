package com.zxin.java.jdk.beans;

import org.junit.Test;

import java.beans.Beans;
import java.io.IOException;

/**
 * @author zxin
 */
public class BeansTest {

    @Test
    public void a(){
        try {
            Object o = Beans.instantiate(this.getClass().getClassLoader(), "com.zxin.java.jdk.zother.Person");
            System.out.println(o);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }




}
