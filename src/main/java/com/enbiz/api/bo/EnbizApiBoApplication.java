package com.enbiz.api.bo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.enbiz.api","com.enbiz.common"})
public class EnbizApiBoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnbizApiBoApplication.class, args);
	}

}
