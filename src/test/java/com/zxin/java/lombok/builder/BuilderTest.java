package com.zxin.java.lombok.builder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author zxin
 */

public class BuilderTest {

    /**
     * 测试预置属性是否可以复制
     *
     */
    @Test
    public void presetTest() {
        Student.StudentBuilder studentBuilder = Student.builder().age(999).name("preset");
        Student s1 = studentBuilder.id(1).build();
        Student s2 = studentBuilder.id(2).build();
        Assert.assertEquals(s1.getAge(), s2.getAge());
        Assert.assertEquals(s1.getName(), s2.getName());
        System.out.println(Arrays.asList(s1, s2));
    }
}
