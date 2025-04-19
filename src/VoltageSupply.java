package src;

public class VoltageSupply extends Component {

    public double voltage;
    public Pulse pulse;
    public boolean regular; // there are two allowed types of voltage supply, regular and pulse a true signifies that this is a regular voltage supply

    public VoltageSupply(){
        this(0,0,0,0,0);
    }
    
    public VoltageSupply(double voltage, int locationX, int locationY, int width, int height){
        if(locationX < 0 || locationY < 0){
            throw new IllegalArgumentException("Location must be greater than or equal to 0.");
        }
        if(width < 0 || height < 0){
            throw new IllegalArgumentException("Width and Height must both be greater than or equal to 0.");
        }

        this.voltage   = voltage;
        this.regular   = true;
        this.width     = width;
        this.height    = height;
        this.locationX = locationX;
        this.locationY = locationY;
        this.pulse     = null;
    }    

    public VoltageSupply(Pulse pulse, int locationX, int locationY, int width, int height){
        if(locationX < 0 || locationY < 0){
            throw new IllegalArgumentException("Location must be greater than or equal to 0.");
        }
        if(width < 0 || height < 0){
            throw new IllegalArgumentException("Width and Height must both be greater than or equal to 0.");
        }

        this.pulse     = pulse;
        this.locationX = locationX;
        this.locationY = locationY;
        this.width     = width;
        this.height    = height;
        this.regular   = false;
        this.voltage   = 0;
    }

    public boolean equals(Component component){
        if (component instanceof VoltageSupply) { // ensure that the component being compared against is also a voltage supply
            VoltageSupply other = (VoltageSupply) component;
            return this.pulse.equals(other.pulse) && (this.regular == other.regular) && this.voltage == other.voltage && this.locationX == other.locationX && this.locationY == other.locationY;
        }
        return false;
    }

    public String toString(){
        if (this.regular){
            return "{voltagesupply: voltage=" + voltage + " location=(" + locationX + "," + locationY +")}";
        }
        return "{voltagesupply: pulse=" + pulse + " location=(" + locationX + "," + locationY +")}";
        
    }       
}
