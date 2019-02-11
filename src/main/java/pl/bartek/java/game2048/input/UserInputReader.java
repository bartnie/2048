package pl.bartek.java.game2048.input;

import pl.bartek.java.game2048.direction.Direction;

public interface UserInputReader {
    Direction readAndConvertUserInput();
}
