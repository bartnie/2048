package pl.bartek.java.game2048.converter.impl;

import pl.bartek.java.game2048.converter.FieldsConverter;
import pl.bartek.java.game2048.util.GameConstans;
import pl.bartek.java.game2048.field.Field;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class FieldsConverterImpl implements FieldsConverter {

    @Override
    public List<List<Integer>> fieldsToRows(final List<Field> fields) {
        final List<List<Integer>> rows = new LinkedList<>();
        IntStream.range(0, GameConstans.BOARD_SIZE).forEachOrdered(rowIndex -> createRowFromFields(rows, rowIndex, fields));

        return rows;
    }

    @Override
    public List<List<Integer>> fieldsToColumns(final List<Field> fields) {
        final List<List<Integer>> columns = new LinkedList<>();
        IntStream.range(0, GameConstans.BOARD_SIZE).forEachOrdered(columnIndex -> createColumnFromFields(columns, columnIndex, fields));

        return columns;
    }

    @SuppressWarnings("Duplicates")
    private void createRowFromFields(final List<List<Integer>> rows, final int rowIndex, final List<Field> fields) {
        final List<Integer> row = new LinkedList<>();
        IntStream.range(0, GameConstans.BOARD_SIZE).forEachOrdered(columnIndex -> row.add(findFieldValue(rowIndex, columnIndex, fields)));

        rows.add(row);
    }

    @SuppressWarnings("Duplicates")
    private void createColumnFromFields(final List<List<Integer>> columns, final int columnIndex, final List<Field> fields) {
        final List<Integer> column = new LinkedList<>();
        IntStream.range(0, GameConstans.BOARD_SIZE).forEachOrdered(rowIndex -> column.add(findFieldValue(rowIndex, columnIndex, fields)));

        columns.add(column);
    }

    private Integer findFieldValue(final int rowIndex, final int columnIndex, final List<Field> fields) {
        final Optional<Field> optionalField = fields.stream().filter(field -> field.getRow() == rowIndex && field.getColumn() == columnIndex).findFirst();
        return optionalField.isPresent() ? optionalField.get().getValue() : null;
    }
}
