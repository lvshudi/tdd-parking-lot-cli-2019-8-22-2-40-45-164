package com.oocl.cultivation;

public class ParkingBoy {

    private final ParkingLot parkingLot;
    private String lastErrorMessage;
    private Car car;
    
    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
    	
        ParkingTicket parkingTicket = parkingLot.parkCar(car);
        return parkingTicket;
    }

    public Car fetch(ParkingTicket ticket) {
    	if (ticket == null) {
    		this.lastErrorMessage = "Please provide your parking ticket.";
    		return null;
    	}
    	Car car = parkingLot.fetchCar(ticket);
    	if (car == null) {
    		this.lastErrorMessage = "Unrecognized parking ticket.";
    	}
        return car;
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
    
}
