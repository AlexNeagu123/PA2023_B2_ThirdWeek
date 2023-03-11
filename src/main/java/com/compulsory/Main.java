package com.compulsory;

import java.util.ArrayList;
import java.util.List;

/**
 * Compulsory implementation from Laboratory 3.
 * <p>
 * A {@link java.util.List} is created and four {@link Node} objects are inserted to it.
 * <p>
 * The {@code Node} interface is implemented by the {@link Company} and {@link Person} classes.
 * <p>
 * Each element from the list is printed on the screen using the getName() method.
 */
public class Main {
    public static void main(String[] args) {
        List<Node> nodeList = new ArrayList<>();
        nodeList.add(new Company("Amazon"));
        nodeList.add(new Person("John"));
        nodeList.add(new Company("Google"));
        nodeList.add(new Person("Alex"));
        for (Node node : nodeList) {
            System.out.println(node.getName());
        }
    }
}