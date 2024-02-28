package com.johnysoft.unique_letter;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


/*
*
* Algorithm based on map, where:
* key - character
* value - int (4 bytes)
*
*                   higher bytes                    lower bytes
*                   initial position in string      number of occurrences
* value --------->  [0x0000]                        [0x0000]
*
* If character appears first time, it's put to map under key -> code point of char, and
* value -> move initial position to higher bytes using - position will not change
* Each iteration increments lower bytes of given char by 1 - lower bytes are "counter"
*
* Operation "number & 0xFFFF" allows to get number of occurrences, exactly 1 occurrence is required
* Finally, position could be "extract" using "value >> 16", then get min value and get key (character) for this value
*
*
* */
public class FirstUniqueLetterFinder {

    public static void main(String[] args) {

        System.out.println(firstUniqueLetter("szkola"));
        System.out.println(firstUniqueLetter("szkolaszko"));
    }

    private static char firstUniqueLetter(String input) {

        Map<Integer, Integer> letterWithPositions = new HashMap<>();
        for (int i = 0;i<input.length();i++) {
            updateStatistics(i, input.codePointAt(i), letterWithPositions);
        }

        return (char) letterWithPositions.entrySet().stream()
                .filter(entry -> totalOccurrences(entry) == 1)
                .min(Comparator.comparingInt(o -> (o.getValue() >> 16)))
                .map(Map.Entry::getKey)
                .orElse(0).intValue();
    }

    private static void updateStatistics(Integer position, Integer character, Map<Integer, Integer> letterWithPositions) {
        if (!letterWithPositions.containsKey(character)) {
            letterWithPositions.put(character, initialValue(position));
        }
        letterWithPositions.computeIfPresent(character, (key, oldValue) -> ++oldValue);
    }

    private static Integer initialValue(Integer value) {
        return value << 16;
    }

    private static int totalOccurrences(Map.Entry<Integer, Integer> entry) {
        return entry.getValue() & 0xFFFF;
    }
}
