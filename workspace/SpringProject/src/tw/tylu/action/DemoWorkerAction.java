package tw.tylu.action;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import tw.tylu.model.WorkerService;

public class DemoWorkerAction {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		
		// workerService -> 呼叫 workerDao
		// workerDao -> 呼叫 worker1 or worker2
		// 透過設定 workerDao 呼叫的對象達到取得指定資料的目的
		WorkerService workerService = context.getBean("workerService", WorkerService.class);
		workerService.printResult();
		
		context.close();
	}

}
