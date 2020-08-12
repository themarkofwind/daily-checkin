//A rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) are the 
//coordinates of its bottom-left corner, and (x2, y2) are the coordinates of its t
//op-right corner. 
//
// Two rectangles overlap if the area of their intersection is positive. To be c
//lear, two rectangles that only touch at the corner or edges do not overlap. 
//
// Given two (axis-aligned) rectangles, return whether they overlap. 
//
// Example 1: 
//
// 
//Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
//Output: false
// 
//
// Notes: 
//
// 
// Both rectangles rec1 and rec2 are lists of 4 integers. 
// All coordinates in rectangles will be between -10^9 and 10^9. 
// 
// Related Topics Math 
// 👍 730 👎 131


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 检查坐标在x,y轴上的投影是否有重合
    // 矩形1：(x1, x2)，矩形2：(x1', x2')
    // 不重叠
    // |-------|---|-------|
    // x1      x2  x1'     x2'
    // 重叠：min(x2, x2') > max(x1, x1')
    // 相交
    // |-------|---|-------|
    // x1     x1'  x2      x2'
    // 包含
    // |-------|----|-------|
    // x1     x1'   x2'     x2
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (null == rec1 || null == rec2 || rec1.length != rec2.length) {
            return false;
        }
        return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]))
                && (Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));
    }

    // check non-overlap
    public boolean isRectangleOverlap1(int[] rec1, int[] rec2) {
        if (null == rec1 || null == rec2 || rec1.length != rec2.length) {
            return false;
        }
        return !(
                // at left of rec1
                rec2[2] <= rec1[0] ||
                // at right of rec1
                rec2[0] >= rec1[2] ||
                // at top of rec1
                rec2[1] >= rec1[3] ||
                // at bottom of rec1
                rec2[3] <= rec1[1]);
     }
}
//leetcode submit region end(Prohibit modification and deletion)
