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
        Node node16 = new Node();
        Node node17 = new Node();
        Node node18 = new Node();
        Node node19 = new Node();
        Node node20 = new Node();
        Node node21 = new Node();
        Node node22 = new Node();
        Node node23 = new Node();
        Node node24 = new Node();

        node1.addNeighbor(node2); node1.addNeighbor(node3); node1.addNeighbor(node4);
        node2.addNeighbor(node5); node2.addNeighbor(node6);
        node3.addNeighbor(node7); node3.addNeighbor(node8);
        node4.addNeighbor(node9); node4.addNeighbor(node10);
        node5.addNeighbor(node11); node5.addNeighbor(node12);
        node6.addNeighbor(node13); node6.addNeighbor(node14);
        node7.addNeighbor(node15); node7.addNeighbor(node16); node7.addNeighbor(node17);
        node8.addNeighbor(node18); node8.addNeighbor(node19);
        node9.addNeighbor(node20); node9.addNeighbor(node21); node9.addNeighbor(node22);
        node10.addNeighbor(node23); node10.addNeighbor(node24);

        node11.setValue(2);
        node12.setValue(4);
        node13.setValue(0);
        node14.setValue(-7);
        node15.setValue(-5);
        node16.setValue(3);
        node17.setValue(6);
        node18.setValue(1);
        node19.setValue(9);
        node20.setValue(5);
        node21.setValue(-5);
        node22.setValue(1);
        node23.setValue(4);
        node24.setValue(8);

        System.out.println(Factory.alphaBetaPruning(node1, true, Integer.MIN_VALUE, Integer.MAX_VALUE));
        // System.out.println(Factory.minimax(node1, true));
    }
}
