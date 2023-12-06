package net.tklearn.stack;

import org.junit.jupiter.api.Test;

import static net.tklearn.stack.ValidParentheses.isValid;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidParenthesesTest {

    @Test
    public void test() {
        assertTrue(isValid("()"));
        assertTrue(isValid("()[]{}"));
        assertFalse(isValid("(]"));
        assertTrue(isValid("([{}])[()]"));
    }
}
