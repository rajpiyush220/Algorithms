package com.learning.mock_preparation.day1_arrays;


/*
Problem Description
    Given an array A of length N. Also given are integers B and C.
    Return 1 if there exists a subarray with length B having sum C and 0 otherwise

Problem Constraints
    1 <= N <= 10^5
    1 <= A[i] <= 10^4
    1 <= B <= N
    1 <= C <= 10^9

Input Format
    First argument A is an array of integers.
    The remaining arguments B and C are integers

Output Format
    Return 1 if such a subarray exist and 0 otherwise

Example
    Input 1:
        A = [4, 3, 2, 6, 1]
        B = 3
        C = 11
    Input 2:
        A = [4, 2, 2, 5, 1]
        B = 4
        C = 6

Example
    Output 1:
        1
    Output 2:
        0

Example
    Explanation 1:
        The subarray [3, 2, 6] is of length 3 and sum 11.
    Explanation 2:
        There are no such subarray.
*/
public class SubarrayWithGivenSumAndLength {

    public int solve(int[] A, int B, int C) {
        // check if any subarray with length B exists with sum C
        if (A == null || A.length == 0 || B > A.length) return 0;
        int currentArraySum = 0;
        for (int i = 0; i < B; i++) {
            currentArraySum += A[i];
        }
        if (currentArraySum == C) return 1;
        for (int i = 1; i < (A.length - B); i++) {
            currentArraySum -= A[i - 1];
            currentArraySum += A[i + B - 1];
            if (currentArraySum == C) return 1;
        }
        return 0;
    }
}
