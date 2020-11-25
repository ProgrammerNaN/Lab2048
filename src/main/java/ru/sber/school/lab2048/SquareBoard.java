package ru.sber.school.lab2048;

import java.util.ArrayList;
import java.util.List;

public class SquareBoard extends Board {

    public SquareBoard(int size) {
        super(size, size);
    }

    public void fillBoard(List<Integer> list) {
        if (list.size() == width * height) {
            for (int i = 0; i < this.height; i++) {
                for (int j = 0; j < this.width; j++) {
                    this.board.put(new Key(i, j), list.get(i * width + j));
                }
            }
        } else {
            throw new RuntimeException();
        }
    }

    public List<Key> availableSpace() {
        List<Key> keys = new ArrayList<>();

        for (Key key: this.board.keySet()) {
            if (board.get(key) == null) {
                keys.add(key);
            }
        }

        return keys;
    }

    public void addItem(Key key, Integer value) {
        this.board.put(key, value);
    }

    public Key getKey(int i, int j) {
        for (Key key : this.board.keySet()) {
            if (key.getI() == i && key.getJ() == j) {
                return key;
            }
        }

        return null;
    }

    public Integer getValue(Key key) {
        return board.get(key);
    }

    public List<Key> getColumn(int j) {
        List<Key> keys = new ArrayList<>();
        for (Key key : this.board.keySet()) {
            if (key.getJ() == j) {
                keys.add(key);
            }
        }
        return keys;
    }

    public List<Key> getRow(int i) {
        List<Key> keys = new ArrayList<>();
        for (Key key : this.board.keySet()) {
            if (key.getI() == i) {
                keys.add(key);
            }
        }
        return keys;
    }

    public boolean hasValue(Integer value) {
        return this.board.containsValue(value);
    }

    public List<Integer> getValues(List<Key> keys) {
        List<Integer> values = new ArrayList<>();
        for (Key key : keys) {
            values.add(this.board.get(key));
        }
        return values;
    }
}
