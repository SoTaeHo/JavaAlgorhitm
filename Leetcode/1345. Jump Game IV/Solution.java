import java.util.*;

class Solution {

    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        boolean visited[] = new boolean[n];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { 0, 0 });

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int idx = cur[0], step = cur[1];
            if (idx == n - 1) {
                return step;
            }
            if (map.containsKey(arr[idx])) {
                for (int val : map.get(arr[idx])) {
                    if (!visited[val]) {
                        if (val == n - 1)
                            return step + 1;

                        visited[val] = true;
                        q.add(new int[] { val, step + 1 });
                    }
                }
                map.remove(arr[idx]);
            }

            if (idx + 1 < n && !visited[idx + 1]) {
                if (idx + 1 == n - 1)
                    return step + 1;
                visited[idx + 1] = true;
                q.add(new int[] { idx + 1, step + 1 });
            }

            if (idx - 1 >= 0 && !visited[idx - 1]) {
                visited[idx - 1] = true;
                q.add(new int[] { idx - 1, step + 1 });
            }
        }
        return -1;
    }

}