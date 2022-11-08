package com.greatlearning.problem_2;

import java.util.HashSet;

public class FindSumPair {

	static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		public TreeNode(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}
	
	private static TreeNode insertTreeNode(TreeNode root, int data) {
		if(root == null) {
			return new TreeNode(data);
		}
		if(root.data > data) {
			root.left = insertTreeNode(root.left, data);
		}else {
			root.right = insertTreeNode(root.right, data);
		}
		return root;
	}
	
	public static void main(String[] args) {
		
		TreeNode root = null;
		
		root = insertTreeNode(root,40);
		root = insertTreeNode(root,20);
		root = insertTreeNode(root,60);
		root = insertTreeNode(root,10);
		root = insertTreeNode(root,30);
		root = insertTreeNode(root,50);
		root = insertTreeNode(root,70);
		
		int sum = 130; 
		boolean result = findSumPair(root,sum);
		if(!result) {
			System.out.println("No such pair exists");
		}
	}
	private static boolean findSumPair(TreeNode root, int sum) {
		HashSet<Integer> data = new HashSet<Integer>();
		return isPairExists(root,data,sum);
	}

	private static boolean isPairExists(TreeNode root, HashSet<Integer> data, int sum) {
		if(root == null)
			return false;
		int comp = sum - root.data;
		if(data.contains(comp)) {
			System.out.println("The sum pair exists for the sum "+sum+" : "+ root.data+ " & "+ comp);
			return true;
		}else {
			data.add(root.data);
		}
		return isPairExists(root.left, data, sum) || isPairExists(root.right, data, sum);
	}
}