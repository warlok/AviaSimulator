package com.simulator;

import com.simulator.objects.*;

import java.util.LinkedList;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        Helicopter copter1 = new Helicopter(HelicopterType.MI171);
        Helicopter copter2 = new Helicopter(HelicopterType.MI2);
        Helicopter copter3 = new Helicopter(HelicopterType.MI7);
        Plain plain1 = new Plain(PlainType.A300);
        Plain plain2 = new Plain(PlainType.B777);
        Plain plain3 = new Plain(PlainType.L39);
        DispatchingCenter dispatchingCenter = new DispatchingCenter();
        List<Vehicle> vehicles = new LinkedList<>();
        vehicles.add(copter1);
        vehicles.add(copter2);
        vehicles.add(copter3);
        vehicles.add(plain1);
        vehicles.add(plain2);
        vehicles.add(plain3);
        dispatchingCenter.setVehicles(vehicles);
        try {
            dispatchingCenter.connect("Test");
            for (Vehicle vehicle : dispatchingCenter.getVehicles()) {
                vehicle.connect("Test");
                vehicle.dynamicParams();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
