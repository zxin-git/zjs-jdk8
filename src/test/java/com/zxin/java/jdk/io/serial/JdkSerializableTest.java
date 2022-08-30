package com.zxin.java.jdk.io.serial;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * @author zxin
 */
public class JdkSerializableTest {

    public static void write(Object obj) {
        try (OutputStream os = new FileOutputStream("e:/a")){
            ObjectOutputStream oo = new ObjectOutputStream(os);
            oo.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read(){
        try (InputStream im	= new FileInputStream("e:/a")){
            ;
            ObjectInputStream oi = new ObjectInputStream(im);
            Object clone = oi.readObject();
            System.out.println(clone);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void byteClone(){
        try {
            Object obj = new StringBuilder("aaa");
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            oo.writeObject(obj);
            oo.close();

            ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
            ObjectInputStream oi = new ObjectInputStream(bi);
            StringBuilder clone = (StringBuilder) oi.readObject();
            System.out.println(clone);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
