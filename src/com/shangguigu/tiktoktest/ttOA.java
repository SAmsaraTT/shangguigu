package com.shangguigu.tiktoktest;

import java.util.HashMap;
import java.util.Map;

public class ttOA {
    public static void main(String[] args) {
        int[] candy = {1, 2, 3, 2, 1};
        System.out.println(getSum(candy));
    }

    public static int getSum(int[] candy) {
        Map<Integer, Integer> preSum = new HashMap<>();
        int n = candy.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += candy[i];
            preSum.put(sum, i);
        }
        sum = 0;
        int ret = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += candy[i];
            if (preSum.containsKey(sum)) {
                if (preSum.get(sum) < i) {
                    ret = 2 * sum;
                    preSum.remove(sum);
                }
            }
        }

        return ret;
    }

}
