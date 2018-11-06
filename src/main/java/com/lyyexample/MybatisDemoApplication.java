package com.lyyexample;

import com.lyyexample.Listener.PreparedListener;
import com.lyyexample.Listener.ReadyListener;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@MapperScan("com.lyyexample.mapper")
public class MybatisDemoApplication {

	public static void main(String[] args) {
//		SpringApplication.run(MybatisDemoApplication.class, args);
		SpringApplication app = new SpringApplication(MybatisDemoApplication.class);
		app.addListeners(new PreparedListener());
		app.addListeners(new ReadyListener());
		app.run(args);
	}

	@Bean
	public RestTemplate getRestTemplate(){
		RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
		restTemplateBuilder.setConnectTimeout(60000);
		restTemplateBuilder.setReadTimeout(60000);
		return restTemplateBuilder.build();
	}
}
