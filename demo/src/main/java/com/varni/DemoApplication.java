package com.varni;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication

public class DemoApplication implements CommandLineRunner{

	@Autowired
	Environment env;
	
	public static final Log LOGGER=LogFactory.getLog(DemoApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
	}
	
	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("Implementing Command Line Runner");
		LOGGER.info(env.getProperty("message"));
		
	}

}
