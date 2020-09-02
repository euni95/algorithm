import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P_1830_브라이언의고민_X {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Solution sol = new Solution();
		
		String sentence = br.readLine();
		System.out.println(sol.solution(sentence));
	}

	static class Solution {
		public String solution(String sentence) {
			String answer = "";
			
			if(sentence.length() != sentence.replace(" ", "").length()) return "invaild";
			
			
			boolean[] v = new boolean[26]; // 97 ~ 122
			int idx = -1;
			for(int i = 0; i < sentence.length(); i++) {
				char temp = sentence.charAt(i);
				
				if(temp >= 97) {
					int cnt = 1;
					idx = 0;
					for(int j = i + 1; j < sentence.length(); j++) {
						if(temp == sentence.charAt(j)) {
							idx = j;
							cnt++;
						}
						if(cnt > 2)  {
							cnt++;
							break;
						}
					}
					
					if(cnt == 2 && i + 2 < idx) {
						sentence = sentence.replace(Character.toString(temp), " ");
					}
				}
			}
			
			System.out.println("se " + sentence);
			char[] s = sentence.toCharArray();
			for(int i = 0; i < s.length; i++) {
				char temp = s[i];
				if(temp == ' ') continue;
				
				if(temp >= 97) {
					if (v[temp - 97]) return "invalid";
					v[temp - 97] = true;
					
					if(i == s.length - 1) return "invaild";
				
					int cnt = 1;
					for(int j = i + 1; j < s.length; j++) {
						if(temp == s[j]) cnt++;
						if(cnt > 2) return "invaild";
					}
					
					if(cnt == 1) return "invalid";
					answer += s[i + 1] + " ";
					i += 2;
				} 
				
				else {
					if(i == s.length - 1) {
						answer += temp;
						break;
					}
					
					idx = -1;
					for(int j = i + 1; j < s.length; j++) {
						if(s[j] >= 97) {
							idx = j - 1;
							break;
						}
					}
					if(idx == -1) {
						answer += sentence.substring(i);
						break;
					}
					
					if(idx > i) {
						System.out.println("욥" + sentence.substring(i, idx) + "?");
						answer += sentence.substring(i, idx) + " ";
					}
					
					System.out.println(s[idx] + " " + s[i]);
					
					if(s[idx + 1] == ' ') continue;
					if (v[s[idx + 1] - 97]) return "invalid";
					v[s[idx + 1] - 97] = true;

					String word = "";
					System.out.println(idx);
					int tempIdx = idx;
					while (true) {
						if(s[idx] >= 97) return "invalid";
						if (idx >= s.length - 1 || s[tempIdx + 1] != s[idx + 1]) {
							if (idx - 1 < s.length) {
								word += s[idx];
								i = idx;
							}
							answer += word + " ";
							System.out.println("요기" + answer);
							break;
						}
						
						word += s[idx];
						idx += 2;
						System.out.println(idx);

					}
				}
			}
			return answer.trim();
		}
//		public String solution(String sentence) {
//			String answer = "";
//			
//			if(sentence.length() != sentence.replace(" ", "").length()) return "invalid";
//			
//			char[] s = sentence.toCharArray();
//			boolean[] v = new boolean[26]; // 97 ~ 122
////			char symbol = ' ';
//			
//			for(int i = 0; i < s.length; i++) {
//				char temp = s[i];
//				System.out.println(temp);
//				
//				if(temp >= 97) {
//					if(v[temp - 97]) return "invalid";
//					v[temp - 97] = true;
//					
//					int idx = i + 1;
//					
//					String word = "";
//					while(true) {
//						if(idx >= s.length) return "invalid";
//						if(s[idx] >= 97) {
//							if(s[idx] != s[i]) return "invalid";
//							answer += word + " ";
//							i = idx;
//							System.out.println(answer);
//							break;
//						}
//						word += s[idx];
//						idx++;
//					}
//				} else {
//					if(i == s.length - 1) answer += s[i];
//					else if(s[i + 1] < 97) {
//						int idx = i;
//						String word = "";
//						while(true) {
//							if(idx >= s.length || s[idx] >= 97) {
//								answer += word + " ";
//								i = idx - 1;
//								break;
//							}
//							word += s[idx++];
//						} 
//					} else {
//						int idx = i + 1;
//						if(v[s[idx] - 97]) return "invalid";
//						v[s[idx] - 97] = true;
//						
//						String word = "";
//						int cnt = 0;
//						while(true) {
//							if(idx >= s.length || s[i + 1] != s[idx]) {
////								System.out.println(cnt);
//								if(cnt == 1 && idx < s.length) {
//									i = idx - 3;
//									v[s[i + 1] - 97] = false;
////									System.out.println("?");
//								} else if(idx - 1 < s.length) {
//									System.out.println(idx);
//									word += s[idx - 1];
//									i = idx - 1;
////									System.out.println("?");
//								}
//								answer += word + " ";
//								System.out.println(answer);
//								break;
//							}
//							
//							cnt++;
//							word += s[idx - 1];
//							idx += 2;
//						}
//					}
//				}
//			}
//			return answer.trim();
//		}
	}
}
