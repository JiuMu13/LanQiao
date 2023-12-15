package 每日一题;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class 顺子日期 {
	public static void main(String[] args) {
		Date date=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		Calendar c=null;
		try {
			date=sdf.parse("20220101");
			c=Calendar.getInstance();
			c.setTime(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int count=0;
		for(int i=0;i<365;i++) {
			if(count(Integer.parseInt(sdf.format(c.getTime()).substring(3)))) {
//				System.out.println(sdf.format(c.getTime()));
				count++;
			}
			c.add(Calendar.DAY_OF_YEAR, 1);
			
		}
		System.out.println(count);
		
	}
	private static boolean count(int n) {
		int curr=n%10;
		n/=10;
		while(n!=0){
			int t=n%10;
			n/=10;
			if(curr==t+1) {
				if(n!=0 && curr==(n%10)+2)
					return true;
			}
//			if(curr==t-1) {
//				if(n!=0 && curr==(n%10)-2)
//					return true;
//			}
			curr=t;
		}
		return false;
	}
}
