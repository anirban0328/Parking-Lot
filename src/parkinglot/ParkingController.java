package parkinglot;

import java.util.ArrayList;

public class ParkingController {

	//create parking lot
	public void createParkingLot(ParkingLot parkingLot){
		parkingLot.parkingLot = new ParkingLot(parkingLot.size);
		parkingLot.parkingLot.addParkingSpace(parkingLot.carParkingMap);
		System.out.println("Created a parking lot with " + parkingLot.size +" slots");
	}
	
	//park car in parking spot
	public void parkCarInParking(String regNum, String colour, ParkingLot parkingLot){
		boolean available = false;
		   
		for(int i=0; i<parkingLot.size;i++){
			ParkingSpace parkingSpace = parkingLot.carParkingMap.get(i);
			if(parkingSpace.getCar() != null && parkingSpace.getCar().getRegNum().equals(regNum)){
				System.out.println("Car is already parked");
				return;
			}
			
			if(parkingSpace.isFree()){
				Car newCar = new Car(regNum,colour);
				parkingSpace.assignCar(newCar);
				System.out.println("Allocated slot number: "+ (i+1));
				available = true;
				break;
			}
		}
		if(available == false){
			System.out.println("Sorry, parking lot is full");
		}
	}
	
	//remove car from parking spot
	public void unParkCar(int parkingSpaceNum, ParkingLot parkingLot){
		ParkingSpace parkingSpace = parkingLot.carParkingMap.get(parkingSpaceNum-1);
		if(parkingSpace == null){
			System.out.println("No car parked in the slot");
		} else{
			parkingSpace.removeCar();
			System.out.println("Slot number " + parkingSpaceNum + " is free");
		}
	}
	
	//get car details
	public void carDetails(ParkingLot parkingLot){
		 System.out.println("Slot No.    Registration No.    Colour");
		   for(int i=0; i<parkingLot.size;i++){
			   ParkingSpace parkingSpace = parkingLot.carParkingMap.get(i);
			   if(!parkingSpace.isFree()){
				   System.out.println(parkingSpace.getNumber()+1 + "            " + parkingSpace.getCar().getRegNum() 
						   + "      " + parkingSpace.getCar().getColour());
			   }
		   }
	}
	
	//get registration number of cars of given colour
	public void getRegistrationNumForCarColour(String colour, ParkingLot parkingLot){
		 ArrayList<String> carList = new ArrayList<String>();
		 for(int i=0; i<parkingLot.size;i++){
			 ParkingSpace parkingSpace = parkingLot.carParkingMap.get(i);
			 if(!parkingSpace.isFree() && parkingSpace.getCar().getColour().equals(colour)){
				 carList.add(parkingSpace.getCar().getRegNum());
			 }
		 }
		 System.out.println(carList);	
	}
	
	//get parking slot number for given car colour
	public void getSlotForCarColour(String colour, ParkingLot parkingLot){
		ArrayList<Integer> slotList = new ArrayList<Integer>();
		for(int i=0; i<parkingLot.size;i++){
			ParkingSpace parkingSpace = parkingLot.carParkingMap.get(i);
			if(!parkingSpace.isFree() && parkingSpace.getCar().getColour().equals(colour)){
				slotList.add(parkingSpace.getNumber()+1);
			}
		}
		System.out.println(slotList);
	}
	
	//get parking slot number of a given car
	public void getParkingSpaceOfCar(String regNum, ParkingLot parkingLot){
		 boolean found = false;
		 for(int i=0; i<parkingLot.size;i++){
			 ParkingSpace parkingSpace = parkingLot.carParkingMap.get(i);
			 if(!parkingSpace.isFree() && parkingSpace.getCar().getRegNum().equals(regNum)){
				 System.out.println(parkingSpace.getNumber()+1);
				 found = true;
			 }
		 }
		 if(found==false){
			 System.out.println("Not Found");
		 }
	}
}
