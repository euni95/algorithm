import java.util.Scanner;
 
// 정올 1113 : 119 구급대
public class JO_1113_구급대_DFS_가지치기 {
    static int M;  // 행 
    static int N;  // 열
    static int[][] map;
    static boolean[][] v;
    static int m, n;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
     
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        map = new int[M][N];
        v = new boolean[M][N];
         
        m = sc.nextInt() ;  //행 타켓
        n = sc.nextInt() ;  //열 타켓
         
        for(int i = 0 ; i < M; i++) {
            for(int j = 0 ; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        dfs(0,0,0,-1);
        System.out.println(result);
         
    }
    static void dfs(int x, int y, int cnt, int dir) {
        v[y][x] = true;
        if(y == m && x == n) {
            result = Math.min(result, cnt);
            return;
        }
        if(cnt >= result) {
        	return;
        }
        for(int i = 0 ; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >=N || ny < 0 || ny >= M) {
                continue;               
            }
             
            if(v[ny][nx]) {
                continue;
            }
            if(map[ny][nx] == 0) {
                continue;
            }
            if(dir == -1 || dir == i) {
                dfs(nx, ny, cnt, i);
            }else {
                dfs(nx, ny, cnt+1, i);
            }
            v[ny][nx] = false;
        }
         
    }       
}