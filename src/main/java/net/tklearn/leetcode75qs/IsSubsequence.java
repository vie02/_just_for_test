package net.tklearn.leetcode75qs;

public class IsSubsequence {

    public static boolean isSubsequence(String s, String t) {
        int i = 0;
        for (int j = 0; j < t.length(); j++) {
            if (i == s.length()) {
                break;
            }
            if (t.charAt(j) == s.charAt(i)) {
                i++;
            }
        }
        return i == s.length();
    }
}
