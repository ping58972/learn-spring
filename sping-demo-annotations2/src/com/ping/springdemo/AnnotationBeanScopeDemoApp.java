package com.ping.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		//read spring config file
				ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
				
				//get the bean from spring container
				Coach theCoach = context.getBean("tennisCoach", Coach.class);
				//call a method on the bean
				Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
				
				boolean result = (theCoach == alphaCoach);
				
				//print out the results
				System.out.println("Pointing to the same object: " + result);
				
				System.out.println("Memory location for theCoach: " + theCoach);
				System.out.println("Memory location for theCoach: " + alphaCoach);
				
				//close the context
				context.close();
	}

}
