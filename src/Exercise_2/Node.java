package Exercise_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node {
    private Object object;
    private Node parent;
    private List<Node> neighbors;
    private boolean visited;

    public Node(Object object) {
        this.object = object;
        this.parent = null;
        this.neighbors = new ArrayList<Node>();
        this.visited = false;
    }

    public Node(Object object, Node parent) {
        this.object = object;
        this.parent = parent;
        this.neighbors = new ArrayList<Node>();
        this.visited = false;
        
        parent.addNeighbors(this);
    }

    public void addNeighbors(Node ...neighbors) {
        for (Node neighbor : neighbors) {
            this.getNeighbors().add(neighbor);
            neighbor.getNeighbors().add(this);
            neighbor.setParent(this);
        }
    }

    public List<Node> getPath(Node startNode) {
        if (this.getObject().equals(startNode.getObject()))
            return new ArrayList<Node>(Arrays.asList(this));
        else {
            List<Node> list = this.parent.getPath(startNode);
            list.add(this);
            return list;
        }
    }

    public Object getObject() {
        return object;
    }

    public Node getParent() {
        return parent;
    }

    public List<Node> getNeighbors() {
        return neighbors;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setNeighbors(List<Node> neighbors) {
        this.neighbors = neighbors;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return "Node [object=" + object +"]";
    }

    

}
