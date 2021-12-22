package com.mb.app.ws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.mb.app.ws.service.impl.AuditorAwareImpl;

@Configuration
@EnableJpaAuditing
public class AuditingConfig {
	
	@Bean
	public AuditorAware<String> auditorAware() {
		return new AuditorAwareImpl();
	}
}
