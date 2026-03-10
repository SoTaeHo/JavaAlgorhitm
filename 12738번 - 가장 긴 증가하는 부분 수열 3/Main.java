import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> dp = new ArrayList<>();

        for (int i : arr) {
            int idx = Collections.binarySearch(dp, i);
            // 양수 : 이미 값이 존재하는 위치
            // 음수 : 값이 없을 때 삽입해야 하는 위치
            if (idx < 0) {
                idx = -idx - 1;
            }

            if (idx == dp.size()) {
                dp.add(i);
            } else {
                dp.set(idx, i);
            }
        }

        System.out.println(dp.size());
    }
}