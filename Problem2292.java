import java.util.Scanner;

public class Problem2292 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int i = 0;
        int start = 2;
        int result = 1;
        if (n == 1) {
            System.out.println(1);
            return;
        }
        while(true) {
           if(start <= n && n < start + (6 * i)) {
            break;
           }
           start += (6 * i);
           result++;
           i++;
        }
        System.out.println(result);
    }
}


// 1
// 2 ~ 7 6개
// 8 ~ 19 12개
// 20 ~ 37 18개
