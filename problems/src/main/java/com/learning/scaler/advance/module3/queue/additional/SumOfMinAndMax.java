package com.learning.scaler.advance.module3.queue.additional;


import java.util.ArrayDeque;
import java.util.Deque;

/*
Problem Description
    Given an array A of both positive and negative integers.
    Your task is to compute the sum of minimum and maximum elements of all sub-array of size B.
    NOTE: Since the answer can be very large, you are required to return the sum modulo 10^9 + 7.

Problem Constraints
    1 <= size of array A <= 10^5
    -10^9 <= A[i] <= 10^9
    1 <= B <= size of array

Input Format
    The first argument denotes the integer array A.
    The second argument denotes the value B

Output Format
    Return an integer that denotes the required value.

Example
    Input 1:
         A = [2, 5, -1, 7, -3, -1, -2]
         B = 4
    Input 2:
         A = [2, -1, 3]
         B = 2

Example
    Output 1:
         18
    Output 2:
         3

Example
    Explanation 1:
         Subarrays of size 4 are :
            [2, 5, -1, 7],   min + max = -1 + 7 = 6
            [5, -1, 7, -3],  min + max = -3 + 7 = 4
            [-1, 7, -3, -1], min + max = -3 + 7 = 4
            [7, -3, -1, -2], min + max = -3 + 7 = 4
            Sum of all min & max = 6 + 4 + 4 + 4 = 18
    Explanation 2:
         Subarrays of size 2 are :
            [2, -1],   min + max = -1 + 2 = 1
            [-1, 3],   min + max = -1 + 3 = 2
            Sum of all min & max = 1 + 2 = 3
* */
public class SumOfMinAndMax {

    public static void main(String[] args) {
        System.out.println(solve(new int[]{2, 5, -1, 7, -3, -1, -2}, 4));
        System.out.println(solve(new int[]{2, -1, 3}, 2));
    }

    public static int solve(int[] A, int B) {
        int mod = 1000 * 1000 * 1000 + 7;
        // maintain increasing order of values from front to rear
        Deque<Integer> minQueue = new ArrayDeque<Integer>();
        // maintain decreasing order of values from front to rear
        Deque<Integer> maxQueue = new ArrayDeque<Integer>();
        int i = 0;

        // Process first window of size B
        for (; i < B; i++) {
            // Remove all previous greater elements that are useless.
            while (!minQueue.isEmpty() && A[minQueue.getLast()] >= A[i])
                minQueue.removeLast();

            // Remove all previous smaller that are elements are useless.
            while (!maxQueue.isEmpty() && A[maxQueue.getLast()] <= A[i])
                maxQueue.removeLast();

            // Add current element at rear of both deque
            minQueue.addLast(i);
            maxQueue.addLast(i);
        }
        
        long sum = A[minQueue.getFirst()] + A[maxQueue.getFirst()];

        while (i < A.length) {
            // remove all previous greater element that are useless
            while (!minQueue.isEmpty() && A[minQueue.getLast()] >= A[i])
                minQueue.removeLast();

            // remove all previous smaller that are elements are useless
            while (!maxQueue.isEmpty() && A[maxQueue.getLast()] <= A[i])
                maxQueue.removeLast();

            // Add current element at rear of both deque
            minQueue.addLast(i);
            maxQueue.addLast(i);
            // Remove all elements which are out of this window
            while (i - minQueue.getFirst() >= B)
                minQueue.removeFirst();

            while (i - maxQueue.getFirst() >= B)
                maxQueue.removeFirst();

            // Element at the front of the deque are the largest and smallest  element of previous window respectively
            sum += A[maxQueue.getFirst()] + A[minQueue.getFirst()];
            sum %= mod;
            i++;
        }
        sum += mod;
        sum %= mod;
        return (int) sum;
    }
}
