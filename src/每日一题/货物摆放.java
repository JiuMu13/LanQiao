package 每日一题;

public class 货物摆放 {
	public static void main(String[] args) {
		long n=2021041820210418l;
		long count=0,count2=0;
		long sq=(long) Math.sqrt(n);
		long sq2=0,sq3=0;
		long r=0;
		for (long i = 1; i <= sq; i++) {
			if(n%i!=0)
				continue;
			count=0;
			count2=0;
			long t=n/i;
			sq2=(long)Math.sqrt(t);
			for (int j = 1; j <= sq2; j++) {
				if(t%j==0) {
					count++;
				}
			}
			count*=2;
			if(sq2*sq2==t)
				count--;
			if(i*i!=n) {
				sq3=(long)Math.sqrt(i);
				for (int j = 1; j <= sq3; j++) {
					if(i%j==0) {
						count2++;
					}
				}
				count2*=2;
				if(sq3*sq3==i)
					count2--;
			}
			r+=count+count2;
		}
		System.out.println(r);
	}	
}
