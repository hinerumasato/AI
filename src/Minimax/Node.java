package Minimax;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int value;
    public List<Node> neighbors;

    public Node() {
        this.neighbors = new ArrayList<Node>();
    };

    public Node(int value) {
        this.value = value;
        this.neighbors = new ArrayList<Node>();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<Node> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Node> neighbors) {
        this.neighbors = neighbors;
    }

    public void addNeighbor(Node node) {
        neighbors.add(node);
    }

}
