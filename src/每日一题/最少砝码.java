package ÿ��һ��;

import java.util.PriorityQueue;
import java.util.Scanner;
//ƽ��������
public class �������� {
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
