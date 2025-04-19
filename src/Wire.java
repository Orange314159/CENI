package src;

public class Wire<T> {

    public T destination;
    public double resistivity;
    public int length;

    public Wire(T destination, double resistivity, int length) {
        if (destination == null) {
            throw new IllegalArgumentException("Destination cannot be null");
        }
        if (resistivity < 0) {
            throw new IllegalArgumentException("Resistivity must be positive");
        }
        if (length < 0){
            throw new IllegalArgumentException("Length must be positive");
        }
        this.destination = destination;
        this.resistivity = resistivity;
        this.length = length;
    }

    public Wire(T destination, String material, int length) {
        if (destination == null) {
            throw new IllegalArgumentException("Destination cannot be null");
        }
        this.destination = destination;
        this.length = length;
        material = material.trim().toLowerCase();
        // these values are estimates for the materials at 20C
        if        (material.equals("silver")){
            this.resistivity = 1.59 * Math.pow(10.0, -8.0);  // 1.55E-8
        } else if (material.equals("copper")){
            this.resistivity = 1.724 * Math.pow(10.0, -8.0); // 1.7E-8
        } else if (material.equals("gold")){
            this.resistivity = 2.44 * Math.pow(10.0, -8.0);  // 2.2E-8
        } else if (material.equals("aluminum")){
            this.resistivity = 2.65 * Math.pow(10.0, -8.0);  // 2.7E-8
        } else if (material.equals("glass")){
            this.resistivity = Math.pow(10.0, 14.0); // not sure why anyone would want to use glass, it's an insulator, but it's an option
        } else {
            this.resistivity = 1.724 * Math.pow(10.0, -8.0); // copper is the most common element for wires so it will be the assumption
        }
        
    }

    public double getResistance(){
        return this.resistivity * (double) this.length;
    }
    
}
