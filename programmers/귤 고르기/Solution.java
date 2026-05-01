import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {

        Map<Integer, Integer> map = new HashMap<>();
        
        for(int val : tangerine) {
            map.merge(val, 1, Integer::sum);
        }
        
        List<Integer> counts = new ArrayList<>(map.values());
        counts.sort(Collections.reverseOrder());

        int answer = 0;
        int total = 0;
        for (int count : counts) {
            total += count;
            answer++;
            if (total >= k) break;
        }

        return answer;
        
    }
}