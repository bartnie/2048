package pl.bartek.java.game2048.renderer.impl;

import javafx.util.Builder;
import pl.bartek.java.game2048.board.Board;
import pl.bartek.java.game2048.converter.FieldsConverter;
import pl.bartek.java.game2048.converter.impl.FieldsConverterImpl;
import pl.bartek.java.game2048.renderer.BoardRenderer;
import pl.bartek.java.game2048.util.GameConstans;

import java.util.List;
import java.util.stream.IntStream;

public class ConsoleBoardRenderer implements BoardRenderer {
    private FieldsConverter converter;
    private String rowSeparator;
    {
        final StringBuilder rowSeparatorBuilder = new StringBuilder(System.lineSeparator() + "-");
        IntStream.range(0, 5 * GameConstans.BOARD_SIZE).forEach(i -> rowSeparatorBuilder.append("-"));
        rowSeparator = rowSeparatorBuilder.toString();
    }

    public ConsoleBoardRenderer() {
        converter = new FieldsConverterImpl();
    }

    public void renderBoard(final Board board) {
        clearConsole();

        final List<List<Integer>> rows = converter.fieldsToRows(board.getFields());
        System.out.println(rowSeparator);

        for (final List<Integer> row : rows) {
            System.out.print("|");
            for (final Integer value : row) {
                if (value != null) {
                    System.out.printf("%4d|", value);
                } else {
                    System.out.print("    |");
                }
            }
            System.out.println(rowSeparator);
        }
    }

    private void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
