package pl.bartek.java.game2048.field;

public class Field {
    private int value;
    private int row;
    private int column;

    public Field(final int value, final int row, final int column) {
        this.value = value;
        this.row = row;
        this.column = column;
    }

    public int getValue() {
        return value;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
