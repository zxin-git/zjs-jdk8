package com.zxin.java.javax.xml;

import javax.xml.bind.JAXB;
import java.io.StringReader;
import java.io.StringWriter;

public class Jaxb7Util {

	public static <T> T toBean(String xml, Class<T> type){
		return JAXB.unmarshal(new StringReader(xml), type);
	}
	
	public static <T> String toXml(T t){
		StringWriter xml = new StringWriter();
		JAXB.marshal(t, xml);
		return xml.toString();
	}
	
	public static void main(String[] args) {
		User user = new User();
    	user.setAge(1);
    	user.setRole("rolessss");
    	user.setBibi("bbbbbb");
    	String xml = Jaxb7Util.toXml(user);
    	System.out.println(xml);
		
		User user2 = Jaxb7Util.toBean(xml, User.class);
		System.out.println(user2.equals(user));
		
	}
	
}