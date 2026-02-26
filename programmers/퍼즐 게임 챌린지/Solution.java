import java.util.*;

class Solution {
    
    static boolean calc(long level, long limit, int[] diffs, int[] times) {
        long score = times[0];
        for(int i = 1; i < diffs.length; i++) {
            if (diffs[i] > level) {
                score += (diffs[i] - level) * (times[i] + times[i - 1]) + times[i];
            } else {
                score += times[i];
            }
        }
        
        return score <= limit ? true : false;
    }
    public long solution(int[] diffs, int[] times, long limit) {

        long low = 1, high = limit, mid = 0;
        long answer = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            
            if(calc(mid, limit, diffs, times)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }
}

// abs(diffs[i] - level) * (times[i] + times[i - 1]) + times[i]
// 