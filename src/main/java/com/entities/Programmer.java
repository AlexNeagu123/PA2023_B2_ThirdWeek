package com.entities;

import lombok.Getter;
import lombok.ToString;

/**
 * The <tt>Programmer</tt> class defines a special type of {@link Person}, that possesses an additional data member representing
 * the years of experience.
 */
@Getter
@ToString(callSuper = true)
public class Programmer extends Person {
    int experience;

    /**
     * Constructs a <tt>Programmer</tt> that is uniquely defined by a name and has the experience initialized to 0 years.
     *
     * @param name The name of the newly created <tt>Programmer</tt>
     */
    public Programmer(String name) {
        super(name);
        this.experience = 0;
    }

    /**
     * Constructs a <tt>Programmer</tt> that is uniquely defined by a name and has the experience initialized to a specific
     * number of years.
     *
     * @param name       The name of the newly created <tt>Programmer</tt>
     * @param experience An integer that defines the years of experience of this <tt>Programmer</tt>
     */
    public Programmer(String name, int experience) {
        this(name);
        if (experience > 0)
            this.experience = experience;
    }
}
