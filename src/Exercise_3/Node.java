package Exercise_3;

import java.util.Collection;
import java.util.List;

public class Node {
    private Board board;
    private List<Node> neighbors;

    public Node() {
    }

    public Node(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Node> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Node> neighbors) {
        this.neighbors = neighbors;
    }

    public void addNeighbor(Node neighbor) {
        this.neighbors.add(neighbor);
    }

    public void addNeighbors(Collection<Node> neighbors) {
        this.neighbors.addAll(neighbors);
    }

}
