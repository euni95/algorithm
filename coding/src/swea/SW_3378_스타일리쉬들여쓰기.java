import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SW_3378_스타일리쉬들여쓰기 {
	static String[] master;
	static String[] me;
	static ArrayList<Integer> result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 소괄호 () R
		// 중괄호 {} C
		// 대괄호 [] S
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			master = new String[p];
			me = new String[q];
			
			for(int i = 0; i < p; i++)
				master[i] = br.readLine();
			
			for(int i = 0; i < q; i++)
				me[i] = br.readLine();
			
			
			result = new ArrayList<>();
			rcs = new ArrayList<>();
			for(int r = 1; r <= 20; r++) {
				for(int c = 1; c <= 20; c++) {
					for(int s = 1; s <= 20; s++) {
						if(check(r, c, s)) {
							rcs.add(new Point(r, c, s));
							countTab(r, c, s);
						}
					}
				}
			}
			
			if(rcs.size() == 0) result.add(-1);
			System.out.print("#" + t + " ");
			for(int i : result) System.out.print(i + " ");
			System.out.println();
		}
	}
	static ArrayList<Point> rcs;
	private static ArrayList<Integer> countTab(int r, int c, int s) {
		int tempR = 0, tempS = 0, tempC = 0;
		result.clear();
		
		for(int i = 0; i < me.length; i++) {
			boolean check = false;
			
			int temp = (rcs.get(0).r * tempR) + (rcs.get(0).c * tempC) + (rcs.get(0).s * tempS);
			for(Point p : rcs) {
				if(temp != ((p.r * tempR) + (p.c * tempC) + (p.s * tempS))) {
					result.add(-1);
					check = true;
					break;
				}
				temp = (p.r * tempR) + (p.c * tempC) + (p.s * tempS);
			}
			if(!check) {
				result.add(r * tempR + c * tempC + s * tempS);
			}

			for(int j = 0; j < me[i].length(); j++) {
				if(me[i].charAt(j) == '(') {
					tempR++;
				}
				if(me[i].charAt(j) == '{') {
					tempC++;
				}
				if(me[i].charAt(j) == '[') {
					tempS++;
				}
				
				if(me[i].charAt(j) == ')') {
					tempR--;
				}
				if(me[i].charAt(j) == '}') {
					tempC--;
				}
				if(me[i].charAt(j) == ']') {
					tempS--;
				}
			}
		}
		return result;
	}
	private static boolean check(int r, int c, int s) {
		int temp = 0, tab = 0;
		
		for(int i = 0; i < master.length; i++) {
			temp = 0;
		
			for(int j = 0; j < master[i].length(); j++) {
				
				if(j==0) {
					while(master[i].charAt(j) == '.') {
						temp++;
						j++;
					}
					if(i != 0 && tab != temp) {
						return false;
					}
				}
				
				if(master[i].charAt(j) == '(') {
					tab += r;
				}
				if(master[i].charAt(j) == '{') {
					tab += c;
				}
				if(master[i].charAt(j) == '[') {
					tab += s;
				}
				
				if(master[i].charAt(j) == ')') {
					tab -= r;
				}
				if(master[i].charAt(j) == '}') {
					tab -= c;
				}
				if(master[i].charAt(j) == ']') {
					tab -= s;
				}
			}
		}
		return true;
	}
	
	static class Point {
		int r, c, s;

		public Point(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}
}
