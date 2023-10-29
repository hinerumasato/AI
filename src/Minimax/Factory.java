package Minimax;

public class Factory {
    public static int minimax(Node node, boolean isMax) {

        if(node.neighbors.size() == 0)
            return node.getValue();

        if(isMax) {
            int bestValue = Integer.MIN_VALUE;
            for(Node neighbor : node.getNeighbors())
                bestValue = Math.max(bestValue, minimax(neighbor, false));
            return bestValue;
        } else {
            int wrostValue = Integer.MAX_VALUE;
            for(Node neighbor : node.getNeighbors())
                wrostValue = Math.min(wrostValue, minimax(neighbor, true));
            return wrostValue;
        }
    }

    public static int alphaBetaPruning(Node node, boolean isMax, int alpha, int beta) {
        if(node.getNeighbors().size() == 0)
            return node.getValue();

        if(isMax) {
            for(Node neighbor : node.getNeighbors()) {
                alpha = Math.max(alpha, alphaBetaPruning(neighbor, false, alpha, beta));
                if(alpha >= beta) break;
            }
            return alpha;
        }
        else {
            for(Node neighbor : node.getNeighbors()) {
                beta = Math.min(beta, alphaBetaPruning(neighbor, true, alpha, beta));
                if(alpha >= beta) break;
            }
            return beta;
        }
    }
}
