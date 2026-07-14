package LeetCodeJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class problem0098 {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(6);
        TreeNode c = new TreeNode(4, a, b);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(5, d, c);
        System.out.println(isValidBST(e));

        TreeNode a1 = new TreeNode(1);
        TreeNode b1 = new TreeNode(3);
        TreeNode c1 = new TreeNode(2, a1, b1);
        System.out.println(isValidBST(c1));

    }

    public static boolean isValidBST(TreeNode root) {
        return backtrack(root.left, Arrays.asList(root.val), new ArrayList<>()) && backtrack(root.right, new ArrayList<>(), Arrays.asList(root.val));
    }
    
    public static boolean backtrack(TreeNode subTree, List<Integer> lessThanNums, List<Integer> moreThanNums) {
        if (subTree == null) {
            return true;
        }
        for(int i = 0; i < lessThanNums.size(); i++) {
            if (subTree.val >= lessThanNums.get(i)) {
                return false;
            }
        }
        for(int j = 0; j < moreThanNums.size(); j++) {
            if (subTree.val <= moreThanNums.get(j)) {
                return false;
            }
        }
        List<Integer> newLessThanNums = new ArrayList<>(lessThanNums);
        newLessThanNums.add(subTree.val);
        List<Integer> newMoreThanNums = new ArrayList<>(moreThanNums);
        newMoreThanNums.add(subTree.val);
        return backtrack(subTree.left, newLessThanNums, moreThanNums) && backtrack(subTree.right, lessThanNums, newMoreThanNums);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
