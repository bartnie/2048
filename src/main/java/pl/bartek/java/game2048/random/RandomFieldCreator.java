package pl.bartek.java.game2048.random;

import pl.bartek.java.game2048.field.Field;

import java.util.List;

public interface RandomFieldCreator {

    Field createRandomField(final List<Field> existingFields);
}
