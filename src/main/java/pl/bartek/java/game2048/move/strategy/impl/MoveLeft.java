package pl.bartek.java.game2048.move.strategy.impl;

import pl.bartek.java.game2048.converter.FieldsConverter;
import pl.bartek.java.game2048.converter.reverse.FieldsReverseConverter;
import pl.bartek.java.game2048.field.Field;
import pl.bartek.java.game2048.move.strategy.MoveStrategy;
import pl.bartek.java.game2048.util.GameConstans;

import java.util.List;

public class MoveLeft extends MoveStrategy {
    public MoveLeft(final FieldsConverter converter, final FieldsReverseConverter reverseConverter) {
        super(converter, reverseConverter);
    }

    @Override
    protected List<List<Integer>> convertFields(final List<Field> fields) {
        return converter.fieldsToRows(fields);
    }

    @Override
    protected List<Field> convertToFields(final List<List<Integer>> convertedFields) {
        return reverseConverter.rowsToFields(convertedFields);
    }

    @Override
    protected int getFirstIndex() {
        return GameConstans.BOARD_SIZE - 1;
    }

    @Override
    protected int getStep() {
        return -1;
    }
}
