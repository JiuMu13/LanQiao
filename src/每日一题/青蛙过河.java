package 每日一题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class 青蛙过河 {
	static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
	private static int nextInt() {
		try {
			st.nextToken();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (int)st.nval;
	}
	static int[] sz;
	static int n;
	static int d;
	public static void main(String[] args) {
		n=nextInt();
		d=nextInt();
		sz=new int[n];
		for (int i = 1; i < n; i++) {
			sz[i]=nextInt();
		}
		init(n);
		int left=1,right=n;
		int mid;
		while(left<right) {
			mid=(left+right)/2;
			if(resolve2(mid)) {
				right=mid;
			}else {
				left=mid+1;
			}
		}
		System.out.println(left);
	}
	
	//74分
	private static boolean resolve(int jump) {
		int[] s=Arrays.copyOf(sz, sz.length);
		int[] b=new int[n+1];
		b[0]=d;
		//
		for(int i=0;i+jump<n;i++) {
			int pre=0;
			while(b[i]!=0 && pre<jump ) {
				if(s[i+jump-pre]<b[i]) {
					b[i]-=s[i+jump-pre];
					b[i+jump-pre]=s[i+jump-pre];
					s[i+jump-pre]=0;
				}else {
					b[i+jump-pre]=b[i];
					s[i+jump-pre]-=b[i];
					b[i]=0;	
				}
				pre++;
			}
			if(b[i]!=0 && pre==jump)
				return false;
		}
		//
		Arrays.fill(b,0);
		b[n]=d;
		for(int i=n;i-jump>0;i--) {
			int pre=0;
			while(b[i]!=0 && pre<jump ) {
				if(s[i-jump+pre]<b[i]) {
					b[i]-=s[i-jump+pre];
					b[i-jump+pre]=s[i-jump+pre];
					s[i-jump+pre]=0;
				}else {
					b[i-jump+pre]=b[i];
					s[i-jump+pre]-=b[i];
					b[i]=0;	
				}
				pre++;
			}
			if(b[i]!=0 && pre==jump)
				return false;
		}
		return true;
	}

	
	//100分
	static int[] pre;
	private static void init(int n) {
		pre=new int[n];
		for (int i = 1; i < pre.length; i++) {
			pre[i]=pre[i-1]+sz[i];
		}
	}
	
	private static boolean resolve2(int jump) {
		for(int i=1;i+jump<=n;i++) {
			if(pre[i+jump-1]-pre[i-1]<2*d) {
				return false;
			}
		}
		return true;
	}
}
