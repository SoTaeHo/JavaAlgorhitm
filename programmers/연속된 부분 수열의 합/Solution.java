class Solution {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;

        int sum = 0;

        int minLen = 1_000_001;
        int l = 0, r = 0;
        int[] answer = new int[2];

        while (true) {
            if (sum >= k) {
                if (sum == k && r - l < minLen) {
                    minLen = r - l;
                    answer[0] = l;
                    answer[1] = r - 1;
                }
                sum -= sequence[l++];
            } else {
                if (r == n) {
                    break;
                }
                sum += sequence[r++];
            }

        }
        return answer;
    }
}