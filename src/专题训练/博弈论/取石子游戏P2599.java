package 专题训练.博弈论;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashSet;
import java.util.Set;

import javax.print.attribute.HashAttributeSet;

public class 取石子游戏P2599 {
	public static void main(String[] args) {
//		IO sc=new IO();
//		int n=sc.nextInt();
//		while(n!=0) {
//			int m=sc.nextInt();
//			int[] ns=new int[m];
//			for(int i=0;i<m;i++) {
//				ns[i]=sc.nextInt();
//			}
//			
//			n--;
//		}
		
	}
	static class IO{
		StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		public int nextInt() {
			try {
				st.nextToken();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return (int)st.nval;
		}
	}
}
