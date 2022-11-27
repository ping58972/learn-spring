package com.ping.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
//		Coach alphaCoach = context.getBean("myCoach", Coach.class);
//		//check if they are the same
//		boolean result = (theCoach == alphaCoach);
//		//print out the result
//		System.out.println("Pointing to the same object "+ result);
//		
//		System.out.println("Memory location for theCoach: " + theCoach);
//		System.out.println("Memory location for alphaCoach: " + alphaCoach + "\n");
		
		System.out.println(theCoach.getDailyWorkout());
		//close the context
		context.close();
	}

}
