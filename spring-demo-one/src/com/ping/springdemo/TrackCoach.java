package com.ping.springdemo;

public class TrackCoach implements Coach {
	private FortuneService forturneService;
	
	public TrackCoach(FortuneService forturneService) {
		this.forturneService = forturneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run a hard 5K";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "Just do it: " + forturneService.getFortune();
	}
	
	// add an init method
	public void doMyStartUpStuff() {
		System.out.println("TrakCoach: inside method doMyStartupStuff");
	}
	//add a destroy method
	public void doMyCleanupStuffYoYo() {
		System.out.println("TrackCoach: inside method doMyCleanupStuffYoYo");
	}
}
