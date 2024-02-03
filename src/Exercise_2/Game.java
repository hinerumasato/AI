package Exercise_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Game {
    private Node node;

    public Game(Node node) {
        this.node = node;
    }

    public List<List<Node>> placeQueen() {
        List<List<Node>> result = new ArrayList<List<Node>>();
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
                        Node neighbor = new Node(neighborState, currentNode);

                        if (neighborState.isGoalState()) {
                            BFS bfs = new BFS();
                            result.add(bfs.bfsFindPath(this.node, neighbor));
                            bfs.setVisitedFalseAll(neighbor);
                            break;
                        } else queue.add(neighbor);
                    }
                }
        }

        return result;
    }

    public static void main(String[] args) {
        State initialState = new State(8);
        Node start = new Node(initialState);
        Game game = new Game(start);
        System.out.println(game.placeQueen().size());

        for (List<Node> list : game.placeQueen())
            NodeListPrinter.printChessBoard(list);
    }

}
