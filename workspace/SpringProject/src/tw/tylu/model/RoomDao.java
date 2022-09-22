package tw.tylu.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value="roomDao") // <bean id="roomDao" class="tw.tylu.model.RoomDao" />
public class RoomDao {

	@Autowired
	private Room room;
	
	public void showInfo() {
		System.out.println(room.getId()+" "+room.getName()+" "+room.getSize());
	}
	
}
