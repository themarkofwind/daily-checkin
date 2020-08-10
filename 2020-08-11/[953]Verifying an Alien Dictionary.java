//In an alien language, surprisingly they also use english lowercase letters, bu
//t possibly in a different order. The order of the alphabet is some permutation o
//f lowercase letters. 
//
// Given a sequence of words written in the alien language, and the order of the
// alphabet, return true if and only if the given words are sorted lexicographical
//y in this alien language. 
// 
// Example 1: 
//
// 
//Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
//Output: true
//Explanation: As 'h' comes before 'l' in this language, then the sequence is so
//rted.
// 
//
// Example 2: 
//
// 
//Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
//Output: false
//Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1]
//, hence the sequence is unsorted.
// 
//
// Example 3: 
//
// 
//Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
//Output: false
//Explanation: The first three characters "app" match, and the second string is 
//shorter (in size.) According to lexicographical rules "apple" > "app", because '
//l' > '∅', where '∅' is defined as the blank character which is less than any oth
//er character (More info).
// 
//
// 
// Constraints: 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 20 
// order.length == 26 
// All characters in words[i] and order are English lowercase letters. 
// 
// Related Topics Hash Table 
// 👍 911 👎 368


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if (null == words || null == order || order.length() != 26) return false;
        if (words.length <= 1) return true;
        int[] map = new int[26];
        int value = 0;
        for (char ch : order.toCharArray()) map[ch - 'a'] = value++;
        for (int i = 0; i < words.length - 1; i++) {
            String cur = words[i];
            String next = words[i+1];
            int len = Math.min(cur.length(), next.length());
            int j = 0;
            while (j < len) {
                if (map[cur.charAt(j) - 'a'] > map[next.charAt(j) - 'a']) return false;
                if (map[cur.charAt(j) - 'a'] < map[next.charAt(j) - 'a']) break;
                j++;
            }
            // cur & next has common prefix
            if (j == len) {
                if (cur.length() > next.length()) return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
