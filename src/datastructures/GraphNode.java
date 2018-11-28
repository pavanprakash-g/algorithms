package datastructures;

import java.util.ArrayList;

public class GraphNode {
    private int value;
    private ArrayList<GraphNode> adj;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ArrayList<GraphNode> getAdj() {
        return adj;
    }

    public void setAdj(ArrayList<GraphNode> adj) {
        this.adj = adj;
    }
}
