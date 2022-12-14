package tw.tylu.action;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import tw.tylu.model.LoginService;

public class DemoLoginAction {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		
		LoginService loginService1 = context.getBean("loginService1", LoginService.class);
		LoginService loginService2 = context.getBean("loginService2", LoginService.class);
		
		// 測試1 - Constructor DI
		boolean result1 = loginService1.checkLogin("john", "test123");
		System.out.println("result1: "+result1);
		
		boolean result2 = loginService1.checkLogin("jerry", "666");
		System.out.println("result2: "+result2);

		System.out.println();
		
		// 測試2 - Setter DI
		boolean result3 = loginService2.checkLogin("john", "test123");
		System.out.println("result3: "+result3);
		
		boolean result4 = loginService2.checkLogin("Mary", "777");
		System.out.println("result4: "+result4);
		
		context.close();
	}

}
