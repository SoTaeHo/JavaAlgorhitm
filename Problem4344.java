import java.util.Scanner;

public class Problem4344 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int c = sc.nextInt();

        for(int i = 0; i < c; i++) {

            int cnt = sc.nextInt();
            int arr[] = new int[cnt];
            int sum = 0;
            for(int j = 0; j < cnt; j++) {
                arr[j] = sc.nextInt();
                sum += arr[j];
            }
            int overAvg = 0;
            double avg = sum / cnt;
            for(int j = 0; j < cnt; j++) {
                if(arr[j] - avg > 0) {
                    overAvg++;
                }    
            }
            // System.out.print((double)overAvg / cnt * 100);
            // System.out.println("%");

            System.out.printf("%.3f%%\n",(double)overAvg / cnt * 100);
        }

        sc.close();
    }   
}