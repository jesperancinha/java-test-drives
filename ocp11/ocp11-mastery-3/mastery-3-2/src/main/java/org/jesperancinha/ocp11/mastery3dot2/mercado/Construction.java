package org.jesperancinha.ocp11.mastery3dot2.mercado;

import org.jesperancinha.console.consolerizer.Consolerizer;

public class Construction implements Space {
    String mainMaterial;

    public Construction(String mainMaterial) {
        this.mainMaterial = mainMaterial;
        Consolerizer.printOrangeGenericLn("Construction constructor has been called! %s", this.toString());
    }

    public Construction() {
        Consolerizer.printOrangeGenericLn("Construction (no-args) constructor has been called! %s", this.toString());
    }

    @Override
    public String toString() {
        return "Construction{" +
                "mainMaterial='" + mainMaterial + '\'' +
                '}';
    }
}
