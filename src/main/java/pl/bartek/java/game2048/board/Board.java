package pl.bartek.java.game2048.board;

import pl.bartek.java.game2048.direction.Direction;
import pl.bartek.java.game2048.field.Field;
import pl.bartek.java.game2048.move.mapper.MovesMapper;
import pl.bartek.java.game2048.random.RandomFieldCreator;
import pl.bartek.java.game2048.random.impl.RandomFieldCreatorImpl;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Field> fields = new ArrayList<>();
    private RandomFieldCreator randomFieldCreator = new RandomFieldCreatorImpl();

    public Board() {
        fields.add(randomFieldCreator.createRandomField(fields));
    }

    public void move(final Direction direction) {
        MovesMapper.getMoveStrategy(direction).moveBoard(this);
        fields.add(randomFieldCreator.createRandomField(fields));
    }


    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }
}
