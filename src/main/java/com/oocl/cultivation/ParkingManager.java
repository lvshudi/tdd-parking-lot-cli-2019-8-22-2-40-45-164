package com.oocl.cultivation;

import java.util.ArrayList;

public class ParkingManager {
	public ArrayList<ParkingBoy> parkingBoys;
	public ParkingLot parkingLot;
	private String lastErrorMessage;
    private Car car;

	public void addParkingBoy(ParkingBoy parkingBoy) {
		parkingBoys.add(parkingBoy);
	}

	public ParkingTicket orderBoyPark(ParkingBoy orderParkingBoy, Car car) {
		ParkingTicket parkingTicket = null;
		for (ParkingBoy parkingBoy : parkingBoys) {
			if (parkingBoy == orderParkingBoy) {
				parkingTicket = parkingBoy.park(car);
				break;
			}
		}
		if (parkingTicket == null) {
			this.lastErrorMessage = orderParkingBoy.getLastErrorMessage();
		}
		return parkingTicket;
	}

	public ParkingTicket park(Car car) {

		if (parkingLot.getAvailableParkingPosition() <= 0) {
			this.lastErrorMessage = "The parking lot is full.";
			return null;
		}
		ParkingTicket parkingTicket = parkingLot.parkCar(car);
		this.lastErrorMessage = null;
		return parkingTicket;
		
	}
	
	public String getLastErrorMessag () {
		return lastErrorMessage;
	}
}
