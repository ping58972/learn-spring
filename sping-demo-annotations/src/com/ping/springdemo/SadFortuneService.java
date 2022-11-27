package com.ping.springdemo;


public class SadFortuneService implements FortuneService {

	@Override
	public String getFurtune() {
		return "Today is a sad day?" ;
	}

}
