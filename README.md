File Name: Bicycle.java
_____________________________________________________________________________________________________________________________
IMPLEMENTATION: 
> It implements the code of Bicycles having Gears. The code is implemented by making following design choices to trade of between efficient code and it being scalable in the future. 
Classes:
1. Bicycle
2. Gear
3. Wheel
4. Tyre
5. Rim

> The classes are made keeping in mind that we need to reduce coupling between them and each one having a single responsibility following the DRY and they follow the DEMETER rule since there is least coupling between the classes.

The subclasses of 
1. FrontGear and 
2. BackGear 
are also added keeping in mind that they have some specific implementations and hence need to separate them.

> The interface DiametricObjects ensures that gearInches does not mind anything but the diameter of any object passed into it.

Further Additions to be done:
1. Add FrontTyre and Backtyre subclasses from Tyre class since the tyres can be classified as front and back based on the treads they have on them.
2. Exception Handling.

_____________________________________________________________________________________________________________________________
COMPILE: javac Bicycle.java -d <dir-name> 
Explanation: The .class file is stored in the dir named <dir-name>.

RUN: java -cp ClassFiles <package-name>.Bicycle 
Explanation: Part of package <package-name>.
_____________________________________________________________________________________________________________________________