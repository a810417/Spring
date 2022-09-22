package tw.tylu.model;

import java.util.Date;

public class Person {
	
	private String name;
	
	private int age;
	
	private Date mydate;

	public Person() {}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {return name;}
	public int getAge() {return age;}	
	public Date getMydate() {return mydate;}

	public void setName(String name) {this.name = name;}
	public void setAge(int age) {this.age = age;}
	public void setMydate(Date mydate) {this.mydate = mydate;}
	
}
