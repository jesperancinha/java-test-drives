package org.jesperancinha.jtd.jee.teeth.timer;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.ejb.Timeout;
import javax.ejb.Timer;

import static org.jesperancinha.console.consolerizer.Consolerizer.printRedGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;

@Stateful
public class StatefulTimerSessionBean {

    @Resource
    private SessionContext context;

    public void createTimer(long duration) {
        printRedGenericLn(
            "This is not possible. Check your browser. A Timer service cannot be generated from a @Stateful bean");
        final var timerService = context.getTimerService();
        timerService.createTimer(duration, "I've timed in " + duration + "seconds with a StatefulTimerSessionBean");
    }

    @Timeout
    public void timeOutHandler(Timer timer) {
        printYellowGenericLn(timer.getInfo());
        timer.cancel();
    }
}