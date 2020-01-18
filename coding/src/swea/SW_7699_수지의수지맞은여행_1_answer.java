package A_1;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
 
public class SW_7699_수지의수지맞은여행_1_answer {
    static int TC, R, C;
    static char[][] map;
    static boolean[][] visited;
    static int ans;
    //set _ 중복데이터 방지
    static Set<Character> set;
    static int[] di = {0,0,1,-1};
    static int[] dj = {1,-1,0,0};
     
    public static void main(String[] args) throws IOException {
    	System.setIn(new FileInputStream("input.txt"));
        Scanner sc = new Scanner(System.in);
        TC = sc.nextInt();
         
        for(int tc=1; tc<=TC; tc++) {
            R = sc.nextInt();
            C = sc.nextInt();
             
            map = new char[R][];
            visited = new boolean[R][C];
             
            for(int i=0; i<R; i++)
                map[i] = sc.next().toCharArray();
             
            ans=0;
            set = new HashSet<>();
            set.add(map[0][0]);
            dfs(0,0,0);
             
            System.out.println("#"+tc+" "+ans);
        }
    }
     
    static void dfs(int i, int j, int cnt) {
        set.add(map[i][j]);
//        visited[i][j] = true;
         
        for(int d=0; d<4; d++) {
            int next_i = i+di[d];
            int next_j = j+dj[d];
             
            if(next_i>=0 && next_i<R && next_j>=0 && next_j<C && !visited[next_i][next_j] && !set.contains(map[next_i][next_j])) {
                dfs(next_i,next_j, cnt+1);
            }
        }
         
        if(set.size()>ans)
            ans = set.size();
        set.remove(map[i][j]);
//        visited[i][j] = false;
        return;
    }
}