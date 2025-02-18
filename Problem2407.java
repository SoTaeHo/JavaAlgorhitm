import java.math.BigInteger;
import java.util.Scanner;

public class Problem2407 {

    // static int 

  
    // n! / m!(n - m)!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        BigInteger result = fac(n).divide(fac(m));
        result = result.divide(fac(n - m));
        System.out.println(result);
    }

    public static BigInteger fac(int n) {
        BigInteger result = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }
}