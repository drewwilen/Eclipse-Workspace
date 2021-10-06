package lab1;

public class Student {
private String name;//establishing all variables/data types
private int classRank;
	Student(String n, int cR) {//creates the student object using a name and a classrank
		name= n;
		classRank = cR;
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
	/**
	 * @return the classRank
	 */
	public int getClassRank() {
		return classRank;
	}
	/**
	 * @param classRank the classRank to set
	 */
	public void setClassRank(int classRank) {
		this.classRank = classRank;
	}
	
	public String toString() {//displays the name and classrank when I print a student
		return "Name: " + name +", Class Rank: "+classRank + ".";
	}

}
