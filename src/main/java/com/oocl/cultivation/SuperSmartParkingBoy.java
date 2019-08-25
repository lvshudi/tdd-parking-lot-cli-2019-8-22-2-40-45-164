package com.oocl.cultivation;

import java.util.ArrayList;

public class SuperSmartParkingBoy extends ParkingBoy {
	private final ArrayList<ParkingLot> parkingLotList;
    private String lastErrorMessage;
    private Car car;
    
    public SuperSmartParkingBoy(ArrayList<ParkingLot> parkingLotList) {
    	super(parkingLotList);
        this.parkingLotList = parkingLotList;
    }
    
    public SuperSmartParkingBoy(ParkingLot parkingLot) {
    	super(parkingLot);
    	this.parkingLotList = new ArrayList<ParkingLot>();
        this.parkingLotList.add(parkingLot);
    }

    public ParkingTicket park(Car car) {
    	double max = 0;
    	ParkingLot thisParkingLot = null;
    	for (ParkingLot parkingLot : parkingLotList) {
    		if (parkingLot.getAvailableParkingPosition()<=0) {
        		this.lastErrorMessage = "The parking lot is full.";
        		continue;
    		}
    		if (parkingLot.getUseRate() > max) {
				max = parkingLot.getUseRate();
				thisParkingLot = parkingLot;
			}
            
		}
    	if (thisParkingLot != null) {
    		ParkingTicket parkingTicket = thisParkingLot.parkCar(car);
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
