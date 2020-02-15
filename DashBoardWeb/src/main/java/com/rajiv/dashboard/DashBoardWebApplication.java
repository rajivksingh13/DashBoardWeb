package com.rajiv.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.rajiv.*" })
public class DashBoardWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(DashBoardWebApplication.class, args);
	}

}
