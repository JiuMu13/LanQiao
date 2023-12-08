package 专题训练.状压DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
//未完成
public class 珂学送分2 {
	public static void main(String[] args) {
		Io sc=new Io();
		int n=sc.nextInt();
		int m=sc.nextInt();
		int a=sc.nextInt();
		int b=sc.nextInt();
		int[] v=new int[n+1];
		for(int i=1;i<=n;i++)
			v[i]=sc.nextInt();
		//读入b条规则
		int[] gz=new int[1<<(a)];//表示满足规则的序列所加的分值
		while (b!=0) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			int t=0;
			for (int i = 0; i <x; i++) {
				t += 1<<(sc.nextInt()-1);
			}
			gz[t]+=y;
			b--;
		}
		for (int i = (1<<a)-1 ; i>=0 ; i--) {
			if(gz[i]==0) 
				continue;
			int y= ((1<<a)-1) - i;
			for(int j=y; j>0 ; j= (j-1) & y) {
				gz[i | j]+=gz[i];
			}
		}
//		System.out.println(Arrays.toString(gz));
		long result=0;
		int[][][] dp=new int[n+1][m+1][1<<(a)];//第一级表示从前n个数中选，第二级表示选m个数，第三级表示选中的数中最后a个数的状态
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <=m && j<=i; j++) {
				for (int k = 0; k < (1<<a) && k < (1<<j); k++) {
					int curr= k >> 1;
					int t;
					if(j<a) {
						t=k>>(j-1);
					}else {
						t=k>>(a-1);
					}
					if(t==1) {
						dp[i][j][k]=Math.max(dp[i-1][j-1][(k>>1) << 1 ], dp[i-1][j-1][((k>>1) << 1)+ 1])+gz[k]+v[i];        
					}else {
						dp[i][j][k]=Math.max(dp[i-1][j][(k>>1) << 1 ], dp[i-1][j][((k>>1) << 1)+ 1]) + gz[k];
					}
					result=Math.max(result,dp[i][j][k]);
				}
			}
		}
		System.out.println(result);
	}
	public static class Io{
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		public int nextInt(){
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




//int curr= k >> 1;
//						int next0= curr;
//						int next1;
//						if(j<a) {
//							next1=curr+(1<<(j-1));
//						}else {
//							next1= curr + ( 1<<(a-1) );
//						}
//						dp[i][j][next0]= dp[i-1][j][k]+gz[next0];
//						dp[i][j][next1]=dp[i-1][j-1][k]+gz[next1]+v[i];
//						System.out.print("dp["+i+"]["+j+"][next0]:"+dp[i][j][next0]);
//						System.out.println("    dp["+i+"]["+j+"][next1]:"+dp[i][j][next1]);
//						System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
//						result=Math.max(result,Math.max(dp[i][j][next0], dp[i][j][next1]));


