//There are 2N people a company is planning to interview. The cost of flying the
// i-th person to city A is costs[i][0], and the cost of flying the i-th person to
// city B is costs[i][1]. 
//
// Return the minimum cost to fly every person to a city such that exactly N peo
//ple arrive in each city. 
//
// 
//
// Example 1: 
//
// 
//Input: [[10,20],[30,200],[400,50],[30,20]]
//Output: 110
//Explanation: 
//The first person goes to city A for a cost of 10.
//The second person goes to city A for a cost of 30.
//The third person goes to city B for a cost of 50.
//The fourth person goes to city B for a cost of 20.
//
//The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people inte
//rviewing in each city.
// 
//
// 
//
// Note: 
//
// 
// 1 <= costs.length <= 100 
// It is guaranteed that costs.length is even. 
// 1 <= costs[i][0], costs[i][1] <= 1000 
// Related Topics Greedy 
// 👍 1390 👎 173


import java.util.Arrays;
import java.util.Comparator;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // send all people to city B: cost is sum(costs[i][1])
    // send one from B to A: cost is (costs[i][0] - costs[i][1])
    // then sort by (costs[i][0] - costs[i][1]) and send the half lesses to A
    public int twoCitySchedCost(int[][] costs) {
        if (null == costs || costs.length <= 0 || (costs.length & 1) == 1  || costs[0].length < 2) return 0;
        // sort by (costA - costB)
        Arrays.sort(costs, Comparator.comparing(e -> (e[0] - e[1])));
        int cost = 0;
        int len = costs.length;
        int half = len >> 1;
        for (int i = 0; i < len; i++) {
            if (i < half) {
                cost += costs[i][0];
            } else {
                cost += costs[i][1];
            }
        }
        return cost;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
