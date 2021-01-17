package org.jesperancinha.jtd.jee.the.netherlands.rest;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import java.io.Serializable;

import static javax.enterprise.event.Reception.IF_EXISTS;
import static javax.enterprise.event.TransactionPhase.IN_PROGRESS;
import static org.jesperancinha.console.consolerizer.ConGraphs.printRainbowFlag;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRainbowTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.setupFastDefault;

@RequestScoped
public class CleanerProcessor implements Serializable {
    public void cleanPalace(
        @Observes(notifyObserver = IF_EXISTS)
            ArrivalForCleanerEvent event) {
        setupFastDefault();
        printRainbowTitleLn("Event received! -> %s, %s, %s", IF_EXISTS, IN_PROGRESS, event);
        printRainbowTitleLn("We get this event only when there is an instance in a related context.");
        printRainbowTitleLn("Otherwise we never get this event.");
        printRainbowTitleLn("Remember that TransactionPhase.IN_PROGRESS is the default value for during.");
        printRainbowFlag("Cleaners have been notified! %s", event.getMessage());
        printYellowGenericLn("Note that this is successful ony from the Cleaner Processor");
        printYellowGenericLn("You probably noticed that IN_PROGRESS gets overwhelmed by the other during Observers");
    }
}