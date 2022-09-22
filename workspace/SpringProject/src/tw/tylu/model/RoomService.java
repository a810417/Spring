package tw.tylu.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "roomService") // <bean id="roomService" class="tw.tylu.model.RoomService"/>
public class RoomService {
	
	@Autowired
	private RoomDao roomDao;

	public void showInfo() {
		roomDao.showInfo();
	}

}
