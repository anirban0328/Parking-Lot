package parkinglot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParseInput {

	public static void main(String[] args) {
		ParkingLot parkingLot = new ParkingLot();
		ParkingController parkingCont = new ParkingController();
		String filePath="";
		
		//read from console
		if(args == null || args.length == 0){		    
		    try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
				System.out.print("");
				String strLine = bufferedReader.readLine();
				while(! (strLine.equals("EXIT") || strLine.equals("Exit")) ){
					String[] line = strLine.split(" ");
					parseInputFile(line,parkingLot,parkingCont);
					System.out.println();
					strLine = bufferedReader.readLine();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return;
		} else{ //read from file
			filePath = args[0];
			if(filePath==null || filePath.equals("")){
				return;
			}
		}
		
		BufferedReader objReader = null;
		try {
			String currentLine;
			objReader = new BufferedReader(new FileReader(filePath));  	   
			while ((currentLine = objReader.readLine()) != null) {
				String[] line = currentLine.split(" ");
				parseInputFile(line,parkingLot,parkingCont);	   
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (objReader != null)
					objReader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}	
	}
	
	//parse Input File Method
	public static void parseInputFile(String[] line, ParkingLot parkingLot, ParkingController parkingCont){
		
		//creating parking lot
		if(line[0].trim().equals("create_parking_lot") && line.length==2){
			parkingLot.size = Integer.parseInt(line[1].trim());
			parkingCont.createParkingLot(parkingLot);
		}
		   
		//parking car
		else if(line[0].trim().equals("park") && line.length==3){
			String regNum = line[1].trim();
			String colour = line[2].trim();
			parkingCont.parkCarInParking(regNum, colour, parkingLot);
		}
		   
		//leaving car
		else if(line[0].trim().equals("leave") && line.length==2){
			int parkingSpaceNum = Integer.parseInt(line[1].trim());
			parkingCont.unParkCar(parkingSpaceNum, parkingLot);
		}
		   
		//car details list
		else if(line[0].trim().equals("status") && line.length==1){
			parkingCont.carDetails(parkingLot);
		}
		   
		//list of car's registration numbers for a given colour
		else if(line[0].trim().equals("registration_numbers_for_cars_with_colour") && line.length==2){
			String colour = line[1].trim();
			parkingCont.getRegistrationNumForCarColour(colour, parkingLot);
		}
		   
		//list of slot numbers for a given car colour
		else if(line[0].trim().equals("slot_numbers_for_cars_with_colour") && line.length==2){
			String colour = line[1].trim();
			parkingCont.getSlotForCarColour(colour, parkingLot);
		}
		   
		//find parking space for a given car
		else if(line[0].trim().equals("slot_number_for_registration_number") && line.length==2){
			String regNum = line[1].trim();
			parkingCont.getParkingSpaceOfCar(regNum, parkingLot);
		}
		else{
			System.out.println("Invalid Input");
		}
	}
}
