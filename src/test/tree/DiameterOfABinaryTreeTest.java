package test.tree;

import org.testng.annotations.Test;

public class DiameterOfABinaryTreeTest {

    @Test
    public void TestDiameter() {
//        System.out.println(diameterOfBinaryTree());
    }

    int currentMax = 0;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {

       dfs(root);
       return currentMax;
    }

    public int dfs(TreeNode current){

        if (current == null){
            return 0;
        }

       int left = dfs(current.left);
       int right = dfs(current.right);

       currentMax = Math.max(currentMax, left + right);

       return Math.max(left,right)+ 1;
    }
}
