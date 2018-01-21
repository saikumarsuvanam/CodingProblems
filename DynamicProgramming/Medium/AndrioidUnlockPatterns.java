package Medium;
//http://www.learn4master.com/interview-questions/leetcode/leetcode-android-unlock-patterns
/*Given an Android 3×3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9, count the total number of unlock patterns of the Android lock screen, which consist of minimum of m keys and maximum n keys.

Rules for a valid pattern:

    Each pattern must connect at least m keys and at most n keys.
    All the keys must be distinct.
    If the line connecting two consecutive keys in the pattern passes through any other keys, the other keys must have previously selected in the pattern. No jumps through non selected key is allowed.
    The order of keys used matters.

 * 
 */
public class AndrioidUnlockPatterns {

	int numberOfPatterns(int m, int n) {
        int res = 0;
        boolean[] visited = new boolean[10];
        int[][] jumps = new int[10][10];
        jumps[1][3] = jumps[3][1] = 2;
        jumps[4][6] = jumps[6][4] = 5;
        jumps[7][9] = jumps[9][7] = 8;
        jumps[1][7] = jumps[7][1] = 4;
        jumps[2][8] = jumps[8][2] = 5;
        jumps[3][9] = jumps[9][3] = 6;
        jumps[1][9] = jumps[9][1] = jumps[3][7] = jumps[7][3] = 5;
        res += helper(1, 1, 0, m, n, jumps, visited) * 4;
        res += helper(2, 1, 0, m, n, jumps, visited) * 4;
        res += helper(5, 1, 0, m, n, jumps, visited);
        return res;
    }
    int helper(int num, int len, int res, int m, int n, int[][] jumps, boolean[] visited) {
        if (len >= m) ++res;
        ++len;
        if (len > n) return res;
        visited[num] = true;
        for (int next = 1; next <= 9; ++next) {
            int jump = jumps[num][next];
            if (!visited[next] && (jump == 0 || visited[jump])) {
                res = helper(next, len, res, m, n, jumps, visited);
            }
        }
        visited[num] = false;
        return res;
    }
    
    public static void main(String[] args){
    	AndrioidUnlockPatterns a=new AndrioidUnlockPatterns();
    	System.out.println(a.numberOfPatterns(1,2)); 
    }
}
