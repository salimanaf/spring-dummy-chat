package com.demo.chat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class JpaConfig {

	@Bean
	public AuditorAware<?> auditorAware() {
		return new SpringSecurityAuditorAware();
	}
}