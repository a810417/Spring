package tw.tylu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tw.tylu.model.Animal;

@Configuration
public class SpringJavaConfig {

	@Bean
	public Animal animal() {
		Animal a1 = new Animal();
		return a1;
	}
}
