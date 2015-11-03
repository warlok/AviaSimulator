package com.simulator.objects;

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;

import java.util.LinkedList;
import java.util.List;

public class DispatchingCenter extends ReceiverAdapter {

    private JChannel channel;
    private List<Vehicle> vehicles;
    private StringBuilder sb = new StringBuilder();

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
        sb.append(msg + " : " + msg.getObject().toString() + "\n");
    }

    public void log() {
        while (true) {
            System.out.println(sb.toString());
            sb = new StringBuilder();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void connect(String cluster) throws Exception {
        channel = new JChannel();
        channel.setReceiver(this);
        channel.setName("Dispatching Center");
        channel.connect(cluster);
    }

}
