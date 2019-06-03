package com.springboot.musicdb;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication 
@EnableJpaAuditing
public class MusicDBApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicDBApplication.class, args);
	}
}
