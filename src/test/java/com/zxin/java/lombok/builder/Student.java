package com.zxin.java.lombok.builder;

import lombok.Builder;
import lombok.Data;

/**
 * @author zxin
 */
@Builder
@Data
public class Student {

    private int id;

    private String name;

    private Integer age;

}
