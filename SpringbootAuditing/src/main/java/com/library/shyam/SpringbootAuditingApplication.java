package com.library.shyam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.library.shyam.audit.AuditorAwareImpl;


@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@SpringBootApplication
public class SpringbootAuditingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAuditingApplication.class, args);
	}

	@Bean
	public AuditorAware<String> auditorAware(){
		return new AuditorAwareImpl();
	}
}
