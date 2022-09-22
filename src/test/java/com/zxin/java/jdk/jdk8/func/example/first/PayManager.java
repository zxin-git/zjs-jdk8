package com.zxin.java.jdk.jdk8.func.example.first;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * @author zxin
 */
public class PayManager {

    static IPayService payService;


    public static void main(String[] args) {
        ap(payService::h1).apply(new H1Request());
    }


    public static <R extends IUrl, T> Function<R, T> ap(Function<R, T> function){
        UnaryOperator<R> operator = r -> {
            r.setUrl(r.getUrl().replaceAll("localhost", "127.0.0.1"));
            return r;
        };
        return function.compose(operator);
    }

}
