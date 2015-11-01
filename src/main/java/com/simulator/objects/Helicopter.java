package com.simulator.objects;

import org.jgroups.JChannel;

/**
 * Created by dean on 11/1/15.
 */
public class Helicopter extends Vehicle {

    private HelicopterType type;
    private static int counter = 1;

    public Helicopter(HelicopterType type) {
        super();
        this.type = type;
    }

    public HelicopterType getType() {
        return type;
    }

    public void setType(HelicopterType type) {
        this.type = type;
    }

    public void connect(String cluster) throws Exception {
        channel = new JChannel();
        channel.setName(type.toString() + "_" + counter);
        counter++;
        channel.connect(cluster);
    }

}
