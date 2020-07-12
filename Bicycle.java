package javaAssignment;

import java.lang.*;
import java.util.*;


class Gear {
    private double chainRingSize; 
    private double cogSize;

    Gear(double chainRingSize, double cogSize) {
        this.chainRingSize = chainRingSize;
        this.cogSize = cogSize;
    }
    
}

class Rim {
    private double size;

    Rim(double size) {
        this.size = size;
    }


}

class Tyre {
    private double thickness;

    Tyre(double thickness) {
        this.thickness = thickness;
    }


}

class Wheel {
    private Tyre tyre;
    private Rim rim;

    Wheel(Hashtable wheelHash) {
        this.tyre = (Tyre)wheelHash.get("tyre");
        this.rim = (Rim)wheelHash.get("rim");
    }

}

class Bicycle {
    private Wheel wheel1;
    private Wheel wheel2;
    private Gear gear;

    Bicycle(Hashtable bicycleHash) {
        this.wheel1 = (Wheel)bicycleHash.get("wheel1");
        this.wheel2 = (Wheel)bicycleHash.get("wheel2");
        this.gear  = (Gear)bicycleHash.get("gear"); 
    }
    public static void main(String args[]) {

        Gear gear = new Gear(21.3, 24.1);
        Tyre tyre = new Tyre(24.0);
        Rim rim = new Rim(23.0);

        Hashtable<String, Object> wheelHash1 = new Hashtable<String, Object>();
        wheelHash1.put("tyre", tyre);
        wheelHash1.put("rim", rim);
        Wheel wheel1 = new Wheel(wheelHash1);
        Hashtable<String, Object> wheelHash2 = new Hashtable<String, Object>();
        wheelHash2.put("tyre", tyre);
        wheelHash2.put("rim", rim);
        Wheel wheel2 = new Wheel(wheelHash2);

        Hashtable<String, Object> bicycleHash = new Hashtable<String, Object>();
        bicycleHash.put("wheel1", wheel1);
        bicycleHash.put("wheel2", wheel2);
        bicycleHash.put("gear", gear);
        Bicycle bicycle = new Bicycle(bicycleHash);
    }
}

