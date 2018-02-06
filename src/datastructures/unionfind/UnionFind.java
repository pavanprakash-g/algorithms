package datastructures.unionfind;

import java.util.HashMap;
import java.util.List;

/**
 * Created by pavanprakash-g on 1/23/18.
 */
public class UnionFind {

    private HashMap<Integer, Node> nodesList;

    public UnionFind(HashMap<Integer, Node> nodesList) {
        this.nodesList = nodesList;
    }

    public void makeSet(){
        for(HashMap.Entry<Integer, Node> entry : nodesList.entrySet()) {
            Node node= entry.getValue();
            node.repNode = node;
        }
    }

    public Node findSet(Node singleNode){
        return singleNode.repNode;
    }

    public Node union(Node parent, Node child){
        //This following is implementation for path compression.
        while (parent.nodeId != parent.repNode.nodeId){
            parent = parent.repNode;
        }
        child.repNode = parent;
        return child;
    }
}
