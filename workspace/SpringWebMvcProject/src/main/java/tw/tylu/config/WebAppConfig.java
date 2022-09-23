package tw.tylu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// 相當於 mvc-servlet.xml 的 Java 程式組態
@Configuration
// 相當於 namespaces 的 beans
@EnableWebMvc
// 相當於 namespaces 裡的 mvc
@ComponentScan(basePackages = "tw.tylu")
// 相當於<context:component-scan base-package="tw.tylu"/>
public class WebAppConfig implements WebMvcConfigurer {

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();

	}

	@Bean
	public InternalResourceViewResolver viewResolver1() {
		InternalResourceViewResolver irv1 = new InternalResourceViewResolver();
		irv1.setPrefix("/WEB-INF/pages/");
		irv1.setSuffix(".jsp");
		irv1.setOrder(6);
		return irv1;
	}

	@Bean
	public InternalResourceViewResolver viewResolver2() {
		InternalResourceViewResolver irv1 = new InternalResourceViewResolver();
		irv1.setPrefix("/WEB-INF/pages/");
		irv1.setSuffix(".html");
		irv1.setOrder(6);
		return irv1;
	}

}
