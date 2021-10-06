package ittest;

public class Plane implements MotorVehicle{
	private String model;
	private int speed, altitude;
	
	public Plane(String model, int speed, int altitude) {
		super();
		this.model = model;
		this.speed = speed;
		this.altitude = altitude;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * @return the altitude
	 */
	public int getAltitude() {
		return altitude;
	}

	/**
	 * @param altitude the altitude to set
	 */
	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}

	@Override
	public void drive() {
		// TODO Auto-generated method stub
		System.out.println("The " + model + " flies in the air");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeGears(int newGear) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accelerate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deccelerate() {
		// TODO Auto-generated method stub
		
	}
	
}