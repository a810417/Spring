package tw.tylu.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MultiLangController {

	@Autowired
	private MessageSource ms;
	
	@GetMapping("/multilang.controller")
	public String processAction() {
		Locale myLocale = LocaleContextHolder.getLocale();
		String errMsg = ms.getMessage("program.error", null, myLocale);
		
		System.out.println("Locale:" + myLocale);
		System.out.println("errMsg:" + errMsg);
		
		return "multiLangResult";
	}
}
