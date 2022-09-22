package tw.tylu.model;

import org.springframework.stereotype.Component;

@Component(value = "room") // 即之前 beans.config.xml 中設定的 <bean id="room" class="tw.tylu.model.Room" />

public class Room {

	private int id;
	private String name;
	private String size;

	public Room() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

}
