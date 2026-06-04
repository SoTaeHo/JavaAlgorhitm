import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;
        int[] answer = new int[n];

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(enroll[i], i);
        }

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            if (referral[i].equals("-")) {
                parent[i] = -1;
            } else {
                parent[i] = map.get(referral[i]);
            }
        }

        for (int i = 0; i < seller.length; i++) {
            int cur = map.get(seller[i]);
            int money = amount[i] * 100;

            while (cur != -1 && money > 0) {
                int passUp = money / 10;
                int mine = money - passUp;

                answer[cur] += mine;

                money = passUp;
                cur = parent[cur];
            }
        }

        return answer;
    }
}