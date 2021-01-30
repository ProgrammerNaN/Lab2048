package ru.sber.school.lab2048;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class GameHelper {

    public List<Integer> moveAndMergeEqual(List<Integer> list) {
        List<Integer> movedList = new ArrayList<>(list);

        int realSize = movedList.size();

        movedList.removeAll(Collections.singleton(null));

        int i = 0;

        while (i < movedList.size()) {
            if (i != movedList.size() - 1) {
                if (movedList.get(i).equals(movedList.get(i + 1))) {
                    movedList.set(i, movedList.get(i) * 2);
                    movedList.remove(i + 1);
                }
            }
            i++;
        }

        for (int j = movedList.size(); j < realSize; j++) {
            movedList.add(null);
        }

        return movedList;
    }

    public boolean canMerge(List<Integer> list) {
        List<Integer> values = new ArrayList<>(list);

        int i = 0;

        while (i < values.size()) {
            if (i != values.size() - 1) {
                if (values.get(i) != null) {
                    if (values.get(i).equals(values.get(i + 1))) {
                        return true;
                    }
                }
            }
            i++;
        }

        return false;
    }

}
