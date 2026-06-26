class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliveryIdx = n - 1;
        int pickupIdx = n - 1;

        while (deliveryIdx >= 0 || pickupIdx >= 0) {

            while (deliveryIdx >= 0 && deliveries[deliveryIdx] == 0)
                deliveryIdx--;

            while (pickupIdx >= 0 && pickups[pickupIdx] == 0)
                pickupIdx--;

            if (deliveryIdx < 0 && pickupIdx < 0)
                break;

            answer += (Math.max(deliveryIdx, pickupIdx) + 1L) * 2;

            int remain = cap;
            while (remain > 0 && deliveryIdx >= 0) {
                if (deliveries[deliveryIdx] <= remain) {
                    remain -= deliveries[deliveryIdx];
                    deliveries[deliveryIdx] = 0;
                    deliveryIdx--;
                } else {
                    deliveries[deliveryIdx] -= remain;
                    remain = 0;
                }
            }

            remain = cap;
            while (remain > 0 && pickupIdx >= 0) {
                if (pickups[pickupIdx] <= remain) {
                    remain -= pickups[pickupIdx];
                    pickups[pickupIdx] = 0;
                    pickupIdx--;
                } else {
                    pickups[pickupIdx] -= remain;
                    remain = 0;
                }
            }
        }

        return answer;
    }
}
