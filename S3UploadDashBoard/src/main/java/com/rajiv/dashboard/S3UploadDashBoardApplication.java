package com.rajiv.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.rajiv.*" })
public class S3UploadDashBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(S3UploadDashBoardApplication.class, args);
	}

}
