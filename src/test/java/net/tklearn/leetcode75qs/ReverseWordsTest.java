package net.tklearn.leetcode75qs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static net.tklearn.leetcode75qs.ReverseWords.reverseWords;

public class ReverseWordsTest {

    @Test
    public void test() {
//        Assertions.assertArrayEquals(reverseWords("the sky is blue".toCharArray()), "blue is sky the".toCharArray());
        Assertions.assertEquals("blue is sky the", reverseWords("the sky is blue"));
    }
}
