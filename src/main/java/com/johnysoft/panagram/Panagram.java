package com.johnysoft.panagram;

import java.util.stream.IntStream;

import static java.lang.Character.isAlphabetic;

public class Panagram {

    private static final int ZERO = 0;
    private static final int PANAGRAM = 0b11111111111111111111111111;
    private static final int ALPHABET_CHARS_COUNT = (int) IntStream.range('a', 'z'+1).count();
    private static final String PANAGRAM_SENTENCE = "he quick brown fox jumps over the lazy dog";
    public static final String NON_PANAGRAM_SENTENCE = "dupa jasia parasolka";


    public static void main(String[] args) {
        System.out.printf("""
                        Is "%s" panagram: %b
                        Are both functions return same result? %b
                        Is "%s" panagram? %b
                        Are both functions return same result? %b
                        %n""", PANAGRAM_SENTENCE, isPanagram(PANAGRAM_SENTENCE),
                        isPanagram(PANAGRAM_SENTENCE) == isPanagramV2(PANAGRAM_SENTENCE),
                        NON_PANAGRAM_SENTENCE, isPanagram(NON_PANAGRAM_SENTENCE),
                        isPanagram(NON_PANAGRAM_SENTENCE) == isPanagramV2(NON_PANAGRAM_SENTENCE)
        );
    }

    private static boolean isPanagram(String input) {
        int checker = PANAGRAM;
        int offset;
        for (int chr : input.toCharArray()) {
            if (isAlphabetic(chr)) {
                offset = chr % ALPHABET_CHARS_COUNT;
                checker &= ~(1 << offset); // Bitwise Not  =====> (-(1 << offset)) -1
            }
        }
        return checker == ZERO;
    }

    private static boolean isPanagramV2(String input) {
        int checker = ZERO;
        for (int chr: input.toCharArray()) {
            if (isAlphabetic(chr))
                checker |= (1 << chr % ALPHABET_CHARS_COUNT);
        }

        return checker == PANAGRAM;
    }
}
