package com.study.my;

//import com.study.my.repository.PropertyRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableConfigurationProperties(PropertyRepository.class)
public class MySpringBootPropertyApplication {
	public static void main(String[] args) {
		SpringApplication.run(MySpringBootPropertyApplication.class, args);
	}
}
