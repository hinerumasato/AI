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
}
