package com.zxin.java.jdk.zother;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataTest {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void cloneTest(){
		Person person = new Person();
		person.setName("zzzz");
		try {
			Person personClone = person.clone();
			logger.debug(personClone.getName());
		} catch (CloneNotSupportedException e) {
			logger.debug("",e);
		}
	}
}
