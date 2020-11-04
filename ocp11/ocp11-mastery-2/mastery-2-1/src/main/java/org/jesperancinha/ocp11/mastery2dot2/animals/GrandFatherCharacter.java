package org.jesperancinha.ocp11.mastery2dot2.animals;

public class GrandFatherCharacter extends Human {

    public GrandFatherCharacter(String name) throws NoBlahException {
        super("bassoon");
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
