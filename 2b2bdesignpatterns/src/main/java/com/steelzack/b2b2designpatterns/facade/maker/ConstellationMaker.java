package com.steelzack.b2b2designpatterns.facade.maker;

import com.steelzack.b2b2designpatterns.facade.entities.Cancer;
import com.steelzack.b2b2designpatterns.facade.entities.Constellation;
import com.steelzack.b2b2designpatterns.facade.entities.Pegasus;
import com.steelzack.b2b2designpatterns.facade.entities.Sagittarius;

/**
 * Created by joaofilipesabinoesperancinha on 11-04-16.
 */
public class ConstellationMaker {

    private Constellation cancer;
    private Constellation pegasus;
    private Constellation sagittarius;


    public ConstellationMaker() {
        this.cancer = new Cancer();
        this.pegasus = new Pegasus();
        this.sagittarius = new Sagittarius();
    }

    public void drawCancer(){
        this.cancer.drawCostellation();
    }

    public void drawPegasus(){
        this.pegasus.drawCostellation();
    }

    public void drawSagittarius(){
        this.sagittarius.drawCostellation();
    }

}
