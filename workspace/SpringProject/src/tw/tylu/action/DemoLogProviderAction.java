package tw.tylu.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tw.tylu.util.LogProvider;

public class DemoLogProviderAction {

	public static void main(String[] args) {
		// 讀取組態檔
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		
		// 透過 id 向 Spring 要求一個 bean
		// getBean() 會回傳 Object 型別的物件，須強制轉型為自設的 LogProvider 物件
		LogProvider logger = (LogProvider)context.getBean("logProvider");
		logger.log("Have a nice day!");
		
		// 用完關閉
		// context 為 LogProvider 型別，轉型為 ConfigurableApplicationContext 型別才能關閉(才有 ".close()"方法)
		((ConfigurableApplicationContext)context).close();

	}

}
