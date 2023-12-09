package net.tklearn.leetcode75qs;

import org.junit.jupiter.api.Test;

import static net.tklearn.leetcode75qs.IsSubsequence.isSubsequence;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsSubsequenceTest {

    @Test
    public void test() {
        assertTrue(isSubsequence("abc", "ahbykcz"));
        assertTrue(isSubsequence("abc", "aasdfasdfhbykasdfasdcz"));
        assertFalse(isSubsequence("abc", "ahcykczb"));
    }
}
