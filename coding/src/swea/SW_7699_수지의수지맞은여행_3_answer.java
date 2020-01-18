package A_1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class SW_7699_수지의수지맞은여행_3_answer {
    static int[][] map;
    static int R,C,max;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
         
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            R = Integer.parseInt(st.nextToken());           
            C = Integer.parseInt(st.nextToken());           
            map = new int[R][C];
             
            for (int i = 0; i < R; i++) {
                String str = br.readLine();
                for (int j = 0; j < C; j++) {
                    map[i][j] = str.charAt(j)-'A';
                }
            }
             
            max = -1;
            dfs(1 << map[0][0],0,0,1);
             
            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }
        System.out.println(sb.toString());
    }
     
    public static void dfs(int visit, int r, int c,int cnt) {
        if(max == 26) return;
        max = Math.max(max,cnt);
         
        for (int i = 0; i < 4; i++) {
            int nx = r + dx[i];
            int ny = c + dy[i];
            if(nx < 0 || nx >= C || ny < 0 || ny >= R) {
				continue;
			} 
            if((visit & (1 << map[nx][ny])) == 0) {
            	dfs(visit | (1 << map[nx][ny]), nx, ny, cnt + 1);
            }
        }
    }

}
