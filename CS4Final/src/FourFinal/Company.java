package FourFinal;

public class Company {
	private static int companyIDVal = 1;//companyIDVal really just represents where the _id is for table deals
	private int _id;//initializing data types
	private String product;
	private int valuation;
	public Company(String product, int valuation) {//constructor with feilds
		super();
		this._id = companyIDVal;//sets _id to what the id is and then adds one to the dealIDVal bc the id goes up 1
		this.product = product;
		this.valuation = valuation;
		companyIDVal++;
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
	public String getProduct() {
		return product;
	}
	/**
	 * @param name the name to set
	 */
	public void setProduct(String product) {
		this.product = product;
	}
	/**
	 * @return the netWorth
	 */
	public int getValuation() {
		return valuation;
	}
	/**
	 * @param netWorth the netWorth to set
	 */
	public void setValuation(int valuation) {
		this.valuation = valuation;
	}
	
	public String toString() {
		return _id +"| Product: " + product + " | Valuation: $" + valuation;
	}
}
