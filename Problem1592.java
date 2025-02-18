import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1592 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        int ball = 1;
        int result = 0;

        while(true) {
            arr[ball]++;
            if (arr[ball] < m) {
                if(arr[ball] % 2 == 1) {
                    ball += l;
                    if (ball > n) {
                        ball %= n;
                    }
                } else {
                    ball -= l;
                    if (ball == 0) {
                        ball = n;
                    } else if (ball < 0) {
                        ball = n - Math.abs(ball);
                    }
                }
                result++;
            } else {
                break;
            }
        }
        System.out.println(result);
    }
}
