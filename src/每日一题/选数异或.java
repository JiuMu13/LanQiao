package 每日一题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 选数异或 {
	public static void main(String[] args) {
		IO sc=new IO();
		int n=sc.nextInt();
		int m=sc.nextInt();
		int x=sc.nextInt();
		int[] s=new int[n];
		int[] xs=new int[n];
		for (int i = 0; i < s.length; i++) {
			s[i]=sc.nextInt();
			xs[i]=s[i]^x;
		}
		Map<Integer,Integer> lmap=new HashMap<Integer, Integer>();
		int near=-1;
		int[] ls=new int[n];
		Arrays.fill(ls,-1);
		for(int i=0;i<n;i++) {
			if(lmap.containsKey(xs[i])) {
				int t=lmap.get(xs[i]);
				near=Math.max(t,near);
				ls[i]=near;
			}else {
				ls[i]=near;
			}
			lmap.put(s[i],i);
		}
		while(m!=0) {
			int l=sc.nextInt();
			int r=sc.nextInt();
			int[] t=new int[20];
			if(ls[r-1]>=l-1) {
				System.out.println("yes");
			}else
				System.out.println("no");
			m--;
		}
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
