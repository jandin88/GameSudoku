package org.github.jandin88.entities;

public class Space {
    private Integer numActual;
    private final Integer numExpect;
    private final Boolean fixed ;

    public Space(Integer numExpect, Boolean fixed) {
        this.numExpect = numExpect;
        this.fixed = fixed;
        checkNumberFixed(numExpect);
    }


    private void checkNumberFixed(int numExpect){
        this.numActual=numExpect;
    }

    public Integer getNumActual() {
        return numActual;
    }

    public Integer getNumExpect() {
        return numExpect;
    }

    public Boolean getFixed() {
        return fixed;
    }
}
