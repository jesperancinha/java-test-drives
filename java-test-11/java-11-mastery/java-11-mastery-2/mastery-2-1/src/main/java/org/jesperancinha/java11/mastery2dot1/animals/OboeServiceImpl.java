package org.jesperancinha.java11.mastery2dot1.animals;

import static org.jesperancinha.console.consolerizer.ConColor.RED;

public class OboeServiceImpl implements OboeService {

    @Override
    public void play() {
        RED.printGenericLn("Playing the oboe...");

    }
}
