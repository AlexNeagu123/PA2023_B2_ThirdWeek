package com.graph;

import java.util.*;

public class Network {
    private final List<Node> nodes = new ArrayList<>();
    private final Map<Node, Integer> nodeIds = new HashMap<>();
    private final List<List<Integer>> relationships = new ArrayList<>();
    private final Set<String> names = new HashSet<>();

    public List<Integer> getNeighboursOfNode(Node node) {
        int nodeId = nodeIds.get(node);
        return new ArrayList<>(relationships.get(nodeId));
    }

    public List<Integer> getNeighboursOfNodeId(int nodeId) {
        return new ArrayList<>(relationships.get(nodeId));
    }

    public int getNodeCount() {
        return nodes.size();
    }

    public void addNode(Node node) {
        if (nodeIds.containsKey(node) || names.contains(node.getName())) {
            return;
        }

        int nodeId = nodes.size();
        nodeIds.put(node, nodeId);
        relationships.add(new LinkedList<>());

        for (Node neighbour : node.getNeighbours()) {
            if (!nodeIds.containsKey(neighbour)) continue;
            int neighbourId = nodeIds.get(neighbour);
            relationships.get(nodeId).add(neighbourId);
            relationships.get(neighbourId).add(nodeId);
        }

        names.add(node.getName());
        nodes.add(node);
    }

    public int getNodeImportance(Node node) {
        int nodeId = nodeIds.get(node);
        return relationships.get(nodeId).size();
    }

    public int compareByImportance(Node a, Node b) {
        Integer aImportance = getNodeImportance(a);
        Integer bImportance = getNodeImportance(b);
        return bImportance.compareTo(aImportance);
    }

    public Node getNodeWithId(int nodeIndex) {
        return nodes.get(nodeIndex);
    }

    public int getNodeId(Node node) {
        return nodeIds.get(node);
    }

    public void printNetwork() {
        // Sorts the nodes decreasingly by importance
        List<Node> sortedNodes = new ArrayList<>(nodes);
        sortedNodes.sort(this::compareByImportance);

        String delimiter = String.join("", Collections.nCopies(100, "-"));
        System.out.println("The network contains the following nodes (sorted by importance):");

        for (Node node : sortedNodes) {
            // Prints the name and importance of the node
            System.out.println(delimiter);
            System.out.printf("Node identified by \"%s\"\n", node.getName());
            System.out.println("Has importance " + getNodeImportance(node));
            System.out.print("Has relationships with the following nodes: ");

            // Prints the neighbours of the node in the network graph
            int nodeId = nodeIds.get(node);
            for (Integer neighbourId : relationships.get(nodeId)) {
                System.out.printf("\"%s\" ", getNodeWithId(neighbourId).getName());
            }
            System.out.println();
        }
    }
}
