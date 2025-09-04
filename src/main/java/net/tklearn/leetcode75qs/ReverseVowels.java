package net.tklearn.leetcode75qs;

import java.util.Set;
import java.util.Stack;

public class ReverseVowels {
    public static String reverseVowels(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        char[] a = s.toCharArray();
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (!vowels.contains(Character.toLowerCase(a[l]))) {
                l++;
                continue;
            }
            if (!vowels.contains(Character.toLowerCase(a[r]))) {
                r--;
                continue;
            }
            a[l] = s.charAt(r);
            a[r] = s.charAt(l);
            l++;
            r--;
        }

        return new String(a);
    }
}
