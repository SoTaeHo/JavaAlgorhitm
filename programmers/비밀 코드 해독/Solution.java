class Solution {
    int answer = 0;

    public int solution(int n, int[][] q, int[] ans) {
        int[] comb = new int[5];
        dfs(1, 0, n, comb, q, ans);
        return answer;
    }

    void dfs(int start, int depth, int n, int[] comb, int[][] q, int[] ans) {
        if (depth == 5) {
            if (isValid(comb, q, ans)) {
                answer++;
            }
            return;
        }

        for (int i = start; i <= n; i++) {
            comb[depth] = i;
            dfs(i + 1, depth + 1, n, comb, q, ans);
        }
    }

    boolean isValid(int[] comb, int[][] q, int[] ans) {
        for (int i = 0; i < q.length; i++) {
            int cnt = 0;
            for (int x : comb) {
                for (int y : q[i]) {
                    if (x == y) cnt++;
                }
            }
            if (cnt != ans[i]) return false;
        }
        return true;
    }
}