import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14500_테트로미노 {

	static int[][] map;
	static int max = 0;
	
	static void func(int a, int b) {
		int sum = 0;
		
		//─
		sum += map[a][b];
		sum += map[a][b+1];
		sum += map[a][b+2];
		sum += map[a][b+3];
		if(max < sum) max = sum;
		
		//│
		sum = 0;
		sum += map[a][b];
		sum += map[a+1][b];
		sum += map[a+2][b];
		sum += map[a+3][b];
		if(max < sum) max = sum;
		
		//ㅁ
		sum = 0;
		sum += map[a][b];
		sum += map[a][b+1];
		sum += map[a+1][b];
		sum += map[a+1][b+1];
		if(max < sum) max = sum;
		
		//└
		sum = 0;
		sum += map[a][b];
		sum += map[a+1][b];
		sum += map[a+2][b];
		sum += map[a+2][b+1];
		if(max < sum) max = sum;
		
		//┘
		sum = 0;
		sum += map[a][b+1];
		sum += map[a+1][b+1];
		sum += map[a+2][b];
		sum += map[a+2][b+1];
		if(max < sum) max = sum;
		
		//┌
		sum = 0;
		sum += map[a][b];
		sum += map[a][b+1];
		sum += map[a+1][b];
		sum += map[a+2][b];
		if(max < sum) max = sum;
		
		//┐
		sum = 0;
		sum += map[a][b];
		sum += map[a][b+1];
		sum += map[a+1][b+1];
		sum += map[a+2][b+1];
		if(max < sum) max = sum;
		
		//ㄱ
		sum = 0;
		sum += map[a][b];
		sum += map[a][b+1];
		sum += map[a][b+2];
		sum += map[a+1][b+2];
		if(max < sum) max = sum;
		
		//ㄱ 반대
		sum = 0;
		sum += map[a][b];
		sum += map[a][b+1];
		sum += map[a][b+2];
		sum += map[a+1][b];
		if(max < sum) max = sum;
		
		//ㄴ
		sum = 0;
		sum += map[a][b];
		sum += map[a+1][b];
		sum += map[a+1][b+1];
		sum += map[a+1][b+2];
		if(max < sum) max = sum;
		
		//ㄴ 반대
		sum = 0;
		sum += map[a][b+2];
		sum += map[a+1][b];
		sum += map[a+1][b+1];
		sum += map[a+1][b+2];
		if(max < sum) max = sum;
		
		//└┐
		sum = 0;
		sum += map[a][b];
		sum += map[a+1][b];
		sum += map[a+1][b+1];
		sum += map[a+2][b+1];
		if(max < sum) max = sum;
		
		//┌┘
		sum = 0;
		sum += map[a][b+1];
		sum += map[a+1][b];
		sum += map[a+1][b+1];
		sum += map[a+2][b];
		if(max < sum) max = sum;
		
		//┌┘ 눕
		sum = 0;
		sum += map[a][b];
		sum += map[a][b+1];
		sum += map[a+1][b+1];
		sum += map[a+1][b+2];
		if(max < sum) max = sum;
		
		//└┐ 눕
		sum = 0;
		sum += map[a][b+1];
		sum += map[a][b+2];
		sum += map[a+1][b];
		sum += map[a+1][b+1];
		if(max < sum) max = sum;
		
		//ㅏ
		sum = 0;
		sum += map[a][b];
		sum += map[a+1][b];
		sum += map[a+1][b+1];
		sum += map[a+2][b];
		if(max < sum) max = sum;
		
		//ㅓ
		sum = 0;
		sum += map[a][b+1];
		sum += map[a+1][b];
		sum += map[a+1][b+1];
		sum += map[a+2][b+1];
		if(max < sum) max = sum;
		
		//ㅜ
		sum = 0;
		sum += map[a][b];
		sum += map[a][b+1];
		sum += map[a][b+2];
		sum += map[a+1][b+1];
		if(max < sum) max = sum;
		
		//ㅗ
		sum = 0;
		sum += map[a][b+1];
		sum += map[a+1][b];
		sum += map[a+1][b+1];
		sum += map[a+1][b+2];
		if(max < sum) max = sum;
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
        map = new int [n+6][m+6];
        
        for(int i=3; i<n+3; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	for(int j=3; j<m+3; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());        	
        	}
        }
        
        for(int i=0; i<n+3; i++) {
        	for(int j=0; j<m+3; j++) {
        		func(i, j);
        	}
        }
        
        System.out.println(max);
	}

}