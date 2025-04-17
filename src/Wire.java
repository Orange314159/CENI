package src;

public class Wire<T> {

    public final T destination;
    public final double resistance;

    public Wire(T destination, double resistance) {
        if (destination == null) {
            throw new IllegalArgumentException("Destination cannot be null");
        }
        if (resistance < 0) {
            throw new IllegalArgumentException("Resistance must be positive");
        }
        this.destination = destination;
        this.resistance = resistance;
    }
    
}
