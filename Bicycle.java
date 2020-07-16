package javaAssignment;

import java.lang.*;
import java.util.*;

/*
javac Bicycle.java -d ClassFiles
java -cp ClassFiles javaAssignment.Bicycle
*/

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

class FrontGear extends Gear {
    // functionality specific to Front Gears like limitation of size, range.
    FrontGear(double chainRingSize, double cogSize) {
       super(chainRingSize, cogSize);
    }
}

class BackGear extends Gear {
    // functionality specific to Back Gears like limitation of size, range.
    BackGear(double chainRingSize, double cogSize) {
        super(chainRingSize, cogSize);
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
    private Wheel frontWheel;
    private Wheel backWheel;
    private ArrayList<FrontGear> frontGears = new ArrayList<FrontGear>();
    private ArrayList<BackGear> backGears = new ArrayList<BackGear>();

    Bicycle(Hashtable bicycleHash) {
        this.frontWheel = (Wheel)bicycleHash.get("frontWheel");
        this.backWheel = (Wheel)bicycleHash.get("backWheel");
    }

    Wheel getfrontWheel() {
        return this.frontWheel;
    }

    Wheel getbackWheel() {
        return this.backWheel;
    }

    FrontGear getFrontGear(int index) {
        return this.frontGears.get(index);
    }

    BackGear getBackGear(int index) {
        return this.backGears.get(index);
    }

    void modifyfrontWheel(Wheel newfrontWheel) {
        this.frontWheel = newfrontWheel;
    }


    void modifybackWheel(Wheel newbackWheel) {
        this.backWheel = newbackWheel;
    }

    void addFrontGear(FrontGear newFrontGear) {
        this.frontGears.add(newFrontGear); 
    }

    void addBackGear(BackGear newBackGear) {
        this.backGears.add(newBackGear);
    }

    public static void main(String args[]) {

        Gear frontGear = new FrontGear(21.3, 24.1);
        Gear backGear = new BackGear(21.3, 24.1);
        Tyre tyre = new Tyre(24.0);
        Rim rim = new Rim(23.0);

        Hashtable<String, Object> wheelHash1 = new Hashtable<String, Object>();
        wheelHash1.put("tyre", tyre);
        wheelHash1.put("rim", rim);
        Wheel frontWheel = new Wheel(wheelHash1);
        Hashtable<String, Object> wheelHash2 = new Hashtable<String, Object>();
        wheelHash2.put("tyre", tyre);
        wheelHash2.put("rim", rim);
        Wheel backWheel = new Wheel(wheelHash2);

        Hashtable<String, Object> bicycleHash = new Hashtable<String, Object>();
        bicycleHash.put("frontWheel", frontWheel);
        bicycleHash.put("backWheel", backWheel);
        Bicycle bicycle = new Bicycle(bicycleHash);
        bicycle.addFrontGear((FrontGear)frontGear);
        bicycle.addBackGear((BackGear)backGear);

        System.out.println("Bicycle Features:");

        System.out.println("    frontWheel Features:");
        System.out.println("        Tyre Features:");
        System.out.println("            Size: " + bicycle.getfrontWheel().getTyre().getThickness());
        System.out.println("        Rim Features:");
        System.out.println("            Size: " + bicycle.getfrontWheel().getRim().getDiameter());
        System.out.println("        Diameter:");
        System.out.println("            Value: " + bicycle.getfrontWheel().getDiameter());
        System.out.println("        Circumference:");
        System.out.println("            Value: " + bicycle.getfrontWheel().circumference());
        
        System.out.println("    backWheel Features:");
        System.out.println("        Tyre Features:");
        System.out.println("            Size: " + bicycle.getbackWheel().getTyre().getThickness());
        System.out.println("        Rim Features:");
        System.out.println("            Size: " + bicycle.getfrontWheel().getRim().getDiameter());
        System.out.println("        Diameter:");
        System.out.println("            Value: " + bicycle.getbackWheel().getDiameter());
        System.out.println("        Circumference:");
        System.out.println("            Value: " + bicycle.getbackWheel().circumference());
        
        System.out.println("    Gear Features:");
        System.out.println("        Front Gear(s):");
        System.out.println("            ChainRing:");
        System.out.println("                Size: " + bicycle.getFrontGear(0).getChainRingSize());
        System.out.println("            Cog:");
        System.out.println("                Size: " + bicycle.getFrontGear(0).getCogSize());

        System.out.println("        Back Gear(s):");
        System.out.println("            ChainRing:");
        System.out.println("                Size: " + bicycle.getBackGear(0).getChainRingSize());
        System.out.println("            Cog:");
        System.out.println("                Size: " + bicycle.getBackGear(0).getCogSize());

        System.out.println("-----------------------------------------------");
        System.out.println("    Gear Ratio For the Wheel:");
        System.out.println("            Value1: " + bicycle.getFrontGear(0).gearInches(bicycle.getfrontWheel()));
        System.out.println("            Value2: " + bicycle.getFrontGear(0).gearInches(bicycle.getbackWheel()));

    }
}

