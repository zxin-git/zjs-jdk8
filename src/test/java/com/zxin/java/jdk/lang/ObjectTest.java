package com.zxin.java.jdk.lang;

import java.util.Objects;

/**
 * @author zxin
 */
public class ObjectTest {




    class Handler{
        private String name;
        private int age;
        private boolean sex;
        private long score;
        private double salary;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Handler handler = (Handler) o;
            return age == handler.age &&
                    sex == handler.sex &&
                    score == handler.score &&
                    Double.compare(handler.salary, salary) == 0 &&
                    Objects.equals(name, handler.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, sex, score, salary);
        }
    }

}
