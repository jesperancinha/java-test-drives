package org.jesperancinha.java11.crums.crum27;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;

public class Crum27 {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 27 - Partition by is partitioned via a boolean value");

        final String[] bands = { "The Pogues", "Nick Cave and The Bad Seeds", "Henry Rollings Band", "Faith No More" };

        final Stream<String> bandStream = Arrays.stream(bands);

        final Map<Boolean, List<String>> partitionMap = bandStream.collect(
            Collectors.partitioningBy(s -> s.split(" ").length > 2));

        printMagentaGenericLn("We have found this map:");
        printOrangeGenericLn(partitionMap);
        printMagentaGenericLn("This means that a band with more than two letters is:");
        printOrangeGenericLn(partitionMap.get(true));
        printMagentaGenericLn("This means that a band with less than or with two letters is:");
        printOrangeGenericLn(partitionMap.get(false));

        printGreenGenericLn("The whole point of this exercise is to show that partitions are made with boolean values.");

    }
}