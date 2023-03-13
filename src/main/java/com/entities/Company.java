package com.entities;

import com.graph.Node;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code Company} class defines a company that may have multiple employers. Each company is identifiable by a unique name.
 * <p>
 * Two {@code Company} objects are compared by their names.
 */
@EqualsAndHashCode
public class Company implements Node, Comparable<Company> {
    @Setter
    @Getter
    private String name;

    @EqualsAndHashCode.Exclude
    private final List<Node> personRelationships = new ArrayList<>();

    public Company(String name) {
        this.name = name;
    }

    void addPersonRelationship(Person person) {
        personRelationships.add(person);
    }

    @Override
    public List<Node> getNeighbours() {
        return new ArrayList<>(personRelationships);
    }

    @Override
    public int compareTo(@NonNull Company o) {
        return name.compareTo(o.name);
    }
}
