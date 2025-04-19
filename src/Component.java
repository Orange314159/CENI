package src;

public abstract class Component {
    // examples of components include: Resistor, Capacitor, Transistor, VoltageSupply, and a baisc node

    int locationX;
    int locationY;
    int width;
    int height; 

    // I require that all components have a equals method and a toString method
    public abstract boolean equals(Component component);
    public abstract String toString();
}
