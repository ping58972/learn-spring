package com.ping.springdemo;

import org.springframework.stereotype.Component;

@Component
public class HappyfortuneService2 implements FortuneService {

	@Override
	public String getFurtune() {
		// TODO Auto-generated method stub
		return "Today is your lucky day!22222222";
	}

}
