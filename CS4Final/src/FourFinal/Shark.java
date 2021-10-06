package FourFinal;

public class Shark {
	private static int sharkIDVal = 1;//sharkIDVAl really just represents where the _id is for table sharks
	private int _id;//initializing data types
	private String name;
	private double netWorth;

	public Shark(String name, double netWorth) {//constructor with feilds
		super();
		this._id = sharkIDVal;//sets _id to what the id is and then adds one to the sharkIDVal bc the id goes up 1
		this.name = name;
		this.netWorth = netWorth;
		sharkIDVal++;
	}

	/**
	 * @return the _id
	 */
	public int get_id() {
		return _id;
	}

	/**
	 * @param _id the _id to set
	 */
	public void set_id(int _id) {
		this._id = _id;
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
	 * @return the netWorth
	 */
	public double getNetWorth() {
		return netWorth;
	}

	/**
	 * @param netWorth the netWorth to set
	 */
	public void setNetWorth(double netWorth) {
		this.netWorth = netWorth;
	}

	public String toString() {//this displays when object is printed
		return _id + "| Name: " + name + " | Net Worth: $" + netWorth;
	}

}
