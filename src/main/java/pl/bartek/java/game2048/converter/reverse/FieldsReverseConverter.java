package pl.bartek.java.game2048.converter.reverse;

import pl.bartek.java.game2048.field.Field;

import java.util.List;

public interface FieldsReverseConverter {

    List<Field> rowsToFields(final List<List<Integer>> rows);

    List<Field> columnsToFields(final List<List<Integer>> columns);
}
