package jpa.myboard.configuration;

import jpa.myboard.security.MyPasswordEncoder;
import jpa.myboard.security.PasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new MyPasswordEncoder();
	}
}
