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



    public void setNumActual(Integer numActual) {
        if(fixed)return;
        this.numActual = numActual;
    }

    public void clearSpace(){
        setNumActual(null);
    }

    private void checkNumberFixed(int numExpect){
        this.numActual=numExpect;
    }

    public Integer getNumActual() {
        return numActual;
    }

    public Integer getExpect() {
        return numExpect;
    }

    public Boolean isFixed() {
        return fixed;
    }
}
