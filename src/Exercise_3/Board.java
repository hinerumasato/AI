package Exercise_3;

public class Board {
    private int numQueen;
    private int[] queens;

    public Board(int numQueen) {
        this.numQueen = numQueen;
        this.queens = new int[numQueen];
    }

    public int[] getQueens() {
        return queens;
    }

    public void setQueens(int[] queens) {
        this.queens = queens;
    }

    public int getNumQueen() {
        return numQueen;
    }

    public void setNumQueen(int numQueen) {
        this.numQueen = numQueen;
    }

    public int heuristic() {
        int sum = 0;
        for(int i = 0; i < numQueen - 1; i++)
            for(int j = i+1; j < numQueen; j++)
                if(Math.abs(queens[i] - queens[j]) == j - i)
                    sum++;
        return sum;
    }
    
}
