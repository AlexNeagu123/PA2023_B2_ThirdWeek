package com.algorithms;

import com.graph.Network;
import com.graph.Node;

import java.util.*;

public class BiconnectedComponentsAlgorithm extends Algorithm {

    private final boolean[] isCutVertex;
    private final List<List<Integer>> biconnectedComponentsById = new ArrayList<>();
    private final Deque<Integer> verticesStack = new ArrayDeque<>();

    public BiconnectedComponentsAlgorithm(Network network) {
        super(network);
        this.isCutVertex = new boolean[nodeCount];
        CutVerticesAlgorithm cutVerticesAlgorithm = new CutVerticesAlgorithm(network);
        List<Node> cutVertices = cutVerticesAlgorithm.getCutVertices();
        for (Node cutVertex : cutVertices) {
            isCutVertex[network.getNodeId(cutVertex)] = true;
        }
    }

    void initializeStructures() {
        Arrays.fill(visited, false);
        biconnectedComponentsById.clear();
        verticesStack.clear();
    }

    void dfsTraversal(int currentNodeId, int previousNodeId) {
        verticesStack.addLast(currentNodeId);
        visited[currentNodeId] = true;
        for (Integer neighbourId : network.getNeighboursOfNodeId(currentNodeId)) {
            if (visited[neighbourId]) {
                continue;
            }
            dfsTraversal(neighbourId, currentNodeId);
            if (isCutVertex[currentNodeId] || previousNodeId == -1) {
                biconnectedComponentsById.add(new ArrayList<>());
                int componentIndex = biconnectedComponentsById.size() - 1;
                while (true) {
                    int topVertexId = verticesStack.getLast();
                    biconnectedComponentsById.get(componentIndex).add(topVertexId);
                    verticesStack.removeLast();
                    if (topVertexId == neighbourId) {
                        break;
                    }
                }
                biconnectedComponentsById.get(componentIndex).add(currentNodeId);
            }
        }
    }

    public List<List<Node>> getBiconnectedComponents() {
        initializeStructures();
        dfsTraversal(0, -1);
        List<List<Node>> biconnectedComponents = new ArrayList<>();
        for (List<Integer> component : biconnectedComponentsById) {
            biconnectedComponents.add(new ArrayList<>());
            int componentId = biconnectedComponents.size() - 1;
            for (Integer nodeId : component) {
                biconnectedComponents.get(componentId).add(network.getNodeWithId(nodeId));
            }
        }
        return biconnectedComponents;
    }
}
