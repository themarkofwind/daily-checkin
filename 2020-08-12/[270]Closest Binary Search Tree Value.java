//Given a non-empty binary search tree and a target value, find the value in the
// BST that is closest to the target. 
//
// Note: 
//
// 
// Given target value is a floating point. 
// You are guaranteed to have only one unique value in the BST that is closest t
//o the target. 
// 
//
// Example: 
//
// 
//Input: root = [4,2,5,1,3], target = 3.714286
//
//    4
//   / \
//  2   5
// / \
//1   3
//
//Output: 4
// 
// Related Topics Binary Search Tree 
// 👍 777 👎 62


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

    private double min = Double.MAX_VALUE;
    private int closest = 0;

    public int closestValue(TreeNode root, double target) {
        if (null == root) return -1;
        int val = root.val;
        double distract = Math.abs(target - val);
        if (distract < min) {
            min = distract;
            closest = val;
        }
        if (target >= val) {
            closestValue(root.right, target);
        } else {
            closestValue(root.left, target);
        }
        return closest;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
