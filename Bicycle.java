package javaAssignment;

import java.lang.*;
import java.util.*;

interface DiametricObjects {
    double getDiameter();
}

class Gear {
    private double chainRingSize; 
    private double cogSize;

    Gear(double chainRingSize, double cogSize) {
        this.chainRingSize = chainRingSize;
        this.cogSize = cogSize;
    }

    double getChainRingSize() {
        return this.chainRingSize;
    }

    double getCogSize() {
        return this.cogSize;
    }

    void modifyChainRingSize(double newChainRingSize) {
        this.chainRingSize = newChainRingSize;
    }
    
    void modifyCogSize(double newCogSize) {
        this.cogSize = newCogSize;
    }

    double ratio() {
        return chainRingSize / cogSize;
    }

    double gearInches(DiametricObjects object) {
        return this.ratio() * object.getDiameter();
    }
}

class Rim implements DiametricObjects {
    private double diameter;

    Rim(double diameter) {
        this.diameter = diameter;
    }

    public double getDiameter() {
        return this.diameter;
    }

    void modifySize(double newDiameter) {
        this.diameter = newDiameter;
    }

}

class Tyre {
    private double thickness;

    Tyre(double thickness) {
        this.thickness = thickness;
    }

    double getThickness() {
        return this.thickness;
    }

    void modifySize(double newThickness) {
        this.thickness = newThickness;
    }
}

class Wheel implements DiametricObjects {
    private Tyre tyre;
    private Rim rim;

    Wheel(Hashtable wheelHash) {
        this.tyre = (Tyre)wheelHash.get("tyre");
        this.rim = (Rim)wheelHash.get("rim");
    }

    Tyre getTyre() {
        return this.tyre;
    }

    Rim getRim() {
        return this.rim;
    }

    void modifyTyre(Tyre newTyre) {
        this.tyre = newTyre;
    }

    void modifyRim(Rim newRim) {
        this.rim = newRim;
    }

    public double getDiameter() {
        return this.tyre.getThickness() * 2 + this.rim.getDiameter();
    }

    double circumference() {
        return Math.PI * getDiameter();
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

    Wheel getWheel1() {
        return this.wheel1;
    }

    Wheel getWheel2() {
        return this.wheel2;
    }

    Gear getGear() {
        return this.gear;
    }

    void modifyWheel1(Wheel newWheel1) {
        this.wheel1 = newWheel1;
    }


    void modifyWheel2(Wheel newWheel2) {
        this.wheel2 = newWheel2;
    }

    void modifyGear(Gear newGear) {
        this.gear = newGear;
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

        System.out.println("Bicycle Features:");

        System.out.println("    Wheel1 Features:");
        System.out.println("        Tyre Features:");
        System.out.println("            Size: " + bicycle.getWheel1().getTyre().getThickness());
        System.out.println("        Rim Features:");
        System.out.println("            Size: " + bicycle.getWheel1().getRim().getDiameter());
        System.out.println("        Diameter:");
        System.out.println("            Value: " + bicycle.getWheel1().getDiameter());
        System.out.println("        Circumference:");
        System.out.println("            Value: " + bicycle.getWheel1().circumference());
        
        System.out.println("    Wheel2 Features:");
        System.out.println("        Tyre Features:");
        System.out.println("            Size: " + bicycle.getWheel2().getTyre().getThickness());
        System.out.println("        Rim Features:");
        System.out.println("            Size: " + bicycle.getWheel1().getRim().getDiameter());
        System.out.println("        Diameter:");
        System.out.println("            Value: " + bicycle.getWheel2().getDiameter());
        System.out.println("        Circumference:");
        System.out.println("            Value: " + bicycle.getWheel2().circumference());
        
        System.out.println("    Gear Features:");
        System.out.println("        ChainRing:");
        System.out.println("            Size: " + bicycle.getGear().getChainRingSize());
        System.out.println("        Cog:");
        System.out.println("            Size: " + bicycle.getGear().getCogSize());

        System.out.println("-----------------------------------------------");
        System.out.println("    Gear Ratio For the Wheel:");
        System.out.println("            Value1: " + bicycle.getGear().gearInches(bicycle.getWheel1()));
        System.out.println("            Value2: " + bicycle.getGear().gearInches(bicycle.getWheel2()));

    }
}

