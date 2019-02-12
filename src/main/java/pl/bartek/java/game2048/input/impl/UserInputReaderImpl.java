package pl.bartek.java.game2048.input.impl;

import pl.bartek.java.game2048.direction.Direction;
import pl.bartek.java.game2048.input.UserInputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UserInputReaderImpl implements UserInputReader {
    private final Set<Character> allowedChars = new HashSet<>(Arrays.asList('w', 's', 'a', 'd'));
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    public Direction readAndConvertUserInput() {
        return Direction.getDirection(getProperInput());
    }


    private char getProperInput() {
        try {
            System.out.println("Please provide direction using letters w,s,a,d: ");
            final String input = reader.readLine();
            if (input.length() > 0 &&
                    allowedChars.contains(input.charAt(0))) {
                return input.charAt(0);
            } else return getProperInput();

        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }
}

