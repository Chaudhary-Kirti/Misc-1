/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 //tc- O(n) sc-(h)
 class Solution {
    int moves;
    public int distributeCoins(TreeNode root) {
        this.moves = 0;
        dfs(root);

        return moves;
        
    }

    private int dfs(TreeNode root){
        //base
        if(root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        int extras = root.val - 1;

        moves += Math.abs(left + right+ extras);

        return left + right + extras;
    }
}