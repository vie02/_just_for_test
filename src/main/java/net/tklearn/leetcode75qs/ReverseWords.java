package net.tklearn.leetcode75qs;

public class ReverseWords {

    // TODO: in-place for O(1) space complexity
    public static char[] reverseWords(char[] s) {
        return null;
    }

    private void reverse(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            while (l<r && s[l]==' ') {
                l++;
            }
            while (l<r && s[r]==' ') {
                r--;
            }
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for (var sub : reverse(s).strip().split("\\s+")) {
            if (!sb.isEmpty()) {
                sb.append(' ');
            }
            sb.append(reverse(sub));
        }

        return sb.toString();
    }

    private static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
