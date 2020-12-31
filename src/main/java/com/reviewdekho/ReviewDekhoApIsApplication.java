package com.reviewdekho;

import java.util.Date;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReviewDekhoApIsApplication {

	@PostConstruct
	public void init() {
		System.out.println("From init...");
		TimeZone.setDefault(TimeZone.getTimeZone("IST"));
		System.out.println(new Date());
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ReviewDekhoApIsApplication.class, args);
	}

}
