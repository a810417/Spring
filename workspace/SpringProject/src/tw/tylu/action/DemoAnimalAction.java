package tw.tylu.action;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import tw.tylu.config.SpringJavaConfig;
import tw.tylu.model.Animal;

public class DemoAnimalAction {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfig.class);
		
		Animal animal = context.getBean("animal", Animal.class);
		animal.setId(1);
		animal.setName("elephant");
		animal.setContinent("Asia");
		System.out.println(animal.getId()+" "+animal.getName()+" "+animal.getContinent());		
		
		context.close();
	}

}
