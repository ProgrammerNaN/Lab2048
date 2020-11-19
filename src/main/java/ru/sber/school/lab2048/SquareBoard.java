package ru.sber.school.lab2048;

import java.util.List;

public class SquareBoard extends Board {

    public SquareBoard(int size) {
        super(size, size);
    }

    public void fillBoard(List<Integer> list) {

    }

    public List<Key> availableSpace() {
        return null;
    }

    public void addItem(Key key, Integer value) {

    }

    public Key getKey(int i, int j) {
        return null;
    }

    public Integer getValue(Key key) {
        return null;
    }

    public List<Key> getColumn(int j) {
        return null;
    }

    public List<Key> getRow(int i) {
        return null;
    }

    public boolean hasValue(Integer value) {
        return false;
    }

    public List<Integer> getValues(List<Key> keys) {
        return null;
    }
}
