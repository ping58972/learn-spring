package com.unitedairline.ping.flightsearch;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.unitedairline.ping.flightsearch.service.FlightService;
import com.unitedairline.ping.flightsearch.entity.Flight;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class FlightSearchApplication {

	@Autowired
	  private ObjectMapper objectMapper;
	
	public static void main(String[] args) {
		SpringApplication.run(FlightSearchApplication.class, args);
	}
	
	  @PostConstruct
	  public void setUp() {
		  objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	    objectMapper.registerModule(new JavaTimeModule());
	  }

	@Bean
	CommandLineRunner runner(FlightService flightService) {
		return Args -> {
			// read JSON and load json
			ObjectMapper mapper = new ObjectMapper();
			objectMapper.findAndRegisterModules();
			TypeReference<List<Flight>> typeReference = new TypeReference<List<Flight>>() {
			};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/flight-sample.json");
			try {
				List<Flight> fights = mapper.readValue(inputStream, typeReference);
				flightService.save(fights);
				System.out.println("Flight Saved!");
			} catch (IOException e) {
				System.out.println("Unable to save Flight: " + e.getMessage());
			}
		};
	}
    @Bean
    public FilterRegistrationBean<CorsFilter> simpleCorsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
        config.setAllowedMethods(Collections.singletonList("*"));
        config.setAllowedHeaders(Collections.singletonList("*"));
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}
