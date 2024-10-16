/*
import java.util.*;

public class Dijkstra {

    public static Map<String, Integer> dijkstra(Map<String, Map<String, Integer>> graph, String start) {
        Map<String, Integer> distances = new HashMap<>();
        Set<String> visited = new HashSet<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (String node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            String currentNode = current.getNode();
            int currentDistance = current.getDistance();

            if (visited.contains(currentNode)) {
                continue;
            }

            visited.add(currentNode);

            for (Map.Entry<String, Integer> neighbor : graph.get(currentNode).entrySet()) {
                String neighborNode = neighbor.getKey();
                int neighborWeight = neighbor.getValue();

                int alternativeDistance = currentDistance + neighborWeight;
                if (alternativeDistance < distances.get(neighborNode)) {
                    distances.put(neighborNode, alternativeDistance);
                    pq.add(new Node(neighborNode, alternativeDistance));
                }
            }
        }

        return distances;
    }

    public static class Node implements Comparable<Node> {
        private String node;
        private int distance;

        public Node(String node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        public String getNode() {
            return node;
        }

        public int getDistance() {
            return distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public static void main(String[] args) {
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        graph.put("A", Map.of("B", 10, "C", 3));
        graph.put("B", Map.of("A", 10, "C", 1, "D", 2));
        graph.put("C", Map.of("A", 3, "B", 1, "D", 4));
        graph.put("D", Map.of("B", 2, "C", 4));

        String start = "A";
        String goal = "D";

        Map<String, Integer> distances = dijkstra(graph, start);

        System.out.println("Кратчайшие расстояния от " + start + ":");
        for (Map.Entry<String, Integer> entry : distances.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("Кратчайшее расстояние от " + start + " до " + goal + ": " + distances.get(goal));
    }
}*/
