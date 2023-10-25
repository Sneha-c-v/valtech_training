package firstWeb;

import java.util.Comparator;

public class Employee  {
	private int id;
	private String name;
	private  int age;
	private int experience;
	private int seniority;
	private int salary;
	private int dept_id;
	public Employee() {}
	
	public Employee(String name, int age, int experience, int seniority, int salary,int dept_id) {
		this.name = name;
		this.age = age;
		this.experience = experience;
		this.seniority = seniority;
		this.salary = salary;
		this.dept_id=dept_id;
	}

	public Employee(int id,String name,int age,int experience,int seniority,int salary,int dept_id){
		 super();
		 this.id=id;
		 this.seniority=seniority;
		 this.experience=experience;
		 this.age=age;
		 this.name=name;
		 this.salary=salary;
		 this.dept_id=dept_id;
	}
	
	
	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", experience=" + experience + ", seniority="
				+ seniority + ", salary=" + salary + ", dept_id=" + dept_id + "]";
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getSeniority() {
		return seniority;
	}

	public void setSeniority(int e) {
		this.seniority = e;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	
}
 class EmployeeComparator implements Comparator<Employee> {
		
		private int experienceComparison;
		private int seniorityComparison;


		@Override
		public int compare(Employee emp1, Employee emp2) {
			
			
			int seniorityComparision = Integer.compare(emp1.getSeniority(), emp2.getSeniority());
			if(seniorityComparison != 0) {
				return seniorityComparision;
			}
			
			int experienceComparision = Integer.compare(emp1.getExperience(), emp2.getExperience());
			if(experienceComparison != 0) {
				return experienceComparision;
			}
			
			return emp1.getName().compareTo(emp2.getName());
		}
		
	}


	