package mst;

import datastructures.Edge;
import datastructures.unionfind.Node;
import datastructures.unionfind.UnionFind;

import java.util.*;

/**
 * Created by pavanprakash-g on 1/23/18.
 */
public class KruskalsA {
    public static HashMap<Integer, Node> createList(int nodeCount){
        HashMap<Integer, Node> nodeList = new LinkedHashMap<>();
        for(int i = 0; i < nodeCount; i++){
            Node node = new Node();
            node.nodeId = i;
            nodeList.put(i, node);
        }
        return nodeList;
    }

    public static void kruskalsA(List<Edge> edgeList, UnionFind unionFind, HashMap<Integer, Node> nodeList, int[][] result){
        HashMap<Integer, Integer> nodes = new HashMap<>();
        for(Edge edge: edgeList){
            nodes.put(edge.getId(), edge.getWeight());
        }
        List list = new LinkedList(nodes.entrySet());
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o1)).getValue())
                        .compareTo(((Map.Entry) (o2)).getValue());
            }
        });

        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
            int id = (Integer)entry.getKey();
            for(Edge edge: edgeList){
                if(id == edge.getId()) {
                    if(unionFind.findSet(nodeList.get(edge.getSourceId())) != unionFind.findSet(nodeList.get(edge.getDestId()))){
                        unionFind.union(nodeList.get(edge.getSourceId()), nodeList.get(edge.getDestId()));
                        result[nodeList.get(edge.getSourceId()).nodeId][nodeList.get(edge.getDestId()).nodeId] = edge.getWeight();
                    }
                }
            }
        }
        printMST(result);
    }

    private static void printMST(int[][] result){
        for(int i = 0; i <result.length; i++){
            for(int j = 0; j < result[i].length; j++){
                if(result[i][j] > 0) {
                    System.out.println(i+" to "+j+"\n");
                }
            }
        }
    }

    public static void main(String[] args){
        int graph[][] = new int[][] {
                                        {0, 2, 0, 6, 0},
                                        {2, 0, 3, 8, 5},
                                        {0, 3, 0, 0, 7},
                                        {6, 8, 0, 0, 9},
                                        {0, 5, 7, 9, 0},
                                    };
        List<Edge> edgeList = generateEdges(graph);
        HashMap<Integer, Node> nodeList = createList(graph.length);
        UnionFind unionFind = new UnionFind(nodeList);
        unionFind.makeSet();
        int resultSet[][] = new int[graph.length][graph[0].length];
        //Initialize result;
        for(int i = 0; i<resultSet.length; i++) {
            for (int j = 0; j < resultSet[i].length; j++) {
                resultSet[i][j] = 0;
            }
        }
        kruskalsA(edgeList, unionFind, nodeList, resultSet);
    }

    private static List<Edge> generateEdges(int[][] graph){
        List<Edge> edgeList= new LinkedList<>();
        int counter = 0;
        for(int i = 0; i<graph.length; i++) {
            for (int j = i+1; j < graph[i].length; j++) {
                if(graph[i][j] > 0){
                    Edge edge = new Edge();
                    edge.setSourceId(i);
                    edge.setDestId(j);
                    edge.setWeight(graph[i][j]);
                    edge.setId(counter);
                    edgeList.add(edge);
                    counter++;
                }
            }
        }
        return edgeList;
    }
}
