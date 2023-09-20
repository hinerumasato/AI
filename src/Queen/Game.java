package Queen;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import Graph.BFS;
import Graph.Node;

public class Game {
    private Node node;

    public Game(Node node) {
        this.node = node;
    }

    public List<Node> placeQueen() {
        Queue<Node> queue = new ConcurrentLinkedQueue<Node>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            State currentNodeState = (State) currentNode.getObject();
            for (int i = 0; i < currentNodeState.getSize(); i++)
                if (!currentNodeState.getColumns().contains(i)) {
                    State neighborState = new State(currentNodeState.getSize());
                    neighborState.setColumns(new ArrayList<Integer>(currentNodeState.getColumns()));
                    neighborState.addColumns(i);
                    if (!neighborState.isConflict()) {
                        if (neighborState.isGoalState()) {
                            Node goal = new Node(neighborState, currentNode);
                            BFS bfs = new BFS();
                            return bfs.bfsFindPath(this.node, goal);
                        } else {
                            Node neighbor = new Node(neighborState, currentNode);
                            queue.add(neighbor);
                        }
                    }
                }
        }

        return new ArrayList<Node>();
    }

}
