package org.jesperancinha.ocp11.crums.crum7;

import org.jesperancinha.console.consolerizer.Consolerizer;

import java.util.ArrayList;
import java.util.List;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedGenericLn;

public class Crum7 {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 7 - List can be added by index");

        final List<String> list = new ArrayList<>();

        try {
            list.add(4, "peanuts");
        } catch (IndexOutOfBoundsException e){
            printRedGenericLn("This exception happens because the list isn't that big yet, so 0 is our only option in the beginning -> %s", e);
        }

        list.add(0, "peanuts");
        list.add(0,"almonds");
        Consolerizer.printMagentaGenericLn(list);
    }
}