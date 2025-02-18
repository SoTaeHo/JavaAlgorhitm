import java.util.Scanner;

public class Problem11729 {

    static int cnt = 0;    
    static StringBuilder sb = new StringBuilder("");
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        hanoi(n, 1, 3, 2);

        System.out.println(cnt);
        System.out.println(sb.toString());
    }

    public static void hanoi(int n, int start, int end, int sub) {
        cnt++;
        if(n == 1) {
            // System.out.printf("%d %d\n", start, end);
            sb.append(start).append(" ").append(end).append("\n");
            return;
        }

        hanoi(n - 1, start, sub, end);
        sb.append(start).append(" ").append(end).append("\n");

        hanoi(n - 1, sub, end, start);

    }
}
//// 3
// 1 3
// 1 2
// 3 2
// 1 3
// 2 1
// 2 3
// 1 3

//// 4
/// 1 2
/// 1 3
/// 2 3
/// 1 2
/// 3 1
/// 3 2
/// 1 2
/// 
/// 1 3
/// 
/// 2 3
/// 2 1
/// 3 1
/// 
/// 2 3
/// 1 2
/// 1 3
/// 2 3

/// 3 1 3 2
/// 2 1 2 3
/// 1 1 3 2
/// print 1 3 return
/// print 1 2 
/// 1 3 2 1
/// print 3 2 return
/// return 2 1 2 3;
/// pritn 1 3
/// 2 2 3 1
/// 1 2 1 3
/// print 2 1 return
/// print 2 3
/// 1 1 3 2
/// print 1 3 return
/// return 2 1 2 3
/// return 3 1 3 2