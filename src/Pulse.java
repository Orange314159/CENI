package src;

public class Pulse {
    // pulse acts essentially as a struct would in a language such as C++ but because that is not an option in java it is implemented using a class
    public double highV;
    public double lowV;
    public double startDelay;
    public double riseTime;
    public double fallTime;
    public double pulseWidth;
    public double period;

    public Pulse(double highV, double lowV, double startDelay, double riseTime, double fallTime, double pulseWidth, double period){
        this.highV      = highV;
        this.lowV       = lowV;
        this.startDelay = startDelay;
        this.riseTime   = riseTime;
        this.fallTime   = fallTime;
        this.pulseWidth = pulseWidth;
        this.period     = period;     
    }

    public boolean equals(Object otherPulse){
        if (otherPulse instanceof Pulse){
            Pulse otherPulse2 = (Pulse) otherPulse;
            return this.highV == otherPulse2.highV && this.lowV == otherPulse2.lowV && this.startDelay == otherPulse2.startDelay && this.riseTime == otherPulse2.riseTime && this.fallTime == otherPulse2.fallTime && this.pulseWidth == otherPulse2.pulseWidth && this.period == otherPulse2.period;
        }
        return false;
    }

    public String tString(){
        return "pulse: highV= " + highV + " lowV=" + lowV + " startDelay=" + startDelay + " riseTime=" + riseTime + " fallTime=" + fallTime + " pulseWidth=" + pulseWidth + " period=" + period + "}";
    }
}
