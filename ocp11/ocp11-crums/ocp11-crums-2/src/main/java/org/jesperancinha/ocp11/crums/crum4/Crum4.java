package org.jesperancinha.ocp11.crums.crum4;

import java.util.Random;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;

public class Crum4 {

    private static class A {
        /**
         * @return a number between 0 and exclusive 1000;
         */
        public int returnRandom() {
            Random random = new Random();
            return random.nextInt(1000);
        }

    }

    private static class B extends A {

        @Override
        public int returnRandom() {
            return 100;
        }

        // 'returnRandom()' in 'org.jesperancinha.ocp11.crums.crum4.Crum4.B'
        // clashes with 'returnRandom()'
        // in 'org.jesperancinha.ocp11.crums.crum4.Crum4.A';
        // attempting to use incompatible return type
        // public  byte returnRandom() {
        //     return (byte) super.returnRandom();
        // }

        // 'returnRandom()' in 'org.jesperancinha.ocp11.crums.crum4.Crum4.B'
        // clashes with 'returnRandom()'
        // in 'org.jesperancinha.ocp11.crums.crum4.Crum4.A';
        // attempting to use incompatible return type
        // public long returnRandom() {
        //     return super.returnRandom();
        // }

        // 'returnRandom()' in 'org.jesperancinha.ocp11.crums.crum4.Crum4.B'
        // clashes with 'returnRandom()'
        // in 'org.jesperancinha.ocp11.crums.crum4.Crum4.A';
        // attempting to use incompatible return type
        // public float returnRandom() {
        //     return super.returnRandom();
        // }

        // 'returnRandom()' in 'org.jesperancinha.ocp11.crums.crum4.Crum4.B'
        // clashes with 'returnRandom()'
        // in 'org.jesperancinha.ocp11.crums.crum4.Crum4.A';
        // attempting to use incompatible return type
        // public double returnRandom() {
        //     return super.returnRandom();
        // }
    }

    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 4 - Overriding with primitive types");

        var a = new Crum4.A();

        printMagentaGenericLn("With instance a we can only generate a random number -> %d", a.returnRandom());

        var b = new Crum4.B();

        printMagentaGenericLn("With instance b we can only get 100 with the same method -> %d", b.returnRandom());
        printMagentaGenericLn(
            "Even if we cast it upwards, there is nothing with can do, because overriding removes that possibility -> %d",
            ((A) b).returnRandom());
        printGreenGenericLn("Overriding operations mean only one implementation will prevail");
        printGreenGenericLn("It is the implementation of the most specific class that prevails");
        printGreenGenericLn("In primitive types, the return type must match exactly");
        printGreenGenericLn(
            "If the method name and parameter types match, that also means that overloading is not possible.");
    }
}