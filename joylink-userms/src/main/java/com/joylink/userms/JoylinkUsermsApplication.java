package com.joylink.userms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages= {"com.joylink.userms.dao"})
public class JoylinkUsermsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JoylinkUsermsApplication.class, args);
	}
}
