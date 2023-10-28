package Minimax;

public class Main {
    public static void main(String[] args) {
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        Node node5 = new Node();
        Node node6 = new Node();
        Node node7 = new Node();
        Node node8 = new Node();
        Node node9 = new Node();
        Node node10 = new Node();
        Node node11 = new Node();
        Node node12 = new Node();
        Node node13 = new Node();
        Node node14 = new Node();
        Node node15 = new Node();

        node1.addNeighbor(node2); node1.addNeighbor(node3);
        node2.addNeighbor(node4); node2.addNeighbor(node5);
        node3.addNeighbor(node6); node3.addNeighbor(node7);
        node4.addNeighbor(node8); node4.addNeighbor(node9);
        node5.addNeighbor(node10); node5.addNeighbor(node11);
        node6.addNeighbor(node12); node6.addNeighbor(node13);
        node7.addNeighbor(node14); node7.addNeighbor(node15);

        node8.setValue(-1);
        node9.setValue(4);
        node10.setValue(2);
        node11.setValue(6);
        node12.setValue(-3);
        node13.setValue(-5);
        node14.setValue(0);
        node15.setValue(7);

        System.out.println(Factory.minimax(node1, true));
    }
}
