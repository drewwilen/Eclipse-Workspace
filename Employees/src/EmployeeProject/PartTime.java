package EmployeeProject;

public class PartTime extends Employee {
	private double hourlyRate;//initializing data types
	private int weeklyHours;
	
	public PartTime(String name, double hourlyRate) {//constructor-sets the data entered equal to the data types
		super(name);
		this.hourlyRate = hourlyRate;
		weeklyHours = generateHours();
		
	}
	
	public int generateHours() {//generates random number between 5 and 30
		return 5 + (int)(26*Math.random());
	}

	public double getAnnualIncome() {//this getAnnual income takes the weekly hours, multiplies it by the hourly salary, and multiplies that by 50 (weeks)
		return weeklyHours *hourlyRate *50;
	}
	
	public String toString() {//toString uses super's toString and adds in PartTimes special information
		return super.toString() + "Hourly Rate: $" + String.format("%.2f", hourlyRate) + "\nWeekly Hours: " + weeklyHours;
	}
}
