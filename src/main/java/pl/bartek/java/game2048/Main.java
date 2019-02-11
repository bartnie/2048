package pl.bartek.java.game2048;

import pl.bartek.java.game2048.board.Board;
import pl.bartek.java.game2048.checker.FinishChecker;
import pl.bartek.java.game2048.checker.impl.FinishCheckerImpl;
import pl.bartek.java.game2048.input.UserInputReader;
import pl.bartek.java.game2048.input.impl.UserInputReaderImpl;
import pl.bartek.java.game2048.renderer.BoardRenderer;
import pl.bartek.java.game2048.renderer.impl.ConsoleBoardRenderer;

public class Main {

    public static void main(String[] args) {
        final BoardRenderer renderer = new ConsoleBoardRenderer();
        final UserInputReader inputReader = new UserInputReaderImpl();
        final FinishChecker checker = new FinishCheckerImpl();
        final Board board = new Board();

        while (!checker.checkForWin(board)) {
            renderer.renderBoard(board);
            board.move(inputReader.readAndConvertUserInput());
        }
    }
}