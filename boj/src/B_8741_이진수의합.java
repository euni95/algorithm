import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B_8741_이진수의합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int k = Integer.parseInt(br.readLine());
		for(int i = 0; i < k; i++) bw.write("1");
		for(int i = 0; i < k - 1; i++) bw.write("0");
		bw.flush();
	}
}
