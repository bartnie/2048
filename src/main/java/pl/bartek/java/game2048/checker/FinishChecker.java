package pl.bartek.java.game2048.checker;

import pl.bartek.java.game2048.board.Board;

public interface FinishChecker {
    boolean checkForWin(final Board board);

//    TODO
//    boolean checkForLoss(final Board board);
}
