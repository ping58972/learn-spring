package com.ping.springdemo;

//import javax.annotation.PostConstruct; //using only on java se-8

import org.springframework.beans.factory.DisposableBean; // using on java se-9+
import org.springframework.beans.factory.InitializingBean; // using on java se-9+
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class TennisCoach implements Coach, InitializingBean, DisposableBean {
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

//	@Autowired
//	public TennisCoach(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}

	// define a default constructor
	
	public TennisCoach() {
		System.out.println(">> TennisCoach: inside default constructor");
	}
	
	//define my init method
	//@PostConstruct //use for only on java se-8
	public void doMyStartupStuff() {
		System.out.println(">> TennisCoach: inside of doMyStartupStuff()");
	}
	//define my destroy method
	//@PreDestroy //use for only on java se-8
	public void doMyCleanupStuff() {
		System.out.println(">> TennisCoach: inside of doMyCleanupStuff()");
	}
	
//	@Autowired
//	public void setFortuneService(FortuneService fortuneService) {
//		System.out.println(">> TennisCoach: inside setFortuneService() method");
//		this.fortuneService = fortuneService;
//	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practicr your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFurtune();
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		doMyCleanupStuff();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		doMyStartupStuff();
	}
	
//	@Autowired
//	public void doSomeCrazyStuff(FortuneService theFortuneService) {
//		System.out.println("TennisCoach: inside doSomeCrazyStuff() method");
//		this.fortuneService = theFortuneService;
//	}

}
