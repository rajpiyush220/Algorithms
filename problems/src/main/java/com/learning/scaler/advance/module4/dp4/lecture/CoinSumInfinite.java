package com.learning.scaler.advance.module4.dp4.lecture;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
    You are given a set of coins A. In how many ways can you make sum B assuming you have infinite amount
    of each coin in the set.
    NOTE:
        Coins in set A will be unique. Expected space complexity of this problem is O(B).
        The answer can overflow. So, return the answer % (10^6 + 7).

Problem Constraints
    1 <= A <= 500
    1 <= A[i] <= 1000
    1 <= B <= 50000

Input Format
    First argument is an integer array A representing the set.
    Second argument is an integer B.

Output Format
    Return an integer denoting the number of ways.

Example Input
    Input 1:
     A = [1, 2, 3]
     B = 4
    Input 2:
     A = [10]
     B = 10

Example Output
    Output 1:
        4
    Output 2:
        1

Example Explanation
    Explanation 1:
     The 4 possible ways are:
     {1, 1, 1, 1}
     {1, 1, 2}
     {2, 2}
     {1, 3}
    Explanation 2:
     There is only 1 way to make sum 10.
* */
public class CoinSumInfinite {

    public static void main(String[] args) {
        CoinSumInfinite infinite = new CoinSumInfinite();
        System.out.println(infinite.coinchange2(new int[]{1, 2, 3}, 4));
    }

    int MOD = 1000007;

    public int coinchange2(int[] A, int B) {
        int[] dp = new int[B + 1];
        dp[0] = 1;
        for (int coin : A) {
            for (int i = coin; i <= B; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % MOD;
            }
        }
        return dp[B];
    }
}
