package dynamicprogramming;
/**
 * 动态规划之袋鼠过河
 * 		一只袋鼠要从河这边跳到河对岸，河很宽，但是河中间打了很多桩子，每隔一米就有一个，
 * 		每个桩子上都有一个弹簧，袋鼠跳到弹簧上就可以跳的更远。
 * 		每个弹簧力量不同，用一个数字代表它的力量，如果弹簧力量为5，就代表袋鼠下一跳最多能够跳5米，如果为0，就会陷进去无法继续跳跃。
 * 		河流一共N米宽，袋鼠初始位置就在第一个弹簧上面，要跳到最后一个弹簧之后就算过河了，
 * 		给定每个弹簧的力量，求袋鼠最少需要多少跳能够到达对岸。如果无法到达输出-1
 * 
 * 输入描述:
 * 输入分两行，第一行是数组长度N (1 ≤ N ≤ 10000)，第二行是每一项的值，用空格分隔。
 * 输出描述:
 * 输出最少的跳数，无法到达输出-1
 * 示例1
 * 输入
 * 5
 * 2 0 1 1 1
 * 输出
 * 4
 * 
 * 状态
 * 		令d[i]为跳到i米时需要的最少步数
 * 
 * 分析状态转移方程
 * 		令木桩弹簧数组为v,v[j]代表第j个弹簧的弹力
 * 		i=0时，d[0]=0
 * 		i=1时，只有从第0个弹簧开始跳，d[1]=d[0]+1,v[0]>=1
 * 		i=2时，可以从第0/1个弹簧开始跳,   d[2]=d[0]+1,v[0]>=2-0
 * 														   d[2]=d[1]+1,v[1]>=2-1
 * 														    结果为他们间的最小值
 * 		i=3时，可以从第0/1/2个弹簧开始跳，d[3]=d[0]+1,v[0]>=3-0
 * 															  d[3]=d[1]+1,v[1]>=3-1
 * 															  d[3]=d[2]+1,v[2]>=3-2
 * 															   结果为他们间的最小值
 * 
 * 总结状态转移方程
 * 		d[i]=min{d[j]+1}  v[j]>=d[j]-j
 * 
 * @author lilingyun
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class KangarooRiverCrossing {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] v=new int[n];
		int[] d=new int[n+1];
		for(int i=0;i<n;i++)	v[i]=in.nextInt();
		
		d[0]=0;
		for(int i=1;i<=n;i++){
			List<Integer> list=new ArrayList<>();
			for(int j=0;j<i;j++){
				if(v[j]>=(i-j))	list.add(d[j]+1);
			}
			if(list.size()==0){
				System.out.println(-1);
				return;
			}
			Collections.sort(list);
			d[i]=list.get(0);
		}
		System.out.println(d[n]);
	}
}
