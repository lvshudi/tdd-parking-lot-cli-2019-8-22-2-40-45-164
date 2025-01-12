package com.oocl.cultivation;

import java.awt.List;
import java.util.ArrayList;

public class ParkingBoy {

    private final ArrayList<ParkingLot> parkingLotList;
    private String lastErrorMessage;
    private Car car;
    
    public ParkingBoy(ArrayList<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }
    
    public ParkingBoy(ParkingLot parkingLot) {
    	this.parkingLotList = new ArrayList<ParkingLot>();
        this.parkingLotList.add(parkingLot);
    }

    public ParkingTicket park(Car car) {
    	for (ParkingLot parkingLot : parkingLotList) {
    		if (parkingLot.getAvailableParkingPosition()<=0) {
        		this.lastErrorMessage = "The parking lot is full.";
        		continue;
    		}
            ParkingTicket parkingTicket = parkingLot.parkCar(car);
            this.lastErrorMessage = null;
            return parkingTicket;
		}
    	return null;
    }

    public Car fetch(ParkingTicket ticket) {
    	if (ticket == null) {
    		this.lastErrorMessage = "Please provide your parking ticket.";
    		return null;
    	}
    	for (ParkingLot parkingLot : parkingLotList) {
        	car = parkingLot.fetchCar(ticket);
		}
    	if (car == null) {
    		this.lastErrorMessage = "Unrecognized parking ticket.";
    	}
    	return car;
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
    
}
