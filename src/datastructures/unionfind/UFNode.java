package datastructures.unionfind;

/**
 * Created by pavanprakash-g on 1/23/18.
 */
public class UFNode {

    public int nodeId;
    public UFNode repNode;

    public int getNodeId() {
        return nodeId;
    }

    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
    }

    public UFNode getRepNode() {
        return repNode;
    }

    public void setRepNode(UFNode repNode) {
        this.repNode = repNode;
    }

}
