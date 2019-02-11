package pl.bartek.java.game2048.move.strategy;

import pl.bartek.java.game2048.board.Board;
import pl.bartek.java.game2048.converter.FieldsConverter;
import pl.bartek.java.game2048.converter.impl.FieldsConverterImpl;
import pl.bartek.java.game2048.converter.reverse.FieldsReverseConverter;
import pl.bartek.java.game2048.converter.reverse.impl.FieldsReverseConverterImpl;
import pl.bartek.java.game2048.field.Field;

import java.util.List;
import java.util.stream.IntStream;

public abstract class MoveStrategy {
    protected FieldsConverter converter;
    protected FieldsReverseConverter reverseConverter;

    public MoveStrategy(final FieldsConverter converter, final FieldsReverseConverter reverseConverter) {
        this.converter = converter;
        this.reverseConverter = reverseConverter;
    }

    public void moveBoard(final Board board) {
        final List<List<Integer>> convertedFields = convertFields(board.getFields());

        IntStream.range(0, convertedFields.size())
                .forEach(listIndex -> moveAndMergeFields(convertedFields.get(listIndex)));
        board.setFields(convertToFields(convertedFields));
    }

    private void moveAndMergeFields(final List<Integer> fieldsValues) {
        moveFieldsToEdge(fieldsValues);
        mergeFields(fieldsValues);
        moveFieldsToEdge(fieldsValues);
    }

    private void moveFieldsToEdge(final List<Integer> fieldsValues) {
        final int step = getStep();
        int currentIndex = fieldsValues.size() - getFirstIndex() - 1;

        while (currentIndex != getFirstIndex()) {
            if (onlyNullsRemaining(fieldsValues, currentIndex)) {
                break;
            }
            if (fieldsValues.get(currentIndex) == null) {
                fieldsValues.remove(currentIndex);
                fieldsValues.add(getFirstIndex(), null);
            }
            if (fieldsValues.get(currentIndex) != null) {
                currentIndex -= step;
            }
        }
    }

    private boolean onlyNullsRemaining(final List<Integer> fieldsValues, final int currentIndex) {
        final int startValue = Math.min(currentIndex, getFirstIndex());
        final int endValue = Math.max(currentIndex, getFirstIndex());
        return fieldsValues.subList(startValue, endValue + 1).stream().allMatch(value -> value == null);
    }

    private void mergeFields(final List<Integer> fieldsValues) {
        int currentIndex = fieldsValues.size() - getFirstIndex() - 1;
        final int step = getStep();

        while (currentIndex != getFirstIndex()) {
            if (fieldsValues.get(currentIndex) != null
                    && fieldsValues.get(currentIndex).equals(fieldsValues.get(currentIndex - step))) {
                Integer valueToReplace = fieldsValues.get(currentIndex) * 2;
                fieldsValues.remove(currentIndex);
                fieldsValues.add(currentIndex, valueToReplace);

                fieldsValues.remove(currentIndex - step);
                fieldsValues.add(currentIndex - step, null);

                currentIndex -= step;
            }

            if (currentIndex != getFirstIndex()) {
                currentIndex -= step;
            }
        }
    }

    protected abstract List<List<Integer>> convertFields(final List<Field> fields);

    protected abstract List<Field> convertToFields(final List<List<Integer>> convertedFields);

    protected abstract int getFirstIndex();

    protected abstract int getStep();

}
