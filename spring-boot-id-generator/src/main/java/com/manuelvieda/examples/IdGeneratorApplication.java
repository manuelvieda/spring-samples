package com.manuelvieda.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Manuel E. Vieda
 */
@SpringBootApplication
@EnableTransactionManagement
public class IdGeneratorApplication {

	/**
	 * Spring boot application main
	 *
	 * @param args Application arguments
	 */
	public static void main(String[] args) {

		SpringApplication.run(IdGeneratorApplication.class, args);
	}
}
