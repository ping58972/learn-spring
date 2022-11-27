package com.ping.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.ping.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {
	// define bean for out sad fortune service
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	// define bean for out swim coach AND inject dependency
	@Bean
	public Coach swinCoach() {
		return new SwimCoach(sadFortuneService());
	}
}
