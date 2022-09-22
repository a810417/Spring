package tw.tylu.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("workerDao") // beans.config.xml: <bean id="workerDao" class="tw.tylu.model.WorkerDao" />
public class WorkerDao {
//	@Autowired
//	@Qualifier("worker2") // Worker 已註冊兩組 bean: worker1, worker2，指定使用 worker1 or worker2
	private Worker worker;

	public WorkerDao() {
		this.worker = worker;
	}
	@Autowired
	public WorkerDao(@Qualifier("worker1")Worker worker) {
		this.worker = worker;
	}

	public void printResult() {
		System.out.println(worker.getId() + " " + worker.getName() + " " + worker.getTitle());
	}
}
