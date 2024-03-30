package com.learning.scaler.advance.module2.sort.merge.additional;


import java.util.Arrays;

/*
Problem Description
    Given an array of integers A, find and return the minimum value of | A [ i ] - A [ j ] |
    where i != j and |x| denotes the absolute value of x.


Problem Constraints
    2 <= length of the array <= 100000
    -10^9 <= A[i] <= 10^9

Input Format
    The only argument given is the integer array A.

Output Format
    Return the minimum value of | A[i] - A[j] |.

Example Input
    Input 1:
         A = [1, 2, 3, 4, 5]
    Input 2:
         A = [5, 17, 100, 11]

Example Output
    Output 1:
         1
    Output 2:
         6

Example Explanation
    Explanation 1:
         The absolute difference between any two adjacent elements is 1, which is the minimum value.
    Explanation 2:
         The minimum value is 6 (|11 - 5| or |17 - 11|).
* */
public class MinimumAbsoluteDifference {
    public int solve(int[] A) {
        Arrays.sort(A);
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < A.length; i++) {
            result = Math.min(result, Math.abs(A[i] - A[i - 1]));
        }
        return result;
    }
}
