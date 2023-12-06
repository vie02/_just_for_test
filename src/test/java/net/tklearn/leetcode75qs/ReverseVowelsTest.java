package net.tklearn.leetcode75qs;

import org.junit.jupiter.api.Test;

import static net.tklearn.leetcode75qs.ReverseVowels.reverseVowels;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseVowelsTest {

    @Test
    public void test() {
        assertEquals(reverseVowels("heo"), "hoe");
        assertEquals(reverseVowels("hEo"), "hoE");
    }
}
