package com.simulator;

import com.simulator.objects.*;

import java.util.LinkedList;
import java.util.List;

public class Demo {

    private Helicopter copter1;
    private Helicopter copter2;
    private Helicopter copter3;
    private Plain plain1;
    private Plain plain2;
    private Plain plain3;
    private DispatchingCenter dispatchingCenter;

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.init();
        demo.createListVehicles();
        demo.createCluster(demo.dispatchingCenter);
    }

    private void createListVehicles() {
        List<Vehicle> vehicles = new LinkedList<>();
        vehicles.add(copter1);
        vehicles.add(copter2);
        vehicles.add(copter3);
        vehicles.add(plain1);
        vehicles.add(plain2);
        vehicles.add(plain3);
        dispatchingCenter.setVehicles(vehicles);
    }

    private void createCluster(DispatchingCenter dispatchingCenter) {
        try {
            dispatchingCenter.connect("Test");
            for (Vehicle vehicle : dispatchingCenter.getVehicles()) {
                vehicle.connect("Test");
                vehicle.dynamicParams();
            }
            dispatchingCenter.log();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init() {
        copter1 = new Helicopter(HelicopterType.MI171);
        copter2 = new Helicopter(HelicopterType.MI2);
        copter3 = new Helicopter(HelicopterType.MI7);
        plain1 = new Plain(PlainType.A300);
        plain2 = new Plain(PlainType.B777);
        plain3 = new Plain(PlainType.L39);
        dispatchingCenter = new DispatchingCenter();
    }

}
