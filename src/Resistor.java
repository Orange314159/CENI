package src;

public class Resistor extends Component {

    public double resistance;

    public Resistor(){
        this(0, 0, 0, 0, 0);
    }
    
    public Resistor(double resistance, int locationX, int locationY, int width, int height){
        if(locationX < 0 || locationY < 0){
            throw new IllegalArgumentException("Location must be greater than or equal to 0.");
        }
        if(width < 0 || height < 0){
            throw new IllegalArgumentException("Width and Height must both be greater than or equal to 0.");
        }
        
        this.resistance = resistance;
        this.locationX  = locationX;
        this.locationY  = locationY;
        this.width      = width;
        this.height     = height;
    }

    public boolean equals(Component component){
        if (component instanceof Resistor) { // ensure that the component being compared against is also a resistor
            Resistor other = (Resistor) component;
            return this.locationX == other.locationX && this.locationY == other.locationY && this.resistance == other.resistance && this.width == other.width && this.height == other.height;
        }
        return false;
    }

    public String toString(){
        return "{resistor: resistance=" + resistance + " location=(" + locationX + "," + locationY +")}" ;
    }    
}
