package com.ping.springdemo;

import org.springframework.stereotype.Component;

@Component
public class HappyfortuneService implements FortuneService {

	@Override
	public String getFurtune() {
		// TODO Auto-generated method stub
		return "Today is your lucky day!";
	}

}
