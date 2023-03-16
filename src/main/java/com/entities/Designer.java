package com.entities;

import lombok.Getter;
import lombok.ToString;

/**
 * The <tt>Designer</tt> class defines a special type of {@link Person}, that possesses an additional data member representing
 * the artistic talent.
 */
@Getter
@ToString(callSuper = true)
public class Designer extends Person {
    int artisticTalent;

    /**
     * Constructs a <tt>Designer</tt> that is uniquely defined by a name and has the artistic talent initialized to 0.
     *
     * @param name The name of the newly created <tt>Designer</tt>
     */

    public Designer(String name) {
        super(name);
        this.artisticTalent = 0;
    }

    /**
     * Constructs a <tt>Designer</tt> that is uniquely defined by a name and has the artistic talent initialized to a specific
     * integer value.
     *
     * @param name           The name of the newly created <tt>Designer</tt>
     * @param artisticTalent An integer that describes the artistic talent of this <tt>Designer</tt>
     */
    public Designer(String name, int artisticTalent) {
        this(name);
        if (artisticTalent > 0) {
            this.artisticTalent = artisticTalent;
        }
    }
}
