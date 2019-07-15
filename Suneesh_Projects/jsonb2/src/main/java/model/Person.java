package model;

import org.jboss.logging.Logger;

public class Person {

	private static final Logger log = Logger.getLogger(Person.class);

	private String name;
	private int age;
	private String DOB;
	private Double salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", DOB=" + DOB + ", salary=" + salary + "]";
	}

	public Person(String name, int age, String dOB, Double salary) {
		super();
		log.info("START");

		this.name = name;
		this.age = age;
		DOB = dOB;
		this.salary = salary;
	}

}
