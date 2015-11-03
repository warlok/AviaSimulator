package com.simulator.objects;

import com.google.gson.Gson;
import org.jgroups.Address;
import org.jgroups.JChannel;

import java.util.Random;

public abstract class Vehicle {

    protected int number;
    protected double latitude;
    protected double longitude;
    protected double altitude;
    protected int course;
    protected transient JChannel channel;
    protected transient Gson gson = new Gson();
    private static int counter = 1;

    public Vehicle() {
        this.number = counter;
        counter++;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public JChannel getChannel() {
        return channel;
    }

    public void setChannel(JChannel channel) {
        this.channel = channel;
    }

    public void send(String string) throws Exception {
        Address center = channel.getView().getCreator();
        channel.send(center, string);
    }

    public void dynamicParams() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    changeParameters();
                    try {
                        send(gson.toJson(Vehicle.this));
                        Thread.sleep(randomInt());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    protected void changeParameters() {
        int delta = randomSignedInt();
        altitude += delta;
        delta = randomSignedInt();
        latitude += delta;
        delta = randomSignedInt();
        longitude += delta;
        delta = randomSignedInt();
        course += delta;
    }

    protected int randomSignedInt() {
        Random random = new Random();
        return (random.nextInt(5)-1);
    }

    protected int randomInt() {
        Random random = new Random();
        return (random.nextInt(9000) + 1000);
    }

    public abstract void connect(String cluster) throws Exception;


}
