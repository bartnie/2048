package pl.bartek.java.game2048.random.impl;

import pl.bartek.java.game2048.converter.FieldsConverter;
import pl.bartek.java.game2048.converter.impl.FieldsConverterImpl;
import pl.bartek.java.game2048.field.Field;
import pl.bartek.java.game2048.random.RandomFieldCreator;
import pl.bartek.java.game2048.util.GameConstans;

import java.util.List;
import java.util.Random;

public class RandomFieldCreatorImpl implements RandomFieldCreator {
    private FieldsConverter converter = new FieldsConverterImpl();
    private Random randomGenerator = new Random();


    @Override
    public Field createRandomField(final List<Field> existingFields) {
        final int emptyFieldsNumber = (int) (Math.pow(GameConstans.BOARD_SIZE, 2) - existingFields.size());
        final int randomFieldIndex = randomGenerator.nextInt(emptyFieldsNumber);

        final List<List<Integer>> rows = converter.fieldsToRows(existingFields);

        int currentEmptyFieldIndex = 0;
        int rowIndex = 0;
        int columnIndex = 0;

        for (final List<Integer> row : rows) {
            for (final Integer element : row) {
                if (element == null && currentEmptyFieldIndex == randomFieldIndex) {
                    return new Field(getRandomValue(), rowIndex, columnIndex);
                } else if (element == null) {
                    currentEmptyFieldIndex += 1;
                }
                columnIndex += 1;
            }
            rowIndex += 1;
            columnIndex = 0;
        }

        return null;
    }

    private int getRandomValue() {
        return Math.random() < GameConstans.DOUBLE_FIELD_VALUE_PROBABILITY ? GameConstans.MIN_VALUE * 2 : GameConstans.MIN_VALUE;
    }
}
