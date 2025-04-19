package src;

public class Capacitor extends Component {

    public double capacitance;

    public Capacitor(){
        this(0, 0, 0, 0, 0);
    }
    
    public Capacitor(double capacitance, int locationX, int locationY, int width, int height){
        if(locationX < 0 || locationY < 0){
            throw new IllegalArgumentException("Location must be greater than or equal to 0.");
        }
        if(width < 0 || height < 0){
            throw new IllegalArgumentException("Width and Height must both be greater than or equal to 0.");
        }
        
        this.capacitance = capacitance;
        this.locationX   = locationX;
        this.locationY   = locationY;
        this.width       = width;
        this.height      = height;
    }

    public boolean equals(Component component){
        if (component instanceof Capacitor) { // ensure that the component being compared against is also a capacitor
            Capacitor other = (Capacitor) component;
            return this.locationX == other.locationX && this.locationY == other.locationY && this.capacitance == other.capacitance && this.width == other.width && this.height == other.height;
        }
        return false;
    }

    public String toString(){
        return "{capacitor: capacitance=" + capacitance + " location=(" + locationX + "," + locationY +")}" ;
    }    
}
