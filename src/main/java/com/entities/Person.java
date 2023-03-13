package com.entities;

import com.graph.Node;
import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The {@code Person} class defines a person that works at a company. Each person is identifiable by a unique name.
 * <p>
 * Two {@code Person} objects are compared by their names.
 */
@EqualsAndHashCode
@ToString(exclude = "relationships")
public class Person implements Node, Comparable<Person> {
    @Getter
    @Setter
    private String name;

    @EqualsAndHashCode.Exclude
    private final Map<Node, String> relationships = new HashMap<>();

    public Person(String name) {
        this.name = name;
    }

    public void addRelationships(Node node, String value) {
        relationships.put(node, value);
        if (node instanceof Company) {
            ((Company) node).addPersonRelationship(this);
        } else if (node instanceof Person) {
            Person person = (Person) node;
            if (!person.containsRelationship(this)) {
                person.addRelationships(this, value);
            }
        }
    }

    private boolean containsRelationship(Node checkedNode) {
        return relationships.containsKey(checkedNode);
    }

    @Override
    public List<Node> getNeighbours() {
        return new ArrayList<>(relationships.keySet());
    }

    @Override
    public int compareTo(@NonNull Person o) {
        return name.compareTo(o.name);
    }
}
