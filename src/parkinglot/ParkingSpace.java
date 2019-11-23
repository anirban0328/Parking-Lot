package parkinglot;

public class ParkingSpace {
	private int number;
	private boolean free;
	private Car car;
	
	ParkingSpace(int number){
		this.number=number;
		this.free=true;
	}
	
	public void assignCar(Car car) {
	    this.car = car;
	    free = false;
	}

	public void removeCar() {
	    this.car = null;
	    free = true;
	}

	public int getNumber() {
		return number;
	}

	public boolean isFree() {
		return free;
	}

	public void setFree(boolean free) {
		this.free = free;
	}

	public Car getCar() {
		return car;
	}
}
