package com.ashi.entities;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Moter {

	public Moter() {
		System.out.println("Motor :: Constructor object-created");
	}

	@PostConstruct
	public void start() {
		System.out.println("Motor started....");
	}

	public void doWork() {
		System.out.println("Motor Pulling Water...");
	}

	@PreDestroy
	public void stop() {
		System.out.println("Motor stopped.....");
	}


}
