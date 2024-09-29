
package ru.kasalinskyandrey.lesson9;

import java.util.*;

class Graph<N, E extends Edge<N, E>> {
    String NODE_YET_MESSAGE = "Такой узел уже есть";
    Map<N, List<E>> graph = new HashMap<>();

    public void print() {
        for (Map.Entry<N, List<E>> entry : graph.entrySet()) {
            N key = entry.getKey();
            System.out.println(key);
            List<E> value = entry.getValue();
            for (E e : value) {
                System.out.println(e.getNode1() + " + " + e.getNode2() + " + " + e.getWeight());
            }
        }
    }

    public Graph(){
    }

    public Graph(Map<N, List<E>> graph){
        this.graph = graph;
    }





    void addNode(N node) {
        if(!graph.containsKey(node)) {
            graph.put(node, null);
        }
        else System.out.println(NODE_YET_MESSAGE);
    }

    void addEdge(N node1, N node2, E edge){
        List<E> list1 = new ArrayList<>();
        List<E> list2 = new ArrayList<>();

        if (graph.containsKey(node1)) {list1 = graph.get(node1);}
            list1.add(edge);
            graph.put(node1, list1);

        if (graph.containsKey(node2)) {list2 = graph.get(node2);}
            list2.add(edge);
            graph.put(node2, list2);
    }

    List<E> getNeighbour(N name){
        List<E> edgeList = graph.get(name);
        return edgeList;
    }

    Map<N, List<E>> getAllNodes(){
        return graph;
    }

    List<N> findShortestPath(N nodeFrom, N nodeTo) {

        Map<N, PathNode> map = new HashMap<>();

        List<N> shortPath = new ArrayList<>();
        shortPath.add(nodeFrom);

        N node = nodeFrom;
        while (node != nodeTo || node != null) {
            List<E> neighbourList = getNeighbour(nodeFrom);
            N nextNode;

            map.put(node, new PathNode());
            for (E e : neighbourList) {
                if (e.getNode1().equals(node)) {
                    nextNode = e.getNode2();
                } else {
                    nextNode = e.getNode1();
                }
                map.get(node).addNode(nextNode, e.getWeight());
                nodeFrom = nextNode;
            }
        }
        return  null;
    }

        class PathNode {
        List<N> nodes = new ArrayList<>();
        List<E> weights = new ArrayList<>();

            public List<E> getWeights() {
                return weights;
            }

            public List<N> getNodes() {
                return nodes;
            }

            public void addNode(N name, E weight){
                this.nodes.add(name);
                this.weights.add(weight);
            }

        }


}
