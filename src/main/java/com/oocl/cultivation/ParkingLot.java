package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ParkingLot {
    private final int capacity;
    private Map<ParkingTicket, Car> cars = new HashMap<>();

    public ParkingLot() {
        this(10);
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public int getAvailableParkingPosition() {
        return capacity - cars.size();
    }
    
    public double getUseRate() {
    	return (capacity - cars.size())/capacity;
    }
    
    public ParkingTicket parkCar(Car car) {
    	ParkingTicket parkingTicket = new ParkingTicket();
    	cars.put(parkingTicket, car);
    	return parkingTicket;
    }
    
    public Car fetchCar(ParkingTicket parkingTicket) {
    	Car car = cars.get(parkingTicket);
    	Iterator<ParkingTicket> iter = cars.keySet().iterator();
    	while(iter.hasNext()){
    	       if(iter.next().equals(parkingTicket)){
    	                iter.remove();
    	       }
    	}
    	return car;
    }
}
