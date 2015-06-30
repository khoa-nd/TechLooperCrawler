package com.techlooper.utils;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by NguyenDangKhoa on 6/26/15.
 */
public class LetterCombinationGenerator {

    private static final String[] alphabet = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
            "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    public static Set<String> generateLetterCombinations() {
        Set<String> letterCombinations = generateOneLetterCombinations();
        letterCombinations.addAll(generateTwoLetterCombinations());
        letterCombinations.addAll(generateThreeLetterCombinations());
        return letterCombinations;
    }

    public static Set<String> generateThreeLetterCombinations() {
        Set<String> letterCombinations = new HashSet<>();
        for (String letter1 : alphabet) {
            String tmp1 = letter1;
            for (String letter2 : alphabet) {
                String tmp2 = tmp1 + letter2;
                for (String letter3 : alphabet) {
                    String tmp3 = tmp2 + letter3;
                    letterCombinations.add(tmp3);
                }
            }
        }
        return letterCombinations;
    }

    public static Set<String> generateTwoLetterCombinations() {
        Set<String> letterCombinations = new HashSet<>();
        for (String letter1 : alphabet) {
            String tmp1 = letter1;
            for (String letter2 : alphabet) {
                String tmp2 = tmp1 + letter2;
                letterCombinations.add(tmp2);
            }
        }
        return letterCombinations;
    }

    public static Set<String> generateOneLetterCombinations() {
        Set<String> letterCombinations = new HashSet<>();
        for (String letter1 : alphabet) {
            letterCombinations.add(letter1);
        }
        return letterCombinations;
    }
}
