import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/*
TC

5 8
0 0 0 0 0
0 0 1 0 3
0 2 5 0 1
4 2 4 4 2
3 5 1 3 1
1 5 3 5 1 2 1 4

*/

public class P_64061_크레인인형뽑기게임 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[N][N];
		System.out.println("-------------- board --------------");
		for(int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
			System.out.println(Arrays.toString(board[i]));
		}
		
		System.out.println("\n-------------- moves --------------");
		int[] moves = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			moves[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(Arrays.toString(moves));
		System.out.println();
		
		int result = solution(board, moves);
		System.out.println("\n-------------- result --------------");
		System.out.println(result);
	}

	static public int solution(int[][] board, int[] moves) {
		int answer = 0;
		Stack<Integer> st = new Stack<>();
		
		for(int i = 0; i < moves.length; i++) {
			int number = 0;
			
			for(int j = 0; j < board.length; j++) {
				int temp = board[j][moves[i] - 1];
				if(temp != 0) {
					board[j][moves[i] - 1] = 0;
					number = temp;
					break;
				}
			}
			
			if(number == 0) continue;
			if(st.isEmpty()) {
				st.add(number);
			} else {
				int temp = st.peek();
				if(number == temp) {
					st.pop();
					answer += 2;
				} else {
					st.add(number);
				}
			}
			
//			Iterator<Integer> it = st.iterator();
//			System.out.println("\n-------------- stack --------------");
//			while(it.hasNext()) {
//				System.out.print(it.next() + " ");
//			}
//			System.out.println();
		}
		return answer;
	}
}
