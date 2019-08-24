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
        return parkingLot.fetchCar(ticket);
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
