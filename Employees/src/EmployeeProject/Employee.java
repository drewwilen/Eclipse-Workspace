package EmployeeProject;

public abstract class Employee implements Comparable<Employee> {
	
	protected String name;//establishes data types
	
	
	public Employee(String name) {//constructor for Employee (super is not necessary here though)
		super();
		this.name = name;//sets variables equal to one another
	}
	

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	public abstract double getAnnualIncome();//requires that each child has a getAnnualIncome of their own
	
	public int compareTo(Employee e) {//compares the annual salaries of two employees (as this class extends Comparable<Employee>)
		double moneyComp = getAnnualIncome() - e.getAnnualIncome();

		if (moneyComp == 0) {
			return 0;
		} else if (moneyComp > 0) {
			return 1;
		}

		return -1;

	}
	
	public String toString() {//toString() overloaded-which will be used for partial overriding in other classes
		return "Employee: " + name + "\n";
	}

}
