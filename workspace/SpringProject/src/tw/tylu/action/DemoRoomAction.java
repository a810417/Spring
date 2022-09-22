package tw.tylu.action;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import tw.tylu.model.Room;
import tw.tylu.model.RoomDao;
import tw.tylu.model.RoomService;

public class DemoRoomAction {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");

		Room room = context.getBean("room", Room.class);
		room.setId(100);
		room.setName("War room");
		room.setSize("medium");

		System.out.println(room.getId() + " " + room.getName() + " " + room.getSize());

		RoomDao roomDao = context.getBean("roomDao", RoomDao.class);
		roomDao.showInfo();

		RoomService roomService = context.getBean("roomService", RoomService.class);
		roomService.showInfo();

		context.close();
	}

}
