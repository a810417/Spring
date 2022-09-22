package tw.tylu.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("workerService") // <bean id="workerService" class="tw.tylu.model.WorkerService"/>
public class WorkerService {
	@Autowired
	private WorkerDao workerDao;

	public void printResult() {
		workerDao.printResult();
	}

}
