package com.example.lab9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestLab9Application {

	public static void main(String[] args) {
		SpringApplication.from(Lab9Application::main).with(TestLab9Application.class).run(args);
	}

}
