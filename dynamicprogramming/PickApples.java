package dynamicprogramming;

/**
 * 动态规划问题三：捡最多的苹果
 * 		平面上有N＊M个格子，每个格子中放着一定数量的苹果。
 * 		你从左上角的格子开始， 每一步只能向下走或是向右走，每次走到一个格子上就把格子里的苹果收集起来。
 * 		 这样下去，你最多能收集到多少个苹果？
 * 
 * 	令d[i][j]代表第i行第j列处的苹果个数。
 * 
 * 	令s[i][j]代表走到第i行第j列时最多能够收集到的苹果个数，显然，这就是状态。
 * 
 * 	由于每一步只能向下走或是向右走，所以s[i][j]=max{s[i-1][j],s[i][j-1]}+d[i][j]，这就是状态转移方程
 * 
 * @author lilingyun
 *
 */
public class PickApples {
	public static void main(String[] args) {
		int[][] d={{1,2,3},{1,2,3}};
		int n=d.length;
		int m=d[0].length;
		int[][] s=new int[n][m];
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				if(i>0&&j>0)				s[i][j]=(s[i-1][j]>s[i][j-1]?s[i-1][j]:s[i][j-1])+d[i][j];
				else if(i>0&&j==0)		s[i][j]=s[i-1][j]+d[i][j];
				else if(i==0&&j>0)		s[i][j]=s[i][j-1]+d[i][j];
				else if(i==0&&j==0)	s[i][j]=d[i][j];
		System.out.println(s[n-1][m-1]);
	}
}
