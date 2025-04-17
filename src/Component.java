package src;

public abstract class Component {
    // examples of components include: Resistor, Capacitor, Inductor, Transistor, PowerSupply, and a baisc node

    private double resistance; // most components have resistance in some form or another

    // I require that all components have a equals method and a toString method
    public abstract boolean equals();
    public abstract String toString();
}
