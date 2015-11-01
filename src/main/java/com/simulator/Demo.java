package com.simulator;

import com.simulator.objects.*;

/**
 * Created by dean on 11/1/15.
 */
public class Demo {

    public static void main(String[] args) {
        Helicopter copter1 = new Helicopter(HelicopterType.MI171);
        Helicopter copter2 = new Helicopter(HelicopterType.MI2);
        Helicopter copter3 = new Helicopter(HelicopterType.MI7);
        Plain plain1 = new Plain(PlainType.A300);
        Plain plain2 = new Plain(PlainType.B777);
        Plain plain3 = new Plain(PlainType.L39);
        DispatchingCenter dispatchingCenter = new DispatchingCenter();
        try {
            dispatchingCenter.connect("Test");
            plain1.connect("Test");
            plain2.connect("Test");
            plain3.connect("Test");
            copter1.connect("Test");
            copter2.connect("Test");
            copter3.connect("Test");
            copter1.send("Fucking shit");
            Thread.sleep(2000);
            plain3.send("My Fault");
            Thread.sleep(5000);
            plain1.send("Bum babe");
            copter2.send("Ha-ha motherfuckers");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
