package ÿ��һ��;

import java.util.Scanner;

public class �޼���ľ {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=1;i<=n/2;i++) {
			System.out.println(2*(n-i));
		}
		for(int i=n/2+1;i<=n;i++) {
			System.out.println(2*(i-1));
		}
	}
}
