package 专题训练.博弈论;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class 尼姆游戏 {
	
	public static void main(String[] args) {
		IO sc=new IO();
		int n=sc.nextInt();
		while(n!=0) {
			int m=sc.nextInt();
			int r=0;
			for (int i = 0; i < m; i++) {
				r ^=sc.nextInt();
			}
			if(r==0) {
				System.out.println("No");
			}else {
				System.out.println("Yes");
			}
			n--;
		}
	}
	static class IO{
	    StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		public int nextInt() {
			try {
				st.nextToken();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return (int)st.nval;
		}
		public String next() {
			try {
				st.nextToken();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return st.sval;
		}
		public String nextString() {
			String s=null;
			try {
				s= br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return s;
		}
	}
	
}
