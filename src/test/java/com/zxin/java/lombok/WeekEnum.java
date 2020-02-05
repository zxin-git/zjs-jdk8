package com.zxin.java.lombok;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

/**
 * @author zxin
 */
@Getter
@Accessors(fluent = true)
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum WeekEnum {

    ;
    Integer value;
    String code;

}
