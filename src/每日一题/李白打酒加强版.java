package 每日一题;

import java.util.Scanner;

//三维dp，解题关键是从题目中读出酒的数量不超过m次
public class 李白打酒加强版 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in); 
		int n=sc.nextInt();
		int m=sc.nextInt();
		int mod=(int)1e9+7;
		int[][][] dp=new int[m+1][n+1][m+1];//酒，店，花
		dp[2][0][0]=1;
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=m;j++) {
				for(int k=0;k<=m;k++) {
					if(k-1>=0 && j+1<=m)
						dp[k-1][i][j+1]=(dp[k-1][i][j+1]+dp[k][i][j])%mod;
					if(i+1<=n && k*2<=m && !(i+1==n && j==m)) {
						dp[k*2][i+1][j]=(dp[k*2][i+1][j]+dp[k][i][j])%mod;
					}
				}
			}
		}
		System.out.println(dp[0][n][m]);
	}
}
