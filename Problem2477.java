import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


class Pair {
    int a;
    int b;

    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
public class Problem2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Pair[] arr = new Pair[12];
        for(int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            arr[i] = new Pair(dir, length);
            arr[i + 6] = new Pair(dir, length);
        }
        int big = 0;
        int small = 0;
        for(int i = 3; i < 10; i++) {
            if(arr[i].a == arr[i - 2].a && arr[i - 1].a == arr[i - 3].a) {
                big = arr[i + 1].b * arr[i + 2].b;
                small = arr[i - 2].b * arr[i - 1].b;
                System.out.println(big * small * k);
            }  
        }
    }
}


// ㄱ : 42 3131 14 4 2가 1개 42 - 31 
// ㄴ : 4242 31 16 1 3이 1개
//  ┛ : 4 2323 1 15 1 4가 1개
// ┏ : 4 23 141 15  2 3이 1개