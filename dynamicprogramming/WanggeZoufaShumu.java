package niuketest;

import java.util.Scanner;
/**
 * 动态规划之网格走法数目
 * 		有一个X*Y的网格，小团要在此网格上从左上角到右下角，
 * 		只能走格点且只能向右或向下走。
 * 		请设计一个算法，计算小团有多少种走法。给定两个正整数int x,int y，请返回小团的走法数目。
 * 
 * 输入描述:
 * 		输入包括一行，逗号隔开的两个正整数x和y，取值范围[1,10]。
 * 输出描述:
 * 		输出包括一行，为走法的数目。
 * 
 * 示例1
 * 	输入
 * 		3 2
 * 输出
 * 		10
 * 
 * 状态
 * 		d[i][j]:走到第i行第j列可以的走法数目
 * 		且当i=0时，d[0][j]只用一种走法
 * 		    当j=0时，d[i][0]只有一种走法
 * 
 * 状态转移方程
 * 		d[i][j]=d[i-1][j]+d[i][j-1]
 * 
 * @author lenovo
 *
 */
public class WanggeZoufaShumu {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int x=in.nextInt();
		int y=in.nextInt();
		int[][] d=new int[x+1][y+1];
		for(int i=0;i<=x;i++)	d[i][0]=1;
		for(int j=0;j<=y;j++)	d[0][j]=1;
		for(int i=1;i<=x;i++)
			for(int j=1;j<=y;j++)
				d[i][j]=d[i-1][j]+d[i][j-1];
		System.out.println(d[x][y]);
	}
}
