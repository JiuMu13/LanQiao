package 每日一题;

import java.util.PriorityQueue;
import java.util.Scanner;
//平衡三进制
public class 最少砝码 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long curr=1;
		long result=0;
		long n=sc.nextLong();
		long sum=0;
		while(sum<n) {
			sum+=curr;
			curr*=3;
			result++;
		}
		System.out.println(result);
	}
}
