package ittest;

public class Car implements MotorVehicle{
private  String model;
private int gear, speed;
public Car(String model, int gear, int speed) {
	super();
	this.model = model;
	this.gear = gear;
	this.speed = speed;
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
 * @return the gear
 */
public int getGear() {
	return gear;
}
/**
 * @param gear the gear to set
 */
public void setGear(int gear) {
	this.gear = gear;
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

public void drive() {
	System.out.println("The " + model + " drives on the road");
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
