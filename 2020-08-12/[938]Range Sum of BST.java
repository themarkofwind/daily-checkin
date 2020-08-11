//Given the root node of a binary search tree, return the sum of values of all n
//odes with value between L and R (inclusive). 
//
// The binary search tree is guaranteed to have unique values. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
//Output: 32
// 
//
// 
// Example 2: 
//
// 
//Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
//Output: 23
// 
//
// 
//
// Note: 
//
// 
// The number of nodes in the tree is at most 10000. 
// The final answer is guaranteed to be less than 2^31. 
// 
// 
// Related Topics Tree Recursion


//leetcode submit region begin(Prohibit modification and deletion)
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
class Solution {

    private int sum = 0;

    // L <= cur.val <= R
    // cur.val < L <= R
    // L <= R < cur.val
    public int rangeSumBST1(TreeNode root, int L, int R) {
        if (null == root || L > R) return 0;
        int val = root.val;
        if (val >= L && val <= R) {
            sum += val;
            rangeSumBST(root.left, L, val);
            rangeSumBST(root.right, val, R);
        } else if (val > R) {
            rangeSumBST(root.left, L, R);
        } else if (val < L) {
            rangeSumBST(root.right, L, R);
        }
        return sum;
    }

    // https://leetcode-cn.com/problems/range-sum-of-bst/solution/hua-jie-suan-fa-938-er-cha-sou-suo-shu-de-fan-wei-/
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (null == root || L > R) return 0;
        int val = root.val;
        if (val < L) {
            return rangeSumBST(root.right, L, R);
        }
        if (val > R) {
            return rangeSumBST(root.left, L, R);
        }
        return val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
