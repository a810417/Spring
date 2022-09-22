package tw.tylu.action;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import tw.tylu.model.Person;

public class DemoPersonAction {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");

		Person person1 = context.getBean("person1", Person.class);
		System.out.println(person1.getName() + " " + person1.getAge());

		Person person2 = context.getBean("person2", Person.class);
		System.out.println("Date:" + person2.getMydate());

		Person person3 = context.getBean("person3", Person.class);
		System.out.println(person3.getName() + " " + person3.getAge() + " " + person3.getMydate());
		
		System.out.println("------ HashCode Test ------");
		
		Person person4 = context.getBean("person1", Person.class);
		Person person5 = context.getBean("person1", Person.class);

		System.out.println("person4 hashCode: "+ person4.hashCode());
		System.out.println("person5 hashCode: "+ person5.hashCode());
		
		context.close();
	}
}
