package parkinglot;

public class Car {
	private String regNum;
	private String colour;
	
	Car(String regNum, String colour){
		this.regNum = regNum;
		this.colour = colour;
	}

	public String getRegNum() {
		return regNum;
	}

	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}
}
