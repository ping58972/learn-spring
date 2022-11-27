package com.ping.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//read spring config class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		//get the bean from spring container
		SwimCoach theCoach = context.getBean("swinCoach", SwimCoach.class);
		//call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		//call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		//call our new swim coach methods... has the props values injected
		System.out.println("email " + theCoach.getEmail());
		System.out.println("Team " + theCoach.getTeam());
		
		//close the context
		context.close();
	}

}
