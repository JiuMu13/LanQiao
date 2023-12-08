package 每日一题;

import java.util.Scanner;

public class 裁纸刀 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int row=20;
		int collumn=22;
		int result=(row-1)+(collumn-1)*row+4;
		System.out.println(result);
	}
}
