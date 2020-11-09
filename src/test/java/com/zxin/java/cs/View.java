package com.zxin.java.cs;

/**
 * @author zxin
 */
public class View {

    private Object o = new Integer(2000);

    public Object getO() {
        System.out.println("a" + o);
        return o;
    }

    public void setO(Object o) {
        synchronized(this.o){
            Integer i = new Integer(3000);
            this.o = i++;
            this.o = o;
        }
    }
}
