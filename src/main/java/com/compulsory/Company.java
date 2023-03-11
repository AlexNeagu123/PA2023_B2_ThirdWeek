package com.compulsory;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

/**
 * The {@code Company} class defines a company that may have multiple employers. Each company is identifiable by a unique name.
 * <p>
 * Two {@code Company} objects are compared by their names.
 */
@AllArgsConstructor
@Setter
public class Company implements Node, Comparable<Company> {
    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(@NonNull Company o) {
        return name.compareTo(o.name);
    }
}
