import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1244 {

    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[n + 1];
        arr[0] = -1;
        for(int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if(gender == 1) {
                for(int j = num; j < arr.length; j += num) {
                    arr[j] = arr[j] == 0 ? 1 : 0;
                }    
            } else {
                int temp = 1;
                arr[num] = arr[num] == 0 ? 1 : 0;
                
                while(num + temp >= 1 && num + temp < arr.length && num - temp >= 1 && num + temp < arr.length && (arr[num + temp] == arr[num - temp])) {
                    arr[num + temp] = arr[num + temp] == 0 ? 1 : 0;
                    arr[num - temp] = arr[num - temp] == 0 ? 1 : 0;
                    temp++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }
        // sb.append("\n");
        System.out.println(sb);
    }
}