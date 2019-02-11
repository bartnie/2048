package pl.bartek.java.game2048.checker.impl;

import pl.bartek.java.game2048.board.Board;
import pl.bartek.java.game2048.checker.FinishChecker;
import pl.bartek.java.game2048.util.GameConstans;

public class FinishCheckerImpl implements FinishChecker {


    @Override
    public boolean checkForWin(final Board board) {
        return board.getFields().stream().anyMatch(field -> field.getValue() >= GameConstans.MAX_VALUE);
    }
}
