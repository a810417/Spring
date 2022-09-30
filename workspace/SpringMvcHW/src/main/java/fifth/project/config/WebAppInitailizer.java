package fifth.project.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitailizer extends AbstractAnnotationConfigDispatcherServletInitializer {

	// 設定相當於 beans.config.xml 的 Java 程式組態
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	// 設定相當於mvc-servlet.xml的Java程式組態
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebAppConfig.class };
//		return null;
	}

	// 設定url-pattern
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
//		return null;
	}

	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter cef1 = new CharacterEncodingFilter("UTF-8", true);
		return new Filter[] { cef1 };
	}

}
