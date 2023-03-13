package com.entities;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class Programmer extends Person {
    int experience;

    public Programmer(String name) {
        super(name);
        this.experience = 0;
    }

    public Programmer(String name, int experience) {
        this(name);
        if (experience > 0)
            this.experience = experience;
    }
}
