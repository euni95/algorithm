package answer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//1824. 혁진이의 프로그램 검증
public class SW_1824_혁진이의프로그램검증_2_answer{
    static char[][] map;
    static int R, C;
    static int[][] visited;
    static boolean flag;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
 
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine(), " ");
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            flag = false;
            map = new char[R][C];
            visited = new int[R][C];
 
            for (int i = 0; i < R; i++) {
                map[i] = br.readLine().toCharArray();
            }
 
            for(int i=0; i<R; i++) {
                for(int j=0; j<C; j++) {
                    if (map[i][j] == '@') {
                        flag = true;
                        break;
                    }
                }
            }
             
            if (!flag) {
                System.out.println("#" + test_case + " NO");
                continue;
            }
             
            flag = false;
             
            move(0, 0, '>', 0);
 
            if (flag) {
                System.out.println("#" + test_case + " YES");
            } else {
                System.out.println("#" + test_case + " NO");
            }
 
        }
    }
 
    static void move(int x, int y, char d, int v) {
        if (visited[x][y] >= 16) {
            return;
        }
         
        visited[x][y]++;
 
        if (map[x][y] == '@') {
            flag = true;
            return;
        } else if (map[x][y] == '<') {
            d = '<';
        } else if (map[x][y] == '^') {
            d = '^';
        } else if (map[x][y] == 'v') {
            d = 'v';
        } else if (map[x][y] == '>') {
            d = '>';
        } else if (map[x][y] == '_') {
            if (v == 0) {
                d = '>';
            } else {
                d = '<';
            }
        } else if (map[x][y] == '|') {
            if (v == 0) {
                d = 'v';
            } else {
                d = '^';
            }
        }else if (map[x][y] == '+') {
            if (v == 15) {
                v = 0;
            } else {
                v++;
            }
        } else if (map[x][y] == '-') {
            if (v == 0) {
                v = 15;
            } else {
                v--;
            }
        } else if(map[x][y] == '.') {
             
        } else if (map[x][y] == '?') {
        	
            if (x == 0) {
                move(R - 1, y, '^', v);
            } else {
                move(x - 1, y, '^', v);
            }
             
            if (x == R - 1) {
                move(0, y, 'v', v);
            } else {
                move(x + 1, y, 'v', v);
            }
             
            if (y == 0) {
                move(x, C - 1, '<', v);
            } else {
                move(x, y - 1, '<', v);
            }
             
            if (y == C - 1) {
                move(x, 0, '>', v);
            } else {
                move(x, y + 1, '>', v);
            }
             
            return;
        } else {
            v = map[x][y] - '0';
        }
 
         
        // 상 하 좌 우 이동
        if (d == '^') {
            if (x == 0) {
                move(R - 1, y, d, v);
            } else {
                move(x - 1, y, d, v);
            }
        } else if (d == 'v') {
            if (x == R - 1) {
                move(0, y, d, v);
            } else {
                move(x + 1, y, d, v);
            }
        } else if (d == '<') {
            if (y == 0) {
                move(x, C - 1, d, v);
            } else {
                move(x, y - 1, d, v);
            }
        } else if (d == '>') {
            if (y == C - 1) {
                move(x, 0, d, v);
            } else {
                move(x, y + 1, d, v);
            }
        }
    }
}