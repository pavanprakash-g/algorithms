package datastructures.unionfind;

import java.util.HashMap;

/**
 * Created by pavanprakash-g on 1/23/18.
 */
public class UnionFind {

    private HashMap<Integer, UFNode> nodesList;

    public UnionFind(HashMap<Integer, UFNode> nodesList) {
        this.nodesList = nodesList;
    }

    public void makeSet(){
        for(HashMap.Entry<Integer, UFNode> entry : nodesList.entrySet()) {
            UFNode node= entry.getValue();
            node.repNode = node;
        }
    }

    public UFNode findSet(UFNode singleNode){
        return singleNode.repNode;
    }

    public UFNode union(UFNode parent, UFNode child){
        //This following is implementation for path compression.
        while (parent.nodeId != parent.repNode.nodeId){
            parent = parent.repNode;
        }
        child.repNode = parent;
        return child;
    }
}
