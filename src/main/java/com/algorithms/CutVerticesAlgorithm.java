package com.algorithms;

import com.graph.Network;
import com.graph.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CutVerticesAlgorithm extends Algorithm {
    private final int[] lowestLevel;
    private final int[] timeIn;
    protected boolean[] isCutVertex;
    private int timer = 0;

    public CutVerticesAlgorithm(Network network) {
        super(network);
        this.lowestLevel = new int[nodeCount];
        this.timeIn = new int[nodeCount];
        this.isCutVertex = new boolean[nodeCount];
    }

    private void initializeStructures() {
        Arrays.fill(lowestLevel, -1);
        Arrays.fill(timeIn, -1);
        Arrays.fill(visited, false);
        Arrays.fill(isCutVertex, false);
    }

    void dfsTraversal(int currentNodeId, int previousNodeId) {
        visited[currentNodeId] = true;
        timeIn[currentNodeId] = lowestLevel[currentNodeId] = timer++;
        int childrenCount = 0;
        for (Integer neighbourId : network.getNeighboursOfNodeId(currentNodeId)) {
            if (neighbourId == previousNodeId) {
                continue;
            }
            if (visited[neighbourId]) {
                lowestLevel[currentNodeId] = Math.min(lowestLevel[currentNodeId], timeIn[neighbourId]);
                continue;
            }
            dfsTraversal(neighbourId, currentNodeId);
            lowestLevel[currentNodeId] = Math.min(lowestLevel[currentNodeId], lowestLevel[neighbourId]);
            if (previousNodeId != -1 && lowestLevel[neighbourId] >= timeIn[currentNodeId]) {
                isCutVertex[currentNodeId] = true;
            }
            childrenCount++;
        }
        if (previousNodeId == -1 && childrenCount > 1) {
            isCutVertex[currentNodeId] = true;
        }
    }

    public List<Node> getCutVertices() {
        initializeStructures();
        dfsTraversal(0, -1);
        List<Node> cutVertices = new ArrayList<Node>();
        for (int i = 0; i < nodeCount; ++i) {
            if (isCutVertex[i])
                cutVertices.add(network.getNodeWithId(i));
        }
        return cutVertices;
    }
}