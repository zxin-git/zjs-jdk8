package com.zxin.java.jdk.zother;

import lombok.Data;

import java.io.Serializable;

@Data
public class Person implements Serializable, Cloneable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private short num;
	private long phone;
	private boolean sex;	//man 1  woman 0
	private float f;
	private double money;
	private byte b;
	private char c;
	
	public Person clone() throws CloneNotSupportedException{
		return (Person)super.clone();
	}
	
}
