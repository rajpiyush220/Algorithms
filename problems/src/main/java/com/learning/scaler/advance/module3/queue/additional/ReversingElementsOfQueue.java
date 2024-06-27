package com.learning.scaler.advance.module3.queue.additional;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
Problem Description
    Given an array of integers A and an integer B, we need to reverse the order of the first B elements of the array,
    leaving the other elements in the same relative order.
    NOTE: You are required to the first insert elements into an auxiliary queue then perform Reversal of first B elements.

Problem Constraints
    1 <= B <= length of the array <= 500000
    1 <= A[i] <= 100000

Input Format
    The argument given is the integer array A and an integer B.

Output Format
    Return an array of integer after reversing the first B elements of A using queue.

Example
    Input 1:
         A = [1, 2, 3, 4, 5]
         B = 3
    Input 2:
         A = [5, 17, 100, 11]
         B = 2

Example
    Output 1:
         [3, 2, 1, 4, 5]
    Output 2:
         [17, 5, 100, 11]

Example
    Explanation 1:
         Reverse first 3 elements so the array becomes [3, 2, 1, 4, 5]
    Explanation 2:
         Reverse first 2 elements so the array becomes [17, 5, 100, 11]
* */
public class ReversingElementsOfQueue {

    public static void main(String[] args) {

    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        Queue<Integer> queue = new LinkedList<>(A);
        ArrayList<Integer> result = new ArrayList<>();
        int count = 0;
        while (count < B) {
            result.add(0, queue.poll());
            count++;
        }
        while (!queue.isEmpty()) result.add(queue.poll());
        return result;
    }

    public int[] solve(int[] A, int B) {
        Deque<Integer> q = new ArrayDeque<>(A.length);
        int i;
        // Insert first B elements in queue
        for (i = 0; i < B; i++)
            q.addLast(A[i]);
        // Reverse the first B elements in the array A
        while (!q.isEmpty()) {
            i--;
            A[i] = q.getFirst();
            q.removeFirst();
        }
        return A;
    }
}
