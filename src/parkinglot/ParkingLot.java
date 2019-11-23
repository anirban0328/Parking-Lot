package parkinglot;

import java.util.HashMap;

public class ParkingLot {
	HashMap<Integer,ParkingSpace> carParkingMap;
	ParkingLot parkingLot;
	int size;
	
	ParkingLot(int n){
		this.size=n;
	}
	
	ParkingLot(){
		this.size=0;
		this.carParkingMap = new HashMap<Integer,ParkingSpace>();
		this.parkingLot=null; 
	}
	
	public void addParkingSpace(HashMap<Integer,ParkingSpace> carParkingMap) {
		for(int i=0; i<getSize(); i++){
			ParkingSpace space = new ParkingSpace(i);
			carParkingMap.put(space.getNumber(), space);
		}
	}

	public int getSize() {
		return size;
	}
}
