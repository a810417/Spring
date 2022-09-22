package tw.tylu.action;

import java.sql.SQLException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import tw.tylu.model.House;
import tw.tylu.model.HouseService;

public class DemoHouseAction {

	public static void main(String[] args) throws SQLException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		
		HouseService houseService = context.getBean("houseService", HouseService.class);
		House resultBean = houseService.findById(1002);

		if(resultBean!=null) {
			System.out.println(resultBean.getHouseid()+" "+resultBean.getHousename());
		}else {
			System.out.println("No result!!");
		}
		
		context.close();
	}

}
