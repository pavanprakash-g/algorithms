package datastructures.unionfind;

/**
 * Created by pavanprakash-g on 1/23/18.
 */
public class Node {

    public int nodeId;
    public Node repNode;

    public int getNodeId() {
        return nodeId;
    }

    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
    }

    public Node getRepNode() {
        return repNode;
    }

    public void setRepNode(Node repNode) {
        this.repNode = repNode;
    }

}
