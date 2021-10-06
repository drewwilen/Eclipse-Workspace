package ittest;

public class Main {

	public static void main(String[] args) {
		Car c1 = new Car("Corvette", 6, 0);
		Plane p1 = new Plane("Boeing", 0, 35000);
		
		MotorVehicle vehiclesp[] = {c1, p1};
		c1.drive();
		p1.drive();
	}

}
