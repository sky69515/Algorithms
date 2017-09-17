package niuketest;
/**
 * 动态规划之拼凑面额
 * 		给你六种面额1、5、10、20、50、100元的纸币，
 * 		假设每种币值的数量都足够多，
 * 		编写程序求组成N员（N为0-10000的非负整数）的不同组合的个数。
 * 
 * 输入描述:
 * 		输入为一个数字N，即需要拼凑的面额
 * 输出描述:
 * 		输出也是一个数字，为组成N的组合个数。
 * 
 * 示例1
 * 输入
 * 		5
 * 输出
 * 		2
 * 
 * 状态
 * 		令d[i]为拼凑i元的不同组合个数
 * 
 * 分析状态转移方程
 * 		令coins[j]代表6种面额纸币
 * 		j=0时，coins[0]只使用1元纸币
 * 		d[0]=1;
 * 		d[1]=d[1]+d[1-0]
 * 		d[2]=d[2]+d[2-1]
 * 		...
 * 		d[n]=d[n]+d[n-1]
 * 		j=1时，coins[1]只使用1、5元纸币
 * 		d[5]=d[5]+d[0]
 * 		...
 * 		d[n]=d[n]+d[n-5]
 * 
 * 总结状态转移方程
 * 		d[i]=d[i]+d[i-v[j]]  j从0到i<v[j]
 * 
 * @author lilingyun
 */
import java.util.Scanner;

public class PinchouMiane {
	    public static void main(String[] args){  
	        Scanner scanner = new Scanner(System.in);  
	        int n =  scanner.nextInt();  
	  
	        int[] coins = {1, 5, 10, 20, 50, 100};  
	  
	        long[] d = new long[n + 1];  
	        d[0] = 1;  
	        for (int i = 0; i < 6; i++){  
	            for (int j = 1; j <= n; j++){  
	                if (j >= coins[i]){  
	                    d[j] = d[j] + d[j - coins[i]];  
	                }  
	            }  
	        }  
	  
	        System.out.println(d[n]);  
	    }

}
