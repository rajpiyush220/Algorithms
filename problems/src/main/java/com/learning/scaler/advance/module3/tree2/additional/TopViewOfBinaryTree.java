package com.learning.scaler.advance.module3.tree2.additional;

import com.learning.scaler.advance.module3.LevelOrderTreeConstruction;
import com.learning.scaler.advance.module3.TreeNode;
import com.learning.scaler.advance.module3.tree2.lecture.RightViewOfTree;

import java.util.*;

/*
Problem Description
    Given a binary tree of integers denoted by root A. Return an array of integers representing the top view of the Binary tree.
    The top view of a Binary Tree is a set of nodes visible when the tree is visited from the top.
    Return the nodes in any order.

Problem Constraints
    1 <= Number of nodes in binary tree <= 100000
    0 <= node values <= 10^9

Input Format
    First and only argument is head of the binary tree A.

Output Format
    Return an array, representing the top view of the binary tree.

Example Input
    Input 1:
                1
              /   \
             2    3
            / \  / \
           4   5 6  7
          /
         8
    Input 2:
                1
               /  \
              2    3
               \
                4
                 \
                  5


Example Output
    Output 1:
         [1, 2, 4, 8, 3, 7]
    Output 2:
         [1, 2, 3]

Example Explanation
    Explanation 1:
        Top view is described.
    Explanation 2:
        Top view is described.
* */
public class TopViewOfBinaryTree {

    public static void main(String[] args) {
        TreeNode treeNode = LevelOrderTreeConstruction.constructTree(List.of(

                7722 ,9970 ,4002 ,7668 ,7935 ,1936 ,8299 ,9867 ,4806 ,5189 ,3778 ,8567, 5263 ,189, 8603, 8477 ,6760, 9299 ,9796, 3139 ,1319 ,4025 ,6778 ,4701,9212 ,3082 ,2462 ,3251 ,1148 ,4323 ,7475 ,-1 ,-1 ,-1 ,-1 ,-1, -1, -1 ,-1 ,-1, -1 ,-1 ,-1 ,-1 ,-1 ,-1 ,-1 ,-1 ,-1 ,-1 ,-1, -1 ,-1 ,-1, -1 ,-1 ,-1 ,-1 ,-1, -1, -1, -1, -1
        ));
        System.out.println(new TopViewOfBinaryTree().solve(treeNode));
        /*treeNode = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        treeNode.left = node2;
        treeNode.right = node3;
        node2.right = node4;
        node4.right = node5;

        System.out.println(new TopViewOfBinaryTree().solve(treeNode));*/
    }


    public ArrayList<Integer> solve(TreeNode A) {
        if (A == null || A.val == -1) {
            return new ArrayList<>();
        }

        Queue<QueueNode> queue = new LinkedList<>();
        TreeMap<Integer, Integer> topViewMap = new TreeMap<>();
        queue.add(new QueueNode(A, 0));

        while (!queue.isEmpty()) {
            QueueNode currentNode = queue.poll();
            int currentHd = currentNode.hd;
            TreeNode currentNodeData = currentNode.node;

            if (!topViewMap.containsKey(currentHd)) {
                topViewMap.put(currentHd, currentNodeData.val);
            }

            // Enqueue the left and right children with updated horizontal distance
            if (currentNodeData.left != null) {
                queue.add(new QueueNode(currentNodeData.left, currentHd - 1));
            }
            if (currentNodeData.right != null) {
                queue.add(new QueueNode(currentNodeData.right, currentHd + 1));
            }
        }
        /*// Print the top view nodes
        for (Map.Entry<Integer, Integer> entry : topViewMap.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }*/
        return new ArrayList<>(topViewMap.values());
    }
}

class QueueNode {
    TreeNode node;
    int hd; // horizontal distance

    public QueueNode(TreeNode node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}
