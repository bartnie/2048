package pl.bartek.java.game2048.converter;

import pl.bartek.java.game2048.field.Field;

import java.util.List;

public interface FieldsConverter {

    List<List<Integer>> fieldsToRows(final List<Field> fields);

    List<List<Integer>> fieldsToColumns(final List<Field> fields);
}
