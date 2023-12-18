package 每日一题;

import java.util.Scanner;

public class 刷题统计 {
	public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long a=sc.nextLong();
        long b=sc.nextLong();
        long n=sc.nextLong();
        long l=0,s=5*a+2*b,r=(long)1e18/s*2;
        while (l<r){
            long mid=(l+r+1)>>1;
            if (s*mid>=n){
                r=mid-1;
            }else {
                l=mid;
            }
        }
        long sum=l*s;
        long day=l*7;
        for (int i=0;sum<n && i<5;i++){
            day++;
            sum+=a;
        }
        for (int i=0;sum<n && i<2;i++){
            day++;
            sum+=b;
        }
        System.out.println(day);
    }
}
