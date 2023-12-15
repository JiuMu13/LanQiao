package 每日一题;
//带权并查集

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
//带权并查集
public class 推导部分和 {
	static int[] root=new int[100010];
	static long[] value=new long[100010];
	static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
	
	static {
		for (int i = 0; i < root.length; i++) {
			root[i]=i;
		}
	}
	public static void main(String[] args) {
		int n=nextInt();
		int m=nextInt();
		int q=nextInt();
		while(m!=0) {
			int x=nextInt();
			int y=nextInt();
			long v=nextLong();
			union(x, y+1, v);
			m--;
		}
		while(q!=0) {
			int l=nextInt();
			int r=nextInt();
			if(find(l)==find(r+1)) {
				System.out.println(value[l]-value[r+1]);
				
			}else {
				System.out.println("UNKNOWN");
			}
			q--;
		}
	}
	private static int find(int n) {
		if(n!=root[n]) {
			int t=root[n];
			root[n]=find(root[n]);
			value[n]+=value[t];
		}
		return root[n];
	}
	private static void union(int x,int y,long w) {
		int fx=find(x);
		int fy=find(y);
		if(fx!=fy) {
			root[fx]=fy;
			value[fx]=-value[x]+value[y]+w;
		}
	}
	private static int nextInt() {
		try {
			st.nextToken();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (int)st.nval;
	}
	private static long nextLong() {
		try {
			st.nextToken();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (long)st.nval;
	}
}
