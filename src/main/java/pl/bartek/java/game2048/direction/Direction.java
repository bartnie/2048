package pl.bartek.java.game2048.direction;

public enum Direction {
    UP, DOWN, LEFT, RIGHT;

    public static Direction getDirection(final int userInput) {
        switch (userInput) {
            case 'w': return UP;
            case 's': return DOWN;
            case 'a': return LEFT;
            case 'd': return RIGHT;
            default: return null;
        }
    }
}
