package pl.bartek.java.game2048.move.mapper;

import pl.bartek.java.game2048.converter.FieldsConverter;
import pl.bartek.java.game2048.converter.impl.FieldsConverterImpl;
import pl.bartek.java.game2048.converter.reverse.FieldsReverseConverter;
import pl.bartek.java.game2048.converter.reverse.impl.FieldsReverseConverterImpl;
import pl.bartek.java.game2048.direction.Direction;
import pl.bartek.java.game2048.move.strategy.MoveStrategy;
import pl.bartek.java.game2048.move.strategy.impl.MoveDown;
import pl.bartek.java.game2048.move.strategy.impl.MoveLeft;
import pl.bartek.java.game2048.move.strategy.impl.MoveRight;
import pl.bartek.java.game2048.move.strategy.impl.MoveUp;

import java.util.HashMap;
import java.util.Map;

public class MovesMapper {
    private static Map<Direction, MoveStrategy> movesMap = new HashMap<>();

    static {
        final FieldsConverter converter = new FieldsConverterImpl();
        final FieldsReverseConverter reverseConverter = new FieldsReverseConverterImpl();
        movesMap.put(Direction.UP, new MoveUp(converter, reverseConverter));
        movesMap.put(Direction.DOWN, new MoveDown(converter, reverseConverter));
        movesMap.put(Direction.LEFT, new MoveLeft(converter, reverseConverter));
        movesMap.put(Direction.RIGHT, new MoveRight(converter, reverseConverter));
    }

    public static MoveStrategy getMoveStrategy(final Direction direction) {
        return movesMap.get(direction);
    }
}
