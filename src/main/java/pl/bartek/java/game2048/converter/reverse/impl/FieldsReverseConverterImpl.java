package pl.bartek.java.game2048.converter.reverse.impl;

import pl.bartek.java.game2048.converter.reverse.FieldsReverseConverter;
import pl.bartek.java.game2048.field.Field;

import java.util.ArrayList;
import java.util.List;

public class FieldsReverseConverterImpl implements FieldsReverseConverter {

    @Override
    @SuppressWarnings("Duplicates")
    public List<Field> rowsToFields(final List<List<Integer>> rows) {
        final List<Field> fields = new ArrayList<>();

        int rowIndex = 0;
        int columnIndex = 0;
        for (final List<Integer> row : rows) {
            for (final Integer value : row) {
                if (value != null) {
                    fields.add(new Field(value, rowIndex, columnIndex));
                }
                columnIndex++;
            }
            rowIndex++;
            columnIndex = 0;
        }
        return fields;
    }

    @Override
    @SuppressWarnings("Duplicates")
    public List<Field> columnsToFields(final List<List<Integer>> columns) {
        final List<Field> fields = new ArrayList<>();

        int columnIndex = 0;
        int rowIndex = 0;
        for (final List<Integer> column : columns) {
            for (final Integer value : column) {
                if (value != null) {
                    fields.add(new Field(value, rowIndex, columnIndex));
                }
                rowIndex++;
            }
            columnIndex++;
            rowIndex = 0;
        }
        return fields;
    }
}
