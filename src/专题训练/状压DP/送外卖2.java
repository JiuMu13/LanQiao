package 专题训练.状压DP;

import java.util.Arrays;
import java.util.Scanner;

public class 送外卖2 {
	    public static int n;
	    public static int q;
	    public static int[][] needs;//配送需求
	    public static int[][] map;//map[i][j] ,i到j的最短路径
	    public static int INF = 10000000;
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	         n = sc.nextInt();
	         int m = sc.nextInt();
	         q = sc.nextInt();
	         map = new int[n][n];
	         //填充每个路径为最高值
	         for (int[] ti : map )
	             Arrays.fill(ti , INF);
	        needs = new int[q][4];
	         //同点的路径设为0
	         for (int i = 0 ; i < n ; i ++ )
	             map[i][i] = 0;
	        for (int i = 0 ; i < m ; i ++ ){
	            int start = sc.nextInt() - 1;
	            int end = sc.nextInt() - 1;
	            int val = sc.nextInt();
	            map[start][end] = Math.min(map[start][end] , val);
	        }
	        for (int i = 0 ; i < q ; i ++ ){
	            needs[i][0] = sc.nextInt() - 1;
	            needs[i][1] = sc.nextInt() - 1;
	            needs[i][2] = sc.nextInt();
	            needs[i][3] = sc.nextInt();
	        }
	        int ans = resultAns();
	        System.out.println(ans);
	    }
	    public static int resultAns(){
	        //获取最短路径
	        minRoad();
	        //状态压缩
	        SetPower();
	        //读取状态
	        readPower();
	        int[][] dp = new int[power[q]][n]; //  dp[i][j] ,i状态下j落脚点的最短耗时
	        //填充所有dp值
	        for (int[] f: dp ) 
	            Arrays.fill(f , INF);
	        dp[0][0] = 0;
	        for (int i = 0 ; i < power[q] ; i ++ )
	            for (int j = 0 ; j < n ; j ++ )
	                //检测是否可达状态
	                if (dp[i][j] < INF){
	                    for (int k = 0 ; k < q ; k ++ ){
	                        int state = reader[i][k];
	                        //如果第k个配送需求三进制的值为零，表示未接单
	                        if (state == 0){
	                            int stop = needs[k][0];
	                            int time = dp[i][j] + map[j][stop];
	                            int to = i + power[k]; //推荐状态 ，未接单-->已接单
	                            dp[to][stop] =time < needs[k][2] ? Math.min(dp[to][stop] , needs[k][2]) : Math.min(dp[to][stop] , time);
	                            //如果值为1，表示已接单
	                        }else if (state == 1){
	                            int stop = needs[k][1];
	                            int time = dp[i][j] + map[j][stop];
	                            int to = i + power[k] ; //推荐状态 ， 已接单 --> 已送达
	                            if (time <= needs[k][3])
	                                dp[to][stop] = Math.min(dp[to][stop] , time);
	                        }
	                    }
	                }
	        int ans = 0;
	        //最后遍历所有可达状态
	        for (int i = 0 ; i < power[q] ; i ++ )
	            for (int j = 0 ; j < n ; j ++ )
	                if (dp[i][j] < INF){
	                    int temp = 0;
	                    for (int k = 0 ; k < q ; k ++ ){
	                        temp += reader[i][k] == 2 ? 1 : 0;
	                    }
	                    ans = Math.max(ans , temp);
	                }
	        return ans;
	    }
	    //获取最短路径
	    public static void minRoad(){
	        for (int i = 0 ; i < n ; i ++ )
	            for (int j = 0 ; j < n ; j ++ )
	                for (int k = 0 ; k < n ; k ++ )
	                    map[j][k] = Math.min(map[j][k] , map[j][i] + map[i][k]);
	    }
	    public static int[] power;//三进制取值，power[i]表示3的i次方的值
	    //状态压缩，三进制取值
	    public static void SetPower(){
	        power = new int[q+1];
	        power[0] = 1;
	        for (int i = 1 ; i <= q ; i ++ ){
	            power[i] = power[i-1] * 3;
	        }
	    }
	    public static int[][] reader;//状态阅读，reader[i][j]表示第i种状况j的状态
	    //状态读取
	    public static void readPower(){
	        reader = new int[power[q]][q];
	       for (int i = 0 ; i < power[q] ; i ++ ){
	           int now = i;
	           for (int j = 0 ; j < q ; j ++ ){
	               int state = now % 3;
	               now /= 3;
	               reader[i][j] = state;
	           }
	       }
	    }
}



