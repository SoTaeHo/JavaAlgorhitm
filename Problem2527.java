import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2527 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        
        for(int t = 0; t < 4; t++) {
            
            int[] f = new int[4];
            int[] s = new int[4];
            
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 0; i < 4; i++) {
                f[i] = Integer.parseInt(st.nextToken());
            }
            for(int i = 0; i < 4; i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }

            int xl, xr, yb, yt;

            xl = Math.max(f[0], s[0]);
            xr = Math.min(f[2], s[2]);
            yb = Math.max(f[1], s[1]);
            yt = Math.min(f[3], s[3]);

            int xdiff = xr - xl;
            int ydiff = yt - yb;

            if(xdiff > 0 && ydiff > 0)
                System.out.println('a');
            else if (xdiff < 0 || ydiff < 0)
                System.out.println('d');
            else if (xdiff == 0 && ydiff == 0)
                System.out.println('c');
            else
                System.out.println('b');
        }
    }
}