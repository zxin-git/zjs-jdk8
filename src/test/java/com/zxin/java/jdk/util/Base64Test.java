package com.zxin.java.jdk.util;

import org.junit.Test;

import java.util.Base64;

/**
 * @author zxin
 */
public class Base64Test {

    @Test
    public void test(){
        String data = "数据报文";
        byte[] dataBytes = data.getBytes();

        // 1. 创建 编解码器
        Base64.Encoder encoder = Base64.getEncoder();
        Base64.Decoder decoder = Base64.getDecoder();
//        Base64.Encoder encoder = Base64.getUrlEncoder();
//        Base64.Decoder decoder = Base64.getUrlDecoder();

        // 2. 编码、解码
        byte[] base64Bytes = encoder.encode(dataBytes);
        String base64Str = encoder.encodeToString(dataBytes);
        byte[] raw = decoder.decode(base64Bytes);
        byte[] raw1 = decoder.decode(base64Str);

    }

}
