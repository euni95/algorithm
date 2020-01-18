import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_10818_최소최대 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int max = -1000001;
		int min = 1000001;
		int temp;
		for(int i = 0; i < N; i++) {
			temp = Integer.parseInt(st.nextToken());
			if(max <= temp) max = temp;
			if(min >= temp) min = temp;
		}
		System.out.println(min + " " + max);
 	}

}
