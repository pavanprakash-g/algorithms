package graphs;

import datastructures.GraphNode;

import java.util.*;

public class GraphTraversal{

    public static String getBFSTraversal(GraphNode root){
        Queue<GraphNode> queue = new LinkedList<>();
        Map<GraphNode, Integer> visited = new HashMap<>();
        visited.put(root, 1);
        queue.add(root);
        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            GraphNode node = queue.remove();
            ArrayList<GraphNode> adjacency = node.getAdj();
            result.append(node.getValue());
            for(int i = 0; i < adjacency.size(); i++){
                if(!visited.containsKey(adjacency.get(i))) {
                    queue.add(adjacency.get(i));
                    visited.put(adjacency.get(i), 1);
//                    result.append(adjacency.get(i).getValue());
                }
            }
        }
        return result.toString();
    }

    public static String getDFSTraversal(GraphNode root){
        Stack<GraphNode> stack = new Stack<>();
        Map<GraphNode, Integer> visited = new HashMap<>();
        visited.put(root, 1);
        stack.add(root);
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            GraphNode node = stack.pop();
            ArrayList<GraphNode> adjacency = node.getAdj();
            result.append(node.getValue());
            for(int i = 0; i < adjacency.size(); i++){
                if(!visited.containsKey(adjacency.get(i))) {
                    stack.add(adjacency.get(i));
                    visited.put(adjacency.get(i), 1);
                }
            }
        }
        return result.toString();
    }

    public static String getTopologicalSort(GraphNode root, int numOfVertices){
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=0; i<numOfVertices; i++){

        }
        return "";
    }

    public static GraphNode inputGraph(){
        /**
         * 1----- 2
         * |   /  |
         * | /    |
         * 4------3
         */
        System.out.println("1----- 2\n" +
                "           |   /  |\n" +
                "           | /    |\n" +
                "           4------3\n" +
                "   ");
        GraphNode root = new GraphNode();
        GraphNode two = new GraphNode();
        GraphNode three = new GraphNode();
        GraphNode four = new GraphNode();
        root.setValue(1);
        two.setValue(2);
        three.setValue(3);
        four.setValue(4);
        ArrayList<GraphNode> arr = new ArrayList<>();
        arr.add(two);
        arr.add(four);
        root.setAdj(arr);

        arr = new ArrayList<>();
        arr.add(three);
        arr.add(four);
        two.setAdj(arr);

        arr = new ArrayList<>();
        arr.add(four);
        arr.add(two);
        three.setAdj(arr);

        arr = new ArrayList<>();
        arr.add(two);
        arr.add(three);
        four.setAdj(arr);

        return root;
    }

    public static GraphNode directedGraph(){
        /**
         * 1-----> 2
         * |     /^
         * |   /  |
         * | /    |
         * vv     |
         * 4<-----3
         */
        System.out.println("1-----> 2\n" +
                "           |     /^\n" +
                "           |   /  |\n" +
                "           | /    |\n" +
                "           vv     |\n" +
                "           4<-----3");
        GraphNode root = new GraphNode();
        GraphNode two = new GraphNode();
        GraphNode three = new GraphNode();
        GraphNode four = new GraphNode();
        root.setValue(1);
        two.setValue(2);
        three.setValue(3);
        four.setValue(4);
        ArrayList<GraphNode> arr = new ArrayList<>();
        arr.add(two);
        arr.add(four);
        root.setAdj(arr);

        arr = new ArrayList<>();
        arr.add(four);
        two.setAdj(arr);

        arr = new ArrayList<>();
        arr.add(four);
        arr.add(two);
        three.setAdj(arr);

        arr = new ArrayList<>();
        four.setAdj(arr);

        return root;
    }


    public static void main(String[] args){
        GraphNode root = GraphTraversal.inputGraph();
        System.out.println("BFS: "+GraphTraversal.getBFSTraversal(root));
        System.out.println("DFS: "+GraphTraversal.getDFSTraversal(root));
    }
}
