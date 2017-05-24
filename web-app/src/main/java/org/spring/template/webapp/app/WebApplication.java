package org.spring.template.webapp.app;

import org.spring.template.core.config.CoreConfig;
import org.spring.template.datastore.config.DataStoreConfig;
import org.spring.template.service.config.ServiceConfig;
import org.spring.template.webapp.config.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication(scanBasePackages = "org.spring.template.webapp")
@Import({CoreConfig.class,WebConfig.class,ServiceConfig.class,DataStoreConfig.class})
@EnableCaching(proxyTargetClass=true)
@CrossOrigin(origins = "http://localhost:4200")
public class WebApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);

	}
}
