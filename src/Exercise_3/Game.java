package Exercise_3;

public class Game {
    private void start() {
        Board initBoard = new Board(4);
        Node node = new Node(initBoard);
        Process process = new Process(node);
        process.start();
    }

    public static void main(String[] args) {
        new Game().start();
    }
}
