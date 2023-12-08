package 每日一题;
//状压DP
public class 回路计数 {
	public static void main(String[] args) {
		int[][] g=new int[21][21];
		for (int i = 0; i < 21; i++) {
			for (int j = 0; j < 21; j++) {
				if(gcd(i+1,j+1)==1) {
					g[i][j]=1;
				}
			}
		}
		long[][] f=new long[1<<21][21];
		f[1][0]=1;
		for (int i = 1; i < (1<<21) ; i++) {
			for (int j = 0; j < 21; j++) {
				if((i>>j & 1) == 1) {
					for (int h = 0; h < 21; h++) {
						if(g[j][h]==1 && (i>>h & 1)==0) {
							f[i+(1<<h)][h]+=f[i][j]; 
						}
					}
				}
			}
		}
		long result=0;
		for (int i = 0; i < 21; i++) {
			result+=f[(1<<21) -1][i];
		}
		System.out.println(result);
	}
	private static int gcd(int n,int m) {
		return m!=0?gcd(m,n%m):n;
	}
}
