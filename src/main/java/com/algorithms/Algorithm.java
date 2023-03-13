package com.algorithms;

import com.graph.Network;

public abstract class Algorithm {
    protected Network network;
    protected int nodeCount;

    protected final boolean[] visited;

    public Algorithm(Network network) {
        this.network = network;
        this.nodeCount = network.getNodeCount();
        this.visited = new boolean[nodeCount];
    }
}
