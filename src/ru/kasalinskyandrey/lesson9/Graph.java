
package ru.kasalinskyandrey.lesson9;

import java.util.*;

class Graph<N, E extends Edge<N>> {
    Map<N, List<E>> graph = new HashMap<>();

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

    List<E> getEdgeNeighbour(N name){
        List<E> edgeList = graph.get(name);
        return edgeList;
    }

    List<N> getNodeNeighbour(N name){
        List<N> nodeNeighbour = new ArrayList<>();
        List<E> edgeNeighbour = this.getEdgeNeighbour(name);
        for(E e: edgeNeighbour){
            if(e.getNode1().equals(name)){
                nodeNeighbour.add(e.getNode2());
            }
            if(e.getNode2().equals(name)){
                nodeNeighbour.add(e.getNode1());
            }
        }
        return nodeNeighbour;
    }

    Map<N, List<E>> getAllNodes(){
        return graph;
    }

    Set<N> getAllNodesSet(){
        return graph.keySet();
    }
    E getEdge(N node1, N node2){
        List<E> edgeList = graph.get(node1);
        E result = null;

        for(E e: edgeList){
            if(e.getNode1().equals(node1) || e.getNode1().equals(node2)){
                result = e;
            }
        }
        return result;
    }

    public Map<N, Integer> dijkstra(N nodeFrom) {
        Map<N, Integer> distances = new HashMap<>();
        Set<N> nodes = getAllNodes().keySet();
        Set<N> visited = new HashSet<>();
        PriorityQueue<NodeForSearch> pq = new PriorityQueue<>();

        for (N node : nodes) {
            distances.put(node, Integer.MAX_VALUE);
        }

        distances.put(nodeFrom, 0);
        pq.add(new NodeForSearch(nodeFrom, 0));

        while (!pq.isEmpty()) {
            NodeForSearch current = pq.poll();
            N currentNode = current.getNode();
            int currentDistance = current.getDistance();
            visited.add(currentNode);

            if (distances.get(currentNode) < currentDistance) {
                continue;
            }

            for (E e : getEdgeNeighbour(currentNode)) {
                N secondNode = null;
                if(e.getNode1() == currentNode){
                    secondNode = e.getNode2();
                }
                else {secondNode = e.getNode1();}
                N neighborNode = secondNode;
                if (visited.contains(neighborNode)) {
                    continue;
                }
                int neighborWeight = e.getWeight();

                int alternativeDistance = currentDistance + neighborWeight;
                if (alternativeDistance < distances.get(neighborNode)) {
                    distances.put(neighborNode, alternativeDistance);
                    pq.add(new NodeForSearch(neighborNode, alternativeDistance));
                }
            }
        }

        return distances;
    }

    public List<N> dijkstra(N nodeFrom, N nodeTo) {
        List<N> result = new ArrayList<>();
        Map<N, Integer> allNodes = this.dijkstra(nodeFrom);
        N curentNode = nodeTo;
        result.add(nodeTo);

        while (curentNode != nodeFrom) {
            List<N> nodeNeighbor = this.getNodeNeighbour(curentNode);
            N node = null;
            int value = Integer.MAX_VALUE;
            for(N n: nodeNeighbor){
                if(allNodes.get(n) < value){
                    value = allNodes.get(n);
                    node = n;
                }
            }
            result.add(node);
            curentNode = node;
        }
        return result;
    }

    public Map<N, Integer> dijkstra2(N nodeFrom, N nodeTo) {
        Map<N, Integer> result = new HashMap<>();
        Map<N, Integer> allNodes = this.dijkstra(nodeFrom);
        N curentNode = nodeTo;
        result.put(nodeTo, Integer.MAX_VALUE);

        while (curentNode != nodeFrom) {
            List<N> nodeNeighbor = this.getNodeNeighbour(curentNode);
            N node = null;
            int value = Integer.MAX_VALUE;
            for(N n: nodeNeighbor){
                if(allNodes.get(n) < value){
                    value = allNodes.get(n);
                    node = n;
                }
            }
            result.put(node, value);
            curentNode = node;
        }
        return result;
    }

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

    class NodeForSearch implements Comparable<NodeForSearch>{
        private N node;
        private int distance;

        public NodeForSearch(N node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        public N getNode() {
            return node;
        }

        public int getDistance() {
            return distance;
        }

        @Override
        public int compareTo(NodeForSearch other) {
            return Integer.compare(this.distance, other.distance);
        }
    }
}
