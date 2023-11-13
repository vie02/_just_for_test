package net.tklearn;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class A {

    void m() {
        System.out.println("m A CLASS");
    }

}

class B extends A {

    public void m() {
        System.out.println("m B CLASS");
    }
}

interface I {
    default void f() {
        System.out.println("DEFAULT");
    }

}

class X implements I {
    public void f() {
        System.out.println("X");
    }
}


public class Algo {
    boolean alphanumericLess(String s1, String s2) {
        ArrayList<String> t1 = tokenize(s1);
        ArrayList<String> t2 = tokenize(s2);
        int loop = Math.min(t1.size(), t2.size());
        int index = -1;
        for (int i = 0; i < loop; i++) {
            if (compareToken(t1.get(i), t2.get(i)) < 0) return true;
            else if (compareToken(t1.get(i), t2.get(i)) > 0) return false;
            else if (!isLetter(t1.get(i)) && !t1.get(i).equals(t2.get(i))) index = i;
        }
        if (t1.size() != t2.size()) return t1.size() < t2.size();
        if (index == -1) return false;
        else return t1.get(index).length() > t2.get(index).length();
    }

    ArrayList<String> tokenize(String s) {
        Pattern p = Pattern.compile("([a-z])|(\\d+)");
        Matcher m = p.matcher(s);
        ArrayList<String> r = new ArrayList<>();
        while (m.find()) {
            r.add(m.group());
        }
        return r;
    }

    int compareToken(String a, String b) {
        if (isLetter(a)) {
            if (isLetter(b)) return a.compareTo(b);
            else return 1;
        } else {
            if (isLetter(b)) return -1;
            else return Integer.parseInt(a) - Integer.parseInt(b);
        }
    }

    boolean isLetter(String s) {
        return s.length() == 1 && Character.isLetter(s.toCharArray()[0]);
    }

    int[] extractMatrixColumn(int[][] matrix, int column) {
        return Arrays.stream(matrix).mapToInt(a -> a[column]).toArray();
    }

    boolean areIsomorphic(int[][] array1, int[][] array2) {
        int len1 = array1.length;
        int len2 = array2.length;
        return len1 == len2 && IntStream.range(0, len1).allMatch(l -> array1[l].length == array2[l].length);
    }

    int[][] reverseOnDiagonals(int[][] matrix) {
        int n = matrix.length - 1;
        int[][] r = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == j || i + j == n) {
                    r[i][j] = matrix[n - i][n - j];
                } else {
                    r[i][j] = matrix[i][j];
                }
            }
        }
        return r;
    }

    int[][] swapDiagonals(int[][] matrix) {
        for (int i = 0, n = matrix.length - 1; i <= n; i++) {
            int temp = matrix[i][i];
            matrix[i][i] = matrix[i][n - i];
            matrix[i][n - i] = temp;
        }
        return matrix;
    }

    int crossingSum(int[][] matrix, int a, int b) {
        return Arrays.stream(matrix[a]).sum() + Arrays.stream(matrix).mapToInt(r -> r[b]).sum() - matrix[a][b];
    }

    char[][] drawRectangle(char[][] v, int[] m) {
        for (int i = m[0] + 1; i < m[2]; i++) {
            v[m[1]][i] = '-';
            v[m[3]][i] = '-';
        }
        for (int i = m[1] + 1; i < m[3]; i++) {
            v[i][m[0]] = '|';
            v[i][m[2]] = '|';
        }
        v[m[1]][m[0]] = '*';
        v[m[1]][m[2]] = '*';
        v[m[3]][m[0]] = '*';
        v[m[3]][m[2]] = '*';

        return v;
    }

    boolean sudoku(int[][] grid) {
        return IntStream.range(0, 9)
                .allMatch(n ->
                        isValid(grid, k -> k, k -> n) &&
                                isValid(grid, k -> n, k -> k) &&
                                isValid(grid, k -> (n / 3) * 3 + k / 3, k -> (n % 3) * 3 + k % 3));
    }

    boolean isValid(int[][] grid, IntUnaryOperator rowSelector, IntUnaryOperator colSelector) {
        Set<Integer> s = new HashSet<>();
        for (int k = 0; k < 9; k++) {
            int r = rowSelector.applyAsInt(k);
            int c = colSelector.applyAsInt(k);
            if (s.contains(grid[r][c])) {
                return false;
            }
            s.add(grid[r][c]);
        }
        return true;
    }

    int val(Integer r, Integer c, boolean[][] m) {
        int[] s = new int[1];

        Predicate<Integer> boundR = i -> i >= 0 && i < m.length;
        Predicate<Integer> boundC = i -> i >= 0 && i < m[0].length;
        List<Integer> rows_ = Arrays.stream(getL(r)).boxed().filter(boundR).collect(Collectors.toList());
        List<Integer> cols_ = Arrays.stream(getL(c)).boxed().filter(boundC).collect(Collectors.toList());
        rows_.forEach(R -> cols_.forEach(C -> s[0] += m[R][C] ? 1 : 0));
        return s[0] - (m[r][c] ? 1 : 0);
    }

    int[] getL(int i) {
        return new int[]{i - 1, i, i + 1};
    }

    int[][] minesweeper(boolean[][] m) {
        int[][] mine = new int[m.length][m[0].length];
        for (int r = 0; r < m.length; r++) {
            for (int c = 0; c < m[0].length; c++) {
                mine[r][c] = val(r, c, m);
            }
        }
        return mine;
    }

    boolean solution1(char[][] grid) {
        if (grid.length != grid[0].length) {
            return false;
        }
        for (int i = 0; i < grid.length; i++) {
            if (isNotValid(grid[i])) {
                return false;
            }
            char[] t1 = new char[grid.length];
            for (int j = 0; j < grid.length; j++) {
                t1[j] = grid[j][i];
                if (i % 3 == 0 && j % 3 == 0) {
                    if (isNotValid(grid[i][j]
                            , grid[i][j + 1]
                            , grid[i][j + 2]
                            , grid[i + 1][j]
                            , grid[i + 1][j + 1]
                            , grid[i + 1][j + 2]
                            , grid[i + 2][j]
                            , grid[i + 2][j + 1]
                            , grid[i + 2][j + 2]
                    )) {
                        return false;
                    }
                }
            }
            if (isNotValid(t1)) {
                return false;
            }
        }
        return true;
    }

    boolean isNotValid(char... a) {
        if (a.length > 9) return true;
        Set<Character> characters = new HashSet<>();
        for (char c : a) {
            if (c >= '1' && c <= '9') {
                if (characters.contains(c)) return true;
                characters.add(c);
            } else if (c != '.') {
                return true;
            }
        }
        return false;
    }

    boolean solution2(String[] crypt, char[][] solution) {
        HashMap<Character, String> map = new HashMap<>();
        Arrays.stream(solution).forEach(p -> map.put(p[0], String.valueOf(p[1])));
        List<BigDecimal> decrypt = Arrays.stream(crypt).map(s -> convert(s, map))
                .filter(s -> !(s.startsWith("0") && s.length() > 1))
                .map(BigDecimal::new)
                .collect(Collectors.toList());
        return decrypt.size() == 3
                && decrypt.get(0).add(decrypt.get(1)).equals(decrypt.get(2));
    }

    String convert(String cr, Map<Character, String> map) {
        StringBuilder rs = new StringBuilder();
        cr.chars().mapToObj(c -> (char) c).forEach(c -> rs.append(map.get(c)));
        return rs.toString();
    }

    static class ListNode<T> {
        ListNode(T x) {
            value = x;
        }

        ListNode(T x, ListNode<T> n) {
            value = x;
            next = n;
        }

        T value;
        ListNode<T> next;
    }

    boolean solution3(ListNode<Integer> l) {
        Integer[] list = new Integer[500_000];
        int len = 0;
        ListNode<Integer> p = l;
        while (p != null) {
            list[len] = p.value;
            len++;
            p = p.next;
        }
        for (int i = 0; i < (len + 1) / 2; i++) {
            if (!Objects.equals(list[i], list[len - 1 - i])) return false;
        }
        return false;
    }

    ListNode<Integer> solution4(ListNode<Integer> a, ListNode<Integer> b) {
        return toList(toNumber(a).add(toNumber(b)));
    }

    BigDecimal toNumber(ListNode<Integer> l) {
        StringBuilder result = new StringBuilder();
        while (l != null) {
            result.append(String.format("%04d", l.value));
            l = l.next;
        }
        return new BigDecimal(result.toString());
    }

    ListNode<Integer> toList(BigDecimal num) {
        ListNode<Integer> rs = null;
        if (num.equals(BigDecimal.ZERO)) return new ListNode<>(0);
        String n = num.toString();
        for (int i = n.length(); i > 0; i -= 4) {
            String val = n.substring(i < 4 ? 0 : i - 4, i);
            ListNode<Integer> node = new ListNode<>(Integer.parseInt(val));
            node.next = rs;
            rs = node;
        }
        return rs;
    }

    ListNode<Integer> mergeTwoLinkedLists(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> rs = null;
        ListNode<Integer> tail = null;
        Integer val;
        while (l1 != null || l2 != null) {
            if (l1 != null && (l2 == null || l1.value <= l2.value)) {
                val = l1.value;
                l1 = l1.next;
            } else {
                val = l2.value;
                l2 = l2.next;
            }
            ListNode<Integer> node = new ListNode<>(val);
            if (rs == null) {
                rs = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }
        return rs;
    }
    public int findSmallestPositiveNotIn(int[] A) {
        // write your code in Java SE 8
        int res = 1;
        Arrays.sort(A);
        for (int j : A) {
            if (j > res) return res;
            if (j == res) res++;
        }
        return res;
    }

    public String cropSentence(String message, int K) {
        // write your code in Java SE 8
        int lastSpace = 0;
        for (int i = 0; i <= message.length() && i <= K; i++) {
            if (i == message.length() || message.charAt(i) == ' ') {
                lastSpace = i;
            }
        }
        return lastSpace > 0 ? message.substring(0, lastSpace) : "";
    }

    public int fillCars(int[] P, int[] S) {
        // write your code in Java SE 8
        Arrays.sort(S);
        long sum = Arrays.stream(P).asLongStream().sum();
        int res = 0;
        for (int i = S.length - 1; i >= 0 && sum > 0; i--) {
            sum -= S[i];
            res ++;
        }
        return res;
    }

    public int filterPollution(int[] A) {
        float quota = 0f;
        float[] B = new float[A.length];
        for (int i = 0; i<A.length; i++) {
            quota += A[i];
            B[i] = A[i];
        }
        quota /= 2;
        int res = 0;
        while (quota > 0) {
            int d = 0;
            for (int i = 0; i < B.length; i++) {
                if (B[i] > B[d]) {
                    d = i;
                }
            }
            B[d] /= 2;
            quota -= B[d];
            res ++;
        }
        return res;
    }


    public void rotate(int[] nums, int k) {
        int r;
        int w = nums[0];
        for (int i = 0; i % nums.length == 0 ; i = i + k) {
            r = nums[(i + k) % nums.length];
            nums[(i + k) % nums.length] = w;
            w = r;
        }
    }

    public static void main(String[] args) {
        Algo algo = new Algo();

        System.out.println(algo.filterPollution(new int[] {3,0,5}));

    }


}
