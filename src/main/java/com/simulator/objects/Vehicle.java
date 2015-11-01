package com.simulator.objects;

import org.jgroups.JChannel;
import org.jgroups.Message;

/**
 * Created by dean on 11/1/15.
 */
public abstract class Vehicle {

    private int number;
    private double latitude;
    private double longitude;
    private double altitude;
    private int course;
    JChannel channel;

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

    public void send(String string) throws Exception {
        channel.send(null, string);
    }

}
