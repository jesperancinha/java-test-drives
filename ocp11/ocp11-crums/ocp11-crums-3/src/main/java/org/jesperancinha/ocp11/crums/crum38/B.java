package org.jesperancinha.ocp11.crums.crum38;

interface B extends A {

    @Override
    int getTheSheeps();

    static String sheepMakesASound() {
        return "Meeeeee!!!";
    }

}
