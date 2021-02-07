package org.oaknorth.springelastic;

import org.oaknorth.springelastic.audit.AuditorAwareImpl;
import org.oaknorth.springelastic.audit.LocalDateTimeProvider;
import org.oaknorth.springelastic.config.ElasticSearchConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.elasticsearch.config.EnableElasticsearchAuditing;
import org.springframework.data.elasticsearch.repository.config.EnableReactiveElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = FlywayAutoConfiguration.class)
@EnableJpaRepositories(basePackages = "org.oaknorth.springelastic.repository.jpa")
@EnableJpaAuditing(auditorAwareRef = "auditorAware",modifyOnCreate = false,dateTimeProviderRef = "dateTimeProvider")
@Import(value = {ElasticSearchConfiguration.class})
public class ElasticSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElasticSearchApplication.class, args);
	}

	@Bean
	public AuditorAware<String> auditorAware() {
		return new AuditorAwareImpl();
	}

	@Bean
	public DateTimeProvider dateTimeProvider() {
		return new LocalDateTimeProvider();
	}

}
