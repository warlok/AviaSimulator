package com.simulator.objects;

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;

import java.util.LinkedList;
import java.util.List;

public class DispatchingCenter extends ReceiverAdapter {

    JChannel channel;
    List<Vehicle> vehicles;

    public DispatchingCenter() {
        vehicles = new LinkedList<>();
    }

    public void add(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void del(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public void viewAccepted(View view) {

    }

    @Override
    public void receive(Message msg) {
        super.receive(msg);
        System.out.println(msg + " : " + msg.getObject().toString());
    }

    public void connect(String cluster) throws Exception {
        channel = new JChannel();
        channel.setReceiver(this);
        channel.setName("Dispatching Center");
        channel.connect(cluster);
    }

}
