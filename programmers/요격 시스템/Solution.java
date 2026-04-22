import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 1;

        Arrays.sort(targets, (a, b) -> a[1] - b[1]);

        int intercepts = targets[0][1];

        for (int i = 1; i < targets.length; i++) {
            int s = targets[i][0];
            int e = targets[i][1];

            if (s >= intercepts) {
                answer += 1;
                intercepts = e;
            }
        }
        return answer;
    }
}