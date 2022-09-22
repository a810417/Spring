package tw.tylu.action;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import tw.tylu.model.TruckBean;
import tw.tylu.model.TruckBeanStaticFactory;

public class DemoTruckBeanAction {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
				
		TruckBean hondaTruck = context.getBean("hondaTruck", TruckBean.class);
		System.out.println(hondaTruck.getId()+" "+hondaTruck.getBrand());
		
		
		TruckBean toyotaTruck = context.getBean("toyotaTruck", TruckBean.class);
		System.out.println(toyotaTruck.getId()+" "+toyotaTruck.getBrand());
		
		TruckBean nissanTruck = context.getBean("nissanTruck", TruckBean.class);
		System.out.println(nissanTruck.getId()+" "+nissanTruck.getBrand());
		
		TruckBean ferrariTruck = context.getBean("ferrariTruck", TruckBean.class);
		System.out.println(ferrariTruck.getId()+" "+ferrariTruck.getBrand());
		
		TruckBean subaruTruck = context.getBean("subaruTruck", TruckBean.class);
		System.out.println(subaruTruck.getId()+" "+subaruTruck.getBrand());
		
		context.close();
	}

}
