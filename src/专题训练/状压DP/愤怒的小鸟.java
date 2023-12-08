package ר��ѵ��.״ѹDP;

import java.util.Arrays;
import java.util.Scanner;

public class ��ŭ��С�� {
	static double e=1e-6;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		double[] r=new double[2];//�淽�̵�����δ֪��a��b
		while((T--)!=0) {
			int n=sc.nextInt();//��ĸ���
			int m=sc.nextInt();//ָ��
			double[][] wz=new double[n][2];//0��x,1��y
			for (int i = 0; i < n; i++) {
				wz[i][0]=sc.nextDouble();
				wz[i][1]=sc.nextDouble();
			}
			int[][] f=new int[18][18];//��ʾ����i,j������������ܴ򵽵����״̬
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					init(wz,i,j,r);
					double a=r[0],b=r[1];
					for (int h = 0; h < n; h++) {
						double x=wz[h][0],y=wz[h][1];
//                        System.out.println("a="+a+"  b="+b);
                        if(a>0 || cmp(a,0)){
                            f[i][j]=1<<i;
                            break;
                        }
						if(cmp(a*x*x+b*x , y)) {
//							System.out.println("a="+a+"  b="+b);
							f[i][j]+=1<<h;
//							System.out.println(Integer.toBinaryString(f[i][j]));
						}
					}
				}	
			}
			int[] dp=new int[1<<18];
			Arrays.fill(dp,Integer.MAX_VALUE/2);
			dp[0]=0;
			for (int i = 0; i < (1<<n); i++) {
				for (int j = 0; j < n; j++) {
					for (int h = 0; h < n; h++) {
						dp[f[j][h] | i]=Math.min(dp[f[j][h] | i],dp[i]+1);
					}
				}
			}
			System.out.println(dp[(1<<n)-1]);
		}
		
	}
	private static void init(double[][] wz,int f1,int f2,double[] r) {
		double x1=wz[f1][0],y1=wz[f1][1],x2=wz[f2][0],y2=wz[f2][1];
		r[0]=(y1-y2*x1/x2)/(x1*(x1-x2));
		r[1]=(y1*x2*x2-y2*x1*x1)/(x1*x2*x2-x2*x1*x1);
		if((x1*x1*x2-x1*x2*x2)<1e-6 && (x1*x1*x2-x1*x2*x2)>-(1e-6))
			r[0]=0;
	}
	private static boolean cmp(double a, double b) {
		return a - e < b && b < a + e;
	}
}
