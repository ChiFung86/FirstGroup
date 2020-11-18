package com.wyu.StudentInfoSys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.wyu.StudentInfoSys.mapper")
@SpringBootApplication
public class StudentInfoSysApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentInfoSysApplication.class, args);
	}

}
