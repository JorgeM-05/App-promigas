package com.promigasapp.apppromigas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class AppPromigasApplication implements CommandLineRunner {

	private JdbcTemplate jdbcTemplate;
	public static void main(String[] args) {
		SpringApplication.run(AppPromigasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
