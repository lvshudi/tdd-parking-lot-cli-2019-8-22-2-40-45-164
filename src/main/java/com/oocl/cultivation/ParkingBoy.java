package com.oocl.cultivation;

public class ParkingBoy {

    private final ParkingLot parkingLot;
    private String lastErrorMessage;
    private Car car;
    
    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
        this.car = car;
        return new ParkingTicket();
    }

    public Car fetch(ParkingTicket ticket) {
        return car;
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
