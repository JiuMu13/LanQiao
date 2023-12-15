package 专题训练.并查集;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Scanner;

public class 食物链P2024 {
	static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
	static int[] next=new int[50010];
	static int[] value=new int[50010];
	static {
		for (int i = 0; i < next.length; i++) {
			next[i]=i;
		}
	}
	public static void main(String[] args) {
		int n=nextInt();
		int k=nextInt();
		int count=0;
		while(k!=0) {
			int type=nextInt();
			int x=nextInt();
			int y=nextInt();
			if(x==y && type==2 || x>n || y>n ) {
				count++;
				k--;
				continue;
			}
			if(find(x)==find(y)) {
				if(type==1 && (value[x]-value[y])%3!=0) 
					count++;
				else if(type==2 && (value[x]-value[y])%3!=1 && (value[y]-value[x])%3!=2) 
					count++;
			}else {
				if(type==1)
					union(x,y,0);
				else {
					union(x,y,1);
				}
			}
			k--;
		}
		System.out.println(count);
	}
	static int find(int n) {
		if(n!=next[n]) {
			int t =next[n];
			next[n]=find(next[n]);
			value[n]+=value[t];
		}
		return next[n];
	}
	static void union(int x,int y,int w) {
		int fx=find(x);
		int fy=find(y);
		if(fx!=fy) {
			next[fx]=fy;
			value[fx]=-value[x]+value[y]+w;
		}
	}
	static int nextInt() {
		try {
			st.nextToken();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (int)st.nval;
	}
}
