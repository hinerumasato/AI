import java.util.ArrayList;
import java.util.Arrays;

import Exercise_2.BFS;
import Exercise_2.Node;
import Exercise_2.NodeListPrinter;

public class App {

    public static void testGraph() {
        Node startNode = new Node("1", null);
        Node node2 = new Node("2", startNode);
        Node node3 = new Node("3", startNode);
        Node node4 = new Node("4", node3);
        Node node5 = new Node("5", node2);
        Node node6 = new Node("6", node2);
        Node node7 = new Node("7", node3);
        Node node8 = new Node("8", node7);

        startNode.setNeighbors(new ArrayList<Node>(Arrays.asList(node2, node3)));
        node2.setNeighbors(new ArrayList<Node>(Arrays.asList(node5, node6)));
        node3.setNeighbors(new ArrayList<Node>(Arrays.asList(node4, node7)));
        node4.setNeighbors(new ArrayList<Node>(Arrays.asList(node3)));
        node5.setNeighbors(new ArrayList<Node>(Arrays.asList(node2)));
        node6.setNeighbors(new ArrayList<Node>(Arrays.asList(node2)));
        node7.setNeighbors(new ArrayList<Node>(Arrays.asList(node3, node8)));
        node8.setNeighbors(new ArrayList<Node>(Arrays.asList(node7)));

        BFS bfs = new BFS();
        NodeListPrinter.print(bfs.bfsFindPath(startNode, node8));
    }

    public static void main(String[] args) {
        
    }
}
