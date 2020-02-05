package com.zxin.java.lombok;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * @author zxin
 */
@Data
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    int id;

    String name;

    Integer age;

    boolean man;
}
