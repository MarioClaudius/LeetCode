package LeetCodeJava;

public class problem0112 {
    public static void main(String[] args) {
        System.out.println(hasPathSum(new TreeNode(-2, null, new TreeNode(-3)), -5));
        System.out.println(hasPathSum(null, 1));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        int currentTarget = targetSum - root.val;
        if (currentTarget == 0 && root.left == null && root.right == null) {
            return true;
        }

        boolean checkLeft = false;
        boolean checkRight = false;
        if (root.left != null) {
            checkLeft = hasPathSum(root.left, currentTarget);
        }
        if (root.right != null) {
            checkRight = hasPathSum(root.right, currentTarget);
        }

        return checkLeft || checkRight;
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

 