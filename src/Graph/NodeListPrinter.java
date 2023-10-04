package Graph;
import java.util.List;

import Queen.State;

public class NodeListPrinter {
    public static void print(List<Node> nodes) {
        for (Node node : nodes) {
            System.out.print(node.getObject() + " ");
        }
    }

    public static void printChessBoard(List<Node> nodes) {
        if(nodes.size() > 0) {
            Node result = nodes.get(nodes.size() - 1);
            State state = (State) result.getObject();
            int size = state.getColumns().size();
            String[][] board = new String[size][size];
    
            for(int i = 0; i < size; i++)
                for(int j = 0; j < size; j++)
                    board[i][j] = "0";
            
            for(int i = 0; i < size; i++) 
                board[i][state.getColumns().get(i)] = "Q";
    
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[i].length; j++)
                    System.out.print(board[i][j] + " ");
                System.out.println();
            }
            System.out.println();
        }
    }
}
