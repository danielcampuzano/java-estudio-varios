package com.co.storeback;

import java.util.TimeZone;
import java.util.concurrent.Executor;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@EnableAsync
public class StoreBackApplication {

	@Value("${spring.jpa.properties.hibernate.jdbc.time_zone}")
	private String defaultTimeZone;
	
	@PostConstruct
    public void init(){
        TimeZone.setDefault(TimeZone.getTimeZone(defaultTimeZone)); 
    }
	
	public static void main(String[] args) {
		SpringApplication.run(StoreBackApplication.class, args);
	}

	@Bean("messageSource")
	public MessageSource resourceBundleMessageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		messageSource.setCacheSeconds(600);
		return messageSource;
	}

	@Bean("threadPoolTaskExecutor")
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(4);
		executor.setMaxPoolSize(10);
		executor.setQueueCapacity(300);
		executor.setThreadNamePrefix("ThreadPoolUpdateBestSearch-");
		executor.initialize();
		return executor;
	}

}
