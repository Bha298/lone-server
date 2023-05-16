package com;

import com.entity.Lone;
import com.rep.LoanRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class LoneServerApplication {

	@Autowired
	private LoanRep loanRep;

	public static void main(String[] args) {
		SpringApplication.run(LoneServerApplication.class, args);
	}

@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
}

@PostConstruct
	public void setupData() {
	loanRep.saveAll(Arrays.asList(
			Lone.builder().id(1).type("personal").amount(2000.0).interest(0.0).build(),
			Lone.builder().id(2).type("personal").amount(4000.0).interest(0.0).build(),
			Lone.builder().id(3).type("personal").amount(3000.0).interest(0.0).build()
	));

	}

}
