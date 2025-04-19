package src;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

public class Circuit<T> {

    private final Map<T, List<Wire<T>>> adjacencyList;

    public Circuit() {
        this.adjacencyList = new HashMap<>();
    }

    public void addComponent(T component) {
        if (component == null) {
            throw new IllegalArgumentException("Component cannot be null");
        }
        // Check if component is already in the adjacency list, if not add it
        if (!adjacencyList.containsKey(component)) {
            adjacencyList.put(component, new ArrayList<>());
        }
    }

    public void addWire(T source, T destination, double resistivity, int length) {
        if (source == null || destination == null) {
            throw new IllegalArgumentException("Source and destination cannot be null");
        }
        if (resistivity < 0) {
            throw new IllegalArgumentException("Resistance must be positive");
        }
        if (length < 0) {
            throw new IllegalArgumentException("Length must be positive");
        }

        // check if source and destination in adjacency list, if not add them
        adjacencyList.computeIfAbsent(source, k -> new ArrayList<>());

        // add the wire to the adjacency list (ciruit is undirected)
        adjacencyList.get(source).add(new Wire<>(destination, resistivity, length));
        adjacencyList.get(destination).add(new Wire<>(source, resistivity, length));
    }

    public List<Wire<T>> getWires(T component) {
        if (component == null) {
            throw new IllegalArgumentException("Component cannot be null");
        }
        return adjacencyList.getOrDefault(component, new ArrayList<>());
    }

    public List<T> getConnectedComponents(T component) {
        if (component == null) {
            throw new IllegalArgumentException("Component cannot be null");
        }
        List<T> connectedComponents = new ArrayList<>();
        List<Wire<T>> wires = getWires(component);
        for (Wire<T> wire : wires) {
            connectedComponents.add(wire.destination);
        }
        return connectedComponents;
    }

    public Set<T> getComponents() {
        return new HashSet<>(adjacencyList.keySet());
    }

    public Map<T, List<Wire<T>>> getAdjacencyList() {
        return new HashMap<>(adjacencyList);
    }

    public int getNumberOfComponents() {
        return adjacencyList.size();
    }

    public int getNumberOfWires() {
        int wireCount = 0;
        // loop through the adjacency list and count the wires
        for (List<Wire<T>> wire : adjacencyList.values()) {
            wireCount += wire.size();
        }
        return wireCount;
    }

    public boolean isEmpty() {
        return adjacencyList.isEmpty();
    }

    public boolean containsComponent(T component) {
        if (component == null) {
            throw new IllegalArgumentException("Component cannot be null");
        }

        return adjacencyList.containsKey(component);
    }

    public boolean containsWire(T source, T destination) {
        if (source == null || destination == null) {
            throw new IllegalArgumentException("Source and destination cannot be null");
        }

        List<Wire<T>> wires = getWires(source);
        for (Wire<T> wire : wires) {
            if (wire.destination.equals(destination)) {
                return true;
            }
        }
        return false;
    }

    public double getSimpleResistance(T source, T destination) {
        if (source == null || destination == null) {
            throw new IllegalArgumentException("Source and destination cannot be null");
        }

        if (source.equals(destination)) {
            throw new IllegalArgumentException("Source and destination cannot be the same");
        }

        List<T> compoList = getConnectedComponents(source);
        if (!compoList.contains(destination)) {
            return -1; // return -1 if the destination and source are not directly connected
        }

        List<Wire<T>> wires = getWires(source);
        for (Wire<T> wire : wires) {
            if (wire.destination.equals(destination)) {
                return wire.getResistance();
            }
        }
        // a wire should be found between source and destination because we checked if the destination is in the connected components of the source
        throw new IllegalArgumentException("Wire not found between source and destination");
    }


    
}