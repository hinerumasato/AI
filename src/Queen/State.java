package Queen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class State {
    private int size;
    private List<Integer> columns;

    public State(int size) {
        this.size = size;
        this.columns = new ArrayList<Integer>();
    }

    public int getSize() {
        return this.size;
    }

    public List<Integer> getColumns() {
        return this.columns;
    }

    public void setColumns(List<Integer> columns) {
        this.columns = columns;
    }

    public void addColumns(int num) {
        this.columns.add(num);
    }

    public void removeColumns(Integer num) {
        this.columns.remove(num);
    }

    public boolean isGoalState() {
        if(columns.size() < size)
            return false;

        Set<Integer> set = new HashSet<Integer>(columns);
        for(int i = 0; i < columns.size() - 1; i++) {
            for(int j = i+1; j < columns.size(); j++)
                if(Math.abs(columns.get(i) - columns.get(j)) == j - i)
                    return false;
        }

        return set.size() == columns.size();
    }

    public boolean isConflict() {
        Set<Integer> set = new HashSet<Integer>(columns);

        for(int i = 0; i < columns.size() - 1; i++)
            for(int j = i+1; j < columns.size(); j++)
                if(Math.abs(columns.get(i) - columns.get(j)) == j - i)
                    return true;
        
        return set.size() != columns.size();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof State) {
            State that = (State) obj;
            return this.size == that.size && this.columns.equals(that.columns);
        }
        return false;
    }

    @Override
    public String toString() {
        return "State [size=" + size + ", columns=" + columns + "]";
    }

    
    
}
