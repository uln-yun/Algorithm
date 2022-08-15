package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Camping {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = null;
        StringTokenizer st = null;
        int n =0;
        while(true){
            n++;
            str = br.readLine();
            st = new StringTokenizer(str);
            int l = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if(l==0 && p==0 && v==0){
                break;
            }
            int num = v/p;
            int na = v%p;

            int canUse;
            if(na<=l){
                canUse =num*l+na;
            }else{
                canUse =num*l+l;
            }

            bw.write("Case "+Integer.toString(n)+": "+Integer.toString(canUse)+"\n");
        }


        bw.flush();
        bw.close();
	}

}
