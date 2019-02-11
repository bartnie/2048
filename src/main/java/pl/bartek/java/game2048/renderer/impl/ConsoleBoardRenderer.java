package pl.bartek.java.game2048.renderer.impl;

import pl.bartek.java.game2048.board.Board;
import pl.bartek.java.game2048.converter.FieldsConverter;
import pl.bartek.java.game2048.converter.impl.FieldsConverterImpl;
import pl.bartek.java.game2048.renderer.BoardRenderer;

import java.util.List;

public class ConsoleBoardRenderer implements BoardRenderer {
    private FieldsConverter converter;

    public ConsoleBoardRenderer() {
        converter = new FieldsConverterImpl();
    }

    public void renderBoard(final Board board) {
        clearConsole();
        final List<List<Integer>> rows = converter.fieldsToRows(board.getFields());
        System.out.println(System.lineSeparator() + "---------------------");

        for (final List<Integer> row : rows) {
            System.out.print("|");
            for (final Integer value : row) {
                if (value != null) {
                    System.out.printf("%4d|", value);
                } else {
                    System.out.print("    |");
                }
            }
            System.out.println(System.lineSeparator() + "---------------------");
        }
    }

    private void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
