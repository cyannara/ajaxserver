package com.yedam.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan(basePackages = "")
public class BootRestServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootRestServerApplication.class, args);
	}

}
