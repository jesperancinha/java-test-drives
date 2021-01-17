package org.jesperancinha.java11.crums.crum30;

import java.util.Arrays;

import static org.jesperancinha.console.consolerizer.ConColor.BLUE;
import static org.jesperancinha.console.consolerizer.ConColor.GREEN;
import static org.jesperancinha.console.consolerizer.ConColor.MAGENTA;

public class Crum30 {

    @Deprecated
    @FunctionalInterface()
    private interface Table {

        void test(String... a);

    }

    public class BigTable implements Table {

        @Override
        @SafeVarargs
        public final void test(String... a) {

        }
    }

    public static void main(String[] args) {
        BLUE.printGenericTitleLn("Crum 30 - RUNTIME annotations");

        Arrays.stream(Table.class.getAnnotations())
            .forEach(annotation -> MAGENTA.printGenericLn(annotation));

        try {
            Arrays.stream(BigTable.class.getMethod("test", String[].class)
                .getAnnotations())
                .forEach(annotation -> MAGENTA.printGenericLn(annotation));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        GREEN.printGenericLn("Important to know is that SafeVarags, Deprecated and FunctionalInterface are all RUNTIME annotations");
        GREEN.printGenericLn("This means that we can find them during runtime.");
    }
}
