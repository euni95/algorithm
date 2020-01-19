import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2290_LCDTest {
	static char[][] arr;
	static int s, col, row;
	static boolean[][] number = {
			{true, true, true, false, true, true, true}, 		// 0
			{false, false, true, false, false, true, false},	// 1
			{true, false, true, true, true, false, true},		// 2
			{true, false, true, true, false, true, true},		// 3
			{false, true, true, true, false, true, false},		// 4
			{true, true, false, true, false, true, true},		// 5
			{true, true, false, true, true, true, true},		// 6
			{true, false, true, false, false, true, false},		// 7
			{true, true, true, true, true, true, true},			// 8
			{true, true, true, true, false, true, true}			// 9
	};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		char[] n = st.nextToken().toCharArray();
		col = ((s + 2) * n.length) + (n.length - 1);
		row = (2 * s) + 3;
		arr = new char[row][col];
		for(int i = 0; i < row; i++) {
			Arrays.fill(arr[i], ' ');
		}
		int ty = 0;
		for(int i = 0; i < n.length; i++) {
			int num = n[i] - '0';
			
			for(int j = 0; j < 7; j++) {
				if(!number[num][j]) continue; 
				char temp = ' ';
				if(j == 0 || j == 3 || j == 6) temp = '-';
				else temp = '|';
				
				switch(j) {
				case 0:
					for(int k = ty + 1; k <= ty + s; k++) arr[0][k] = temp;
					break;
				case 1:
					for(int k = 1; k <= s; k++) arr[k][ty] = temp;
					break;
				case 2:
					for(int k = 1; k <= s; k++) arr[k][s+1+ty] = temp;
					break;
				case 3:
					for(int k = ty + 1; k <= ty + s; k++) arr[s+1][k] = temp;
					break;
				case 4:
					for(int k = s + 2; k <= (2 * s) + 1; k++) arr[k][ty] = temp;
					break;
				case 5:
					for(int k = s + 2; k <= (2 * s) + 1; k++) arr[k][ty+s+1] = temp;
					break;
				case 6:
					for(int k = ty + 1; k <= ty + s; k++) arr[(2 * s) + 2][k] = temp;
					break;
				}
			}
			ty = ty + s + 3;
		}
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
}
