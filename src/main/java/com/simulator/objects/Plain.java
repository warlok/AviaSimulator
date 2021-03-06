package com.simulator.objects;

import org.jgroups.JChannel;

public class Plain extends Vehicle {

    private PlainType type;
    private static int counter = 1;

    public Plain(PlainType type) {
        super();
        this.type = type;
    }

    public PlainType getType() {
        return type;
    }

    public void setType(PlainType type) {
        this.type = type;
    }

    @Override
    public void connect(String cluster) throws Exception {
        channel = new JChannel();
        channel.setName(type.toString() + "_" + counter);
        counter++;
        channel.connect(cluster);
    }
}
