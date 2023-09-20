package Queen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node {
    private State state;
    private Node parent;
    private List<Node> neighbors;
    private boolean visited;

    public Node(State state) {
        this.state = state;
        this.parent = null;
        this.neighbors = new ArrayList<Node>();
        this.visited = false;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parentNode) {
        this.parent = parentNode;
    }

    public List<Node> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Node> neighbors) {
        this.neighbors = neighbors;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Node> getPath(Node startNode) {
        if(this.equals(startNode))
            return new ArrayList<Node>(Arrays.asList(this));
        else {
            List<Node> list = this.parent.getPath(startNode);
            list.add(this);
            return list;
        }
    }

}
