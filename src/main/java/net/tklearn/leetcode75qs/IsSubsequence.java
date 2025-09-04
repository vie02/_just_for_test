package net.tklearn.leetcode75qs;

public class IsSubsequence {

    public static boolean isSubsequence(String s, String t) {
        int j = 0;
        for (int i = 0; i < t.length(); i++) {
            if (j == s.length()) {
                break;
            }
            if (t.charAt(i) == s.charAt(j)) {
                j++;
            }
        }
        return j == s.length();
    }
}
