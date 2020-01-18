import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
 
public class SW_7701_염라대왕의이름정렬 {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int N;
        TreeSet<String> set = new TreeSet<>(new Comparator<String>() {
 
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() != o2.length()) {
                    return o1.length() < o2.length() ? -1 : 1;
                } else {
                    return o1.compareTo(o2);
                }
            }
        });
         
        for(int t = 1; t <= T; t++) {
            set.clear();
            N = Integer.parseInt(br.readLine());
            for(int i = 0; i < N; i++) set.add(br.readLine());
            Iterator<String> it = set.iterator();
             
            bw.write("#" + t + "\n");
            while(it.hasNext())
            bw.write(it.next() + "\n");
        }
        bw.flush();
         
    }
}