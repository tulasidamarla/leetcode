package com.learning.leetcode.easy;

import java.lang.*;
import java.util.Arrays;

public class TownJudge {

    public static void main(String args[]) {
        //Test case 1
        int n = 2;
        int[][] trust = {{1,2}};
        System.out.println("found judge " + findJudge(n, trust));

        //Test case 2
        n = 3;
        trust = new int[][]{{1, 3}, {2, 3}};
        System.out.println("found judge " + findJudge(n, trust));

        //Test case 2
        n = 3;
        trust = new int[][]{{1, 3}, {2, 3}, {3, 1}};
        System.out.println("found judge " + findJudge(n, trust));
    }

    public static int findJudge(int n, int[][] trust) {
        int[] netTrustGains = new int[n + 1];
        for (int[] i : trust) {
            netTrustGains[i[0]]--;
            netTrustGains[i[1]]++;
        }
        //Arrays.stream(netTrustGains).forEach(System.out::println);
        int judge = -1;
        for (int i = 1; i <= n; i++) {
            if (netTrustGains[i] == n - 1) {
                judge = i;
            }
        }
        return judge;
    }

}
