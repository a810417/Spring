package tw.tylu.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

// 相當於 mvc-servlet.xml 的 Java 程式組態
@Configuration
// 相當於 namespaces 的 beans
@EnableWebMvc
// 相當於 namespaces 裡的 mvc
@ComponentScan(basePackages = "tw.tylu")
// 相當於<context:component-scan base-package="tw.tylu"/>
public class WebAppConfig implements WebMvcConfigurer {

	@Bean
	public MappingJackson2JsonView jsonView() {
		MappingJackson2JsonView mappingJsonView = new MappingJackson2JsonView();
		mappingJsonView.setPrettyPrint(true);
		return mappingJsonView;
	}
	
	@Bean
	public Jaxb2Marshaller jaxb2Marshaller() {
		Jaxb2Marshaller jaxb = new Jaxb2Marshaller();
		jaxb.setPackagesToScan("tw.tylu");
		return jaxb;
	}
	
	@Bean
	public ContentNegotiatingViewResolver negoViewResolver() {
		ContentNegotiatingViewResolver vr1 = new ContentNegotiatingViewResolver();
		
		ArrayList<View> list = new ArrayList<View>();
		list.add(jsonView());
		
		vr1.setDefaultViews(list);
		return vr1;
	}
	
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

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/resources/images/");
		registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/resources/css/");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "membersmain.controller");
		registry.addViewController("/funny.day").setViewName("loginSystem");
	}

	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver cmr1 = new CommonsMultipartResolver();
		cmr1.setDefaultEncoding("UTF-8");
		return cmr1;
	
	}

}
