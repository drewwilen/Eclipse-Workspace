package EmployeeProject;

public class FullTime extends Employee {//because FullTime is a type of employee

	private double salary;//initializing all data types-including an instance of benefit for each fulltime employee
	private Benefits benefit;
	public FullTime(String name, double salary, int sickDays, boolean medicare) {//sets data equal to each other
		super(name);
		this.salary = salary;
		createBenefits(sickDays, medicare);//method that sets up the Benefit instance
	}

	public void createBenefits(int sickDays, boolean medicare) {//constructs the FullTime's benefits
		benefit = new Benefits(sickDays, medicare);
	}

	/**
	 * @return the salary
	 */
	public double getAnnualIncome() {//for this one, the annual income is just the salary
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	

	public class Benefits {
		private int sickDays;//initializing data types
		private boolean medInsurance;

		public Benefits(int sickDays, boolean medInsurance) {//constructor-setting things equal to one another
			super();
			this.sickDays = sickDays;
			this.medInsurance = medInsurance;
		}
		
		/**
		 * @return the sickDays
		 */
		public int getSickDays() {
			return sickDays;
		}

		/**
		 * @param sickDays the sickDays to set
		 */
		public void setSickDays(int sickDays) {
			this.sickDays = sickDays;
		}

		/**
		 * @return the medInsurance
		 */
		public boolean getMedInsurance() {
			return medInsurance;
		}

		/**
		 * @param medInsurance the medInsurance to set
		 */
		public void setMedInsurance(boolean medInsurance) {
			this.medInsurance = medInsurance;
		}
		public String toString() {//toString-used in the outer class
			return "Sick Days: " + sickDays +"\nInsurance: " + medInsurance;
		}

	}
	public String toString() {//calls the super toStirng and adds in the salary and benefits from the Benefits inner class
		return super.toString() + "Salary: $" + String.format("%.2f", salary) + "\nBenefits:\n" + benefit.toString();
	}
	
	


}
