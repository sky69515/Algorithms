package dynamicprogramming;
/**
 * 动态规划问题一:
 * 		如果我们有面值为1元、3元和5元的硬币若干枚，如何用最少的硬币凑够11元？
 * 
 * 子问题
 * 		如何用最少的硬币凑够i元(i<11)？
 * 
 * 状态
 * 		d[i]：凑够i元所需要的最小硬币数量
 * 
 * 状态转移分析
 * 		d(0)=0， 表示凑够0元最小需要0个硬币
 * 		当i=1时，只有面值为1元的硬币可用，d(1)=d(1-1)+1=d(0)+1=0+1=1
 * 		当i=2时， 仍然只有面值为1的硬币可用，d(2)=d(2-1)+1=d(1)+1=1+1=2
 * 		当i=3时，能用的硬币就有两种了：1元的和3元的。
 * 			添加一个1元的d(3)=d(3-1)+1=d(2)+1=2+1=3
 * 			添加一个3元的d(3)=d(3-3)+1=d(0)+1=0+1=1
 * 			选取最小的为d(3)=min{d(3-1)+1, d(3-3)+1}=1
 * 
 * 总结状态转移方程
 * 		d(i)=min{ d(i-vj)+1 }，其中i-vj >=0，vj表示第j个硬币的值
 * 
 * 
 * 
 * 
 * @author lilingyun
 */
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CoinsCharge {
	
	public static void main(String[] args) {
		int[] coins=new int[]{1,3,5};
		Scanner in=new Scanner(System.in);
		
		while (in.hasNext()) {
			int sum=in.nextInt();
			int[] arr=new int[sum+1];
			arr[0]=0;
			
			for (int i = 1; i <= sum; i++) {
				List<Integer> minNumList=new LinkedList<>();
				
				for (int j = 0; j < coins.length&&i-coins[j]>=0; j++) {
					
					minNumList.add(arr[i-coins[j]]+1);
					
				}
				
				Object[] temp=minNumList.toArray();
				Arrays.sort(temp);
				arr[i]=(int) temp[0];
			}
			
			System.out.println(arr[sum]);
		}
		
	}
	
}
