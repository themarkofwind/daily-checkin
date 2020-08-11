//
//An image is represented by a 2-D array of integers, each integer representing 
//the pixel value of the image (from 0 to 65535).
// 
//Given a coordinate (sr, sc) representing the starting pixel (row and column) o
//f the flood fill, and a pixel value newColor, "flood fill" the image.
// 
//To perform a "flood fill", consider the starting pixel, plus any pixels connec
//ted 4-directionally to the starting pixel of the same color as the starting pixe
//l, plus any pixels connected 4-directionally to those pixels (also with the same
// color as the starting pixel), and so on. Replace the color of all of the aforem
//entioned pixels with the newColor.
// 
//At the end, return the modified image.
// 
// Example 1: 
// 
//Input: 
//image = [[1,1,1],[1,1,0],[1,0,1]]
//sr = 1, sc = 1, newColor = 2
//Output: [[2,2,2],[2,2,0],[2,0,1]]
//Explanation: 
//From the center of the image (with position (sr, sc) = (1, 1)), all pixels con
//nected 
//by a path of the same color as the starting pixel are colored with the new col
//or.
//Note the bottom corner is not colored 2, because it is not 4-directionally con
//nected
//to the starting pixel.
// 
// 
//
// Note:
// The length of image and image[0] will be in the range [1, 50]. 
// The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < im
//age[0].length. 
// The value of each color in image[i][j] and newColor will be an integer in [0,
// 65535]. 
// Related Topics Depth-first Search 
// 👍 1293 👎 195


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // dfs
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (null == image || sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) {
            return image;
        }
        int oldColor = image[sr][sc];
        // if newColor == oldColor do nothing
        // otherwise will cause stack overflow
        if (newColor != oldColor) {
            dfs(image, sr, sc, newColor, oldColor);
        }
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor, int oldColor) {
        int row = image.length;
        int col = image[0].length;
        if (sr < 0 || sr >= row || sc < 0 || sc >= col || image[sr][sc] != oldColor) {
            return;
        }
        image[sr][sc] = newColor;
        dfs(image, sr - 1, sc, newColor, oldColor);
        dfs(image, sr + 1, sc, newColor, oldColor);
        dfs(image, sr, sc - 1, newColor, oldColor);
        dfs(image, sr, sc + 1, newColor, oldColor);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
