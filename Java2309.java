import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Java2309 {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[9];
        List<Integer> ans = new ArrayList<>();
        int sum = 0;
        for(int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        for(int i = 0; i < 8; i++) {
            for(int j = i + 1; j < 9; j++) {
                if (sum - arr[i] - arr[j] == 100) {
                    for(int k = 0; k < arr.length; k++) {
                        if (k != i && k != j) {
                            ans.add(arr[k]);
                        }
                    }
                    ans.sort(null);
                    for(int num : ans) {
                        sb.append(num).append("\n");
                    }
                    System.out.println(sb);
                    return;
                }
            }
        }
    }
}
