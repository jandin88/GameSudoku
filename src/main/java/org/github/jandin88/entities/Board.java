package org.github.jandin88.entities;


import org.github.jandin88.entities.euns.GameStatus;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;


import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.github.jandin88.entities.euns.GameStatus.*;

public class Board {

    List<List<Space>> spaces;

    public Board(List<List<Space>> spaces) {
        this.spaces = spaces;
    }


    public GameStatus getStatus(){
        if(spaces.stream().flatMap(Collection::stream).noneMatch(s-> s.isFixed()&& nonNull(s.getNumActual())))
            return GameStatus.NON_STARTED;

        return spaces.stream().flatMap(Collection::stream).anyMatch(s->isNull(s.getNumActual()))? INCOMPLETE:COMPLETE;
    }

    public boolean containsErros(){
        if (getStatus()==NON_STARTED) return false;

        return spaces.stream().flatMap(Collection::stream)
              .anyMatch(s-> nonNull(s.getNumActual())&& !s.getNumActual().equals(s.getExpect()));
    }


    public boolean changeValue(final int col, final int row, final int value) {
        return modifySpace(col, row, space -> space.setNumActual(value));
    }

    public boolean clearValue(final int col, final int row) {
        return modifySpace(col, row, Space::clearSpace);
    }

    public void reset(){
        spaces.forEach(c->c.forEach(Space::clearSpace));
    }

    public boolean finishiGame(){
        return !containsErros()&&getStatus().equals(COMPLETE);
    }

    private boolean modifySpace(int col, int row, Consumer<Space> action) {
        var space = spaces.get(col).get(row);
        if (space.isFixed()) {
            return false;
        }

        action.accept(space);
        return true;
    }


    public List<List<Space>> getSpaces() {
        return spaces;
    }
}
