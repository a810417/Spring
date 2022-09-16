package tw.tylu.action;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import tw.tylu.model.Person;

public class DemoPersonAction {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");

		Person person1 = context.getBean("person1", Person.class);
		System.out.println(person1.getName() + " " + person1.getAge());

		context.close();
	}
}
