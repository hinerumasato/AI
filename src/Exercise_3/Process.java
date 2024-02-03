package Exercise_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Process {
    private Node node;
    private List<Node> moveResult;

    public Process(Node node) {
        this.node = node;
        this.moveResult = new LinkedList<>();
    }

    public void start() {
        suffle();
        climbingSearch();
        printMoveResult();
    }

    private void printMoveResult() {
        String printData = "--------------- INIT BOARD ---------------\n";
        printData += Arrays.toString(moveResult.get(0).getBoard().getQueens()) + "\n";
        printData += "------------- MOVE PROCESS --------------\n";
        for (Node node : moveResult) {
            printData += Arrays.toString(node.getBoard().getQueens()) + " -> ";
        }

        printData = printData.substring(0, printData.length() - 3);
        printData += "\n-------------- RESULT ------------------\n";
        printData += Arrays.toString(moveResult.get(moveResult.size() - 1).getBoard().getQueens()) + "\n";
        System.out.println(printData);
    }

    private void suffle() {
        int numQueen = node.getBoard().getNumQueen();
        int[] queens = new int[numQueen];
        Random rd = new Random();
        for(int i = 0; i < numQueen; i++)
            queens[i] = i;
        for(int i = 0; i < numQueen; i++) {
            int j = rd.nextInt(numQueen);
            int temp = queens[i];
            queens[i] = queens[j];
            queens[j] = temp;
        }
        node.getBoard().setQueens(queens);
    }

    private boolean isSolved() {
        return node.getBoard().heuristic() == 0;
    }

    /**
     * Mỗi nước đi sẽ là một lần thay đổi vị trí i j của quân cờ queen[i] và queen[j]
     */
    private void climbingSearch() {
        int bestScore = this.node.getBoard().heuristic();
        List<Node> neighbors = getNeighbors();
        while(!isSolved()) {
            moveResult.add(node);
            for (Node neighbor : neighbors) {
                int heuristic = neighbor.getBoard().heuristic();
                if(heuristic <= bestScore) {
                    bestScore = heuristic;
                    this.node = neighbor;
                    if(isSolved())
                        break;
                }
            }
            if(!isSolved()) {
                neighbors = getNeighbors();
            }
        }
        moveResult.add(node);
    }

    private List<Node> getNeighbors() {
        int numQueen = node.getBoard().getNumQueen();
        int[] queen = node.getBoard().getQueens();
        Set<Node> result = new HashSet<>();
        
        for(int i = 0; i < numQueen; i++)
            for(int j = 0; j < numQueen; j++)
                if(i != j) {
                    int[] cloneQueens = queen.clone();
                    int temp = cloneQueens[i];
                    cloneQueens[i] = cloneQueens[j];
                    cloneQueens[j] = temp;

                    Board neighborBoard = new Board(numQueen);
                    neighborBoard.setQueens(cloneQueens);
                    result.add(new Node(neighborBoard));
                }
        return new ArrayList<>(result);
    }
}
