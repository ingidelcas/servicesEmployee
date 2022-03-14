package model;

public class Employee {
	private int id;
	private String employee_name;
	private long employee_salary;
	private int employee_age;
	private String profile_image;
	private long employee_anual_salary;
	
	

	public Employee(int id, String employee_name, long employee_salary, int employee_age, String profile_image,
			long employee_anual_salary) {
		super();
		this.id = id;
		this.employee_name = employee_name;
		this.employee_salary = employee_salary;
		this.employee_age = employee_age;
		this.profile_image = profile_image;
		this.employee_anual_salary = employee_anual_salary;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public long getEmployee_salary() {
		return employee_salary;
	}

	public void setEmployee_salary(long employee_salary) {
		this.employee_salary = employee_salary;
	}

	public int getEmployee_age() {
		return employee_age;
	}

	public void setEmployee_age(int employee_age) {
		this.employee_age = employee_age;
	}

	public String getProfile_image() {
		return profile_image;
	}

	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}

	public long getEmployee_anual_salary() {
		return employee_anual_salary;
	}

	public void setEmployee_anual_salary(long employee_anual_salary) {
		this.employee_anual_salary = employee_anual_salary;
	}
	

}
