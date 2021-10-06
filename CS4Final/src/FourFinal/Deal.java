package FourFinal;

public class Deal {
	private static int dealIDVal = 1;//dealIDVal really just represents where the _id is for table deal

	private int _id;// initializing data types
	private String deal;
	private int shark;
	private int company;

	public Deal(String deal, int shark, int company) {// constructor with variables
		super();
		this._id = dealIDVal;//sets _id to what the id is and then adds one to the dealIDVal bc the id goes up 1
		this.deal = deal;
		this.shark = shark;
		this.company = company;
		dealIDVal++;

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
	 * @return the deal
	 */
	public String getDeal() {
		return deal;
	}

	/**
	 * @param deal the deal to set
	 */
	public void setDeal(String deal) {
		this.deal = deal;
	}

	/**
	 * @return the shark
	 */
	public int getShark() {
		return shark;
	}

	/**
	 * @param shark the shark to set
	 */
	public void setShark(int shark) {
		this.shark = shark;
	}

	/**
	 * @return the company
	 */
	public int getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(int company) {
		this.company = company;
	}

	public String toString() {
		return _id + "| Deal: " + deal + " | Shark: " + shark + " | Company: " + company;
	}

}
