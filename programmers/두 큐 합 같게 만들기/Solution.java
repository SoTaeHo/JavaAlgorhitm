import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0;
        long total = 0;

        int n = queue1.length;

        List<Integer> list = new ArrayList<>(3 * n);

        for (int e : queue1) {
            list.add(e);
            sum1 += e;
            total += e;
        }

        for (int e : queue2) {
            list.add(e);
            total += e;
        }

        if (total % 2 != 0) {
            return -1;
        }

        for (int e : queue1) {
            list.add(e);
        }

        long target = total / 2;

        int left = 0;
        int right = n - 1;
        int cnt = 0;

        while (cnt < 3 * n) {
            if (sum1 == target) {
                return cnt;
            } else if (sum1 > target) {
                sum1 -= list.get(left);
                left += 1;
            } else {
                right += 1;
                sum1 += list.get(right);
            }

            cnt += 1;
        }

        return -1;
    }
}