package net.tklearn.arrayandhashing;

import java.util.*;

public class TopKFrequentElements {
        public static int[] topKFrequent(int[] nums, int top) {
            Map<Integer, Integer> eToC = new HashMap<>();
            for (int n : nums) {
                int count = eToC.get(n) == null ? 0 : eToC.get(n);
                eToC.put(n, count+1);
            }
            List<Integer>[] a = new ArrayList[nums.length + 1];
            for (int k : eToC.keySet()) {
                if (a[eToC.get(k)] == null) {
                    a[eToC.get(k)] = new ArrayList<>();
                }
                a[eToC.get(k)].add(k);
            }
            int[] res = new int[top];
            int ix = 0;
            for (int i = a.length - 1; i >= 0 && ix < top; i--) {
                if (a[i] != null) {
                    for (int n : a[i]) {
                        res[ix] = n;
                        ix++;
                    }
                }
            }
            return res;
        }
}
