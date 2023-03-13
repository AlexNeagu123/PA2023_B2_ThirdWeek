package com.entities;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class Designer extends Person {
    int artisticTalent;

    public Designer(String name) {
        super(name);
        this.artisticTalent = 0;
    }

    public Designer(String name, int artisticTalent) {
        this(name);
        if (artisticTalent > 0) {
            this.artisticTalent = artisticTalent;
        }
    }
}
