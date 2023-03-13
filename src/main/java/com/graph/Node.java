package com.graph;

import com.entities.Company;
import com.entities.Person;

import java.util.List;

/**
 * The {@code Node} interface defines getName() method used to obtain the name of a {@link Person} or a {@link Company}
 */
public interface Node {
    String getName();

    List<Node> getNeighbours();

}
