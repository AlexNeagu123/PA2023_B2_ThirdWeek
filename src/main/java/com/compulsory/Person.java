package com.compulsory;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

/**
 * The {@code Person} class defines a person that works at a company. Each person is identifiable by a unique name.
 * <p>
 * Two {@code Person} objects are compared by their names.
 */
@AllArgsConstructor
@Setter
public class Person implements Node, Comparable<Person> {
    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(@NonNull Person o) {
        return name.compareTo(o.name);
    }
}
