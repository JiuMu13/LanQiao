package ר��ѵ��.״ѹDP;

import java.util.Arrays;
import java.util.Scanner;

public class ������2 {
	    public static int n;
	    public static int q;
	    public static int[][] needs;//��������
	    public static int[][] map;//map[i][j] ,i��j�����·��
	    public static int INF = 10000000;
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	         n = sc.nextInt();
	         int m = sc.nextInt();
	         q = sc.nextInt();
	         map = new int[n][n];
	         //���ÿ��·��Ϊ���ֵ
	         for (int[] ti : map )
	             Arrays.fill(ti , INF);
	        needs = new int[q][4];
	         //ͬ���·����Ϊ0
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
	        //��ȡ���·��
	        minRoad();
	        //״̬ѹ��
	        SetPower();
	        //��ȡ״̬
	        readPower();
	        int[][] dp = new int[power[q]][n]; //  dp[i][j] ,i״̬��j��ŵ����̺�ʱ
	        //�������dpֵ
	        for (int[] f: dp ) 
	            Arrays.fill(f , INF);
	        dp[0][0] = 0;
	        for (int i = 0 ; i < power[q] ; i ++ )
	            for (int j = 0 ; j < n ; j ++ )
	                //����Ƿ�ɴ�״̬
	                if (dp[i][j] < INF){
	                    for (int k = 0 ; k < q ; k ++ ){
	                        int state = reader[i][k];
	                        //�����k���������������Ƶ�ֵΪ�㣬��ʾδ�ӵ�
	                        if (state == 0){
	                            int stop = needs[k][0];
	                            int time = dp[i][j] + map[j][stop];
	                            int to = i + power[k]; //�Ƽ�״̬ ��δ�ӵ�-->�ѽӵ�
	                            dp[to][stop] =time < needs[k][2] ? Math.min(dp[to][stop] , needs[k][2]) : Math.min(dp[to][stop] , time);
	                            //���ֵΪ1����ʾ�ѽӵ�
	                        }else if (state == 1){
	                            int stop = needs[k][1];
	                            int time = dp[i][j] + map[j][stop];
	                            int to = i + power[k] ; //�Ƽ�״̬ �� �ѽӵ� --> ���ʹ�
	                            if (time <= needs[k][3])
	                                dp[to][stop] = Math.min(dp[to][stop] , time);
	                        }
	                    }
	                }
	        int ans = 0;
	        //���������пɴ�״̬
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
	    //��ȡ���·��
	    public static void minRoad(){
	        for (int i = 0 ; i < n ; i ++ )
	            for (int j = 0 ; j < n ; j ++ )
	                for (int k = 0 ; k < n ; k ++ )
	                    map[j][k] = Math.min(map[j][k] , map[j][i] + map[i][k]);
	    }
	    public static int[] power;//������ȡֵ��power[i]��ʾ3��i�η���ֵ
	    //״̬ѹ����������ȡֵ
	    public static void SetPower(){
	        power = new int[q+1];
	        power[0] = 1;
	        for (int i = 1 ; i <= q ; i ++ ){
	            power[i] = power[i-1] * 3;
	        }
	    }
	    public static int[][] reader;//״̬�Ķ���reader[i][j]��ʾ��i��״��j��״̬
	    //״̬��ȡ
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



