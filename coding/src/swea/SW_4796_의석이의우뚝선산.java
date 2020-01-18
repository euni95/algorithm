import java.util.Scanner;
 
public class SW_4796_의석이의우뚝선산 {
 
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[] mt = new int[N];
            int inc = 0;
            int cnt = 0;
            boolean flag = false;
            for(int n = 0; n < N; n++) {
                mt[n] = sc.nextInt();
                 
                if(n != 0) {
                    if(mt[n-1] < mt[n]) {
                        if(flag) {
                            flag = false;
                            inc = 0;
                        }
                        inc++;
                    }
                    else {
                        cnt += inc;
                        flag = true;
                    }
                }
            }
            System.out.println("#" + t + " " + cnt);
        }
        sc.close();
    }
 
}