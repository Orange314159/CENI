package src;

public class Node extends Component {

    public boolean equals(Component component){
        if (component instanceof Node){
            Node other = (Node) component;
            return this.locationX == other.locationX && this.locationY == other.locationY && this.width == other.width && this.height == other.height;
        }
        return false;
    }

    public String toString(){
        return "{node: location=(" + locationX + "," + locationY +")}" ;
    }
}
