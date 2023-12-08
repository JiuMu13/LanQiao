package 每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
//博弈论
public class 灭鼠先锋 {
	public static void main(String[] args) {
		boolean[] f=new boolean[1<<8];
		List<Integer> l=new ArrayList<>();
		int full=(1<<8)-1;
		for(int i=0;i<8;i++)
			l.add(full-(1<<i));
		l.add(full-(3<<6));
		l.add(full-(3<<5));
		l.add(full-(3<<4));
		l.add(full-(3<<2));
		l.add(full-(3<<1));
		l.add(full-(3));
		Arrays.fill(f, false);
		for(int i=0;i<8;i++) {
			f[(1<<8)-1-(1<<i)]=true;
		}
		for(int i=(1<<8)-1;i>=0;i--) {
			for(Integer e:l) {
				f[i&e]=!f[i];
			}
		}
		StringBuilder sb=new StringBuilder();
		List<Integer> r=new ArrayList<Integer>();
		r.add(Integer.parseInt("10000000",2));
		r.add(Integer.parseInt("11000000",2));
		r.add(Integer.parseInt("01000000",2));
		r.add(Integer.parseInt("01100000",2));
		for(Integer e:r) {
			if(f[e])
				sb.append("L");
			else
				sb.append("V");
		}
		System.out.println(sb);
	}
}
