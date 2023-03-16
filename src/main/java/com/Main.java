package com;

import com.graph.TarjanAlgorithm;
import com.entities.Company;
import com.entities.Designer;
import com.entities.Person;
import com.entities.Programmer;
import com.graph.Network;
import com.graph.Node;

import java.util.Collections;
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
        Person person1 = new Designer("Alex", 50);
        Person person2 = new Person("Andrei");
        Person person3 = new Programmer("Ioan", 50);
        Company comp1 = new Company("Amazon");
        Company comp2 = new Company("Google");

        person1.addRelationships(comp1, "employer");
        person1.addRelationships(person2, "good-friends");
        person1.addRelationships(person3, "roommates");
        person2.addRelationships(comp1, "worker");
        person2.addRelationships(comp2, "best-employer");
        person3.addRelationships(comp1, "worst-employer");

        Network network = new Network();
        network.addNode(person1);
        network.addNode(comp1);
        network.addNode(person2);
        network.addNode(comp2);
        network.addNode(person3);
        network.printNetwork();

        TarjanAlgorithm tarjanAlgorithm = new TarjanAlgorithm(network);

        List<Node> cutVertices = tarjanAlgorithm.getCutPoints();
        List<List<Node>> biconnectedComponents = tarjanAlgorithm.getBiconnectedComponents();

        printCutVertices(cutVertices);
        printBiconnectedComponents(biconnectedComponents);
    }

    public static void printCutVertices(List<Node> cutVertices) {
        String delimiter = String.join("", Collections.nCopies(100, "-"));
        System.out.println(delimiter);
        System.out.print("The cutpoints of the network are: ");
        for (Node cutVertex : cutVertices) {
            System.out.printf("\"%s\" ", cutVertex.getName());
        }
        System.out.println();
    }

    public static void printBiconnectedComponents(List<List<Node>> biconnectedComponents) {
        String delimiter = String.join("", Collections.nCopies(100, "-"));
        System.out.println(delimiter);
        System.out.println("The biconnected components in the network are: ");
        int rowId = 1;
        for (List<Node> component : biconnectedComponents) {
            System.out.print(rowId + ". ");
            for (Node node : component) {
                System.out.print(node.getName() + " ");
            }
            System.out.println();
            rowId++;
        }
    }
}