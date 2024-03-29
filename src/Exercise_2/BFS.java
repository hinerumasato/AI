package Exercise_2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BFS {
    public List<Node> bfsUsingQueue(Node start) {
        List<Node> result = new ArrayList<>();
        Queue<Node> queue = new ConcurrentLinkedQueue<Node>();
        result.add(start);
        queue.add(start);

        while(!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if(currentNode.getNeighbors() != null) {
                for (Node neighbor : currentNode.getNeighbors()) {
                    if(!neighbor.isVisited()) {
                        neighbor.setVisited(true);
                        queue.add(neighbor);
                        result.add(neighbor);
                    }
                }
            }
        }
        return result;
    }

    public void setVisitedFalseAll(Node start) {
        start.setVisited(false);
        for (Node node : start.getNeighbors()) {
            if(node.isVisited())
                setVisitedFalseAll(node);
        }
    }

    public List<Node> bfsFindPath(Node start, Node goal) {
        if(start.equals(goal))
            return new ArrayList<Node>(Arrays.asList(start));
        List<Node> result = new ArrayList<>();
        Queue<Node> queue = new ConcurrentLinkedQueue<Node>();
        result.add(start);
        queue.add(start);
        while(!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if(currentNode.getNeighbors() != null) {
                for (Node neighbor : currentNode.getNeighbors()) {
                    if(!neighbor.isVisited()) {
                        neighbor.setVisited(true);
                        if(neighbor.equals(goal)) {
                            return neighbor.getPath(start);
                        }
                        queue.add(neighbor);
                        result.add(neighbor);
                    }
                }
            }
        }
        return new ArrayList<>();
    }
}
