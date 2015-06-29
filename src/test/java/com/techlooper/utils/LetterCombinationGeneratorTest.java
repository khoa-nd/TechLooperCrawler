package com.techlooper.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Set;

public class LetterCombinationGeneratorTest {

    @Test
    public void testAlphabetCombinationGenerator() throws Exception {
        Set<String> combinations = LetterCombinationGenerator.generateLetterCombinations();
        Assert.assertTrue(combinations.size() == 18278);
    }
}