package com.ping.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// retrueve bean from spring container
		//Coach theCoach = context.getBean("")
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		// call methods on the bean
			System.out.println(theCoach.getDailyWorkout());	
			System.out.println(theCoach.getDailyFortune());	
			
			//call ort new methods to get the literal values
			System.out.println(theCoach.getEmailAddress());
			System.out.println(theCoach.getTeam());
		// close the context.
		context.close();
	}

}
