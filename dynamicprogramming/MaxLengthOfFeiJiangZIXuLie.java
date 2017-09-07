package dynamicprogramming;
/**
 * 动态规划问题二：最长非降序子序列
 * 		一个序列有N个数：A[1],A[2],…,A[N]，求出最长非降子序列的长度。
 * 
 * 状态:d[i]，表示前i个数中以A[i]结尾的最长非降子序列的长度。
 * 
 * 根据上面找到的状态，我们可以得到：（下文的最长非降子序列都用LIS表示）
 * 		前1个数的LIS长度d(1)=1(序列：5)
 * 		前2个数的LIS长度d(2)=1(序列：3；3前面没有比3小的)
 * 		前3个数的LIS长度d(3)=2(序列：3，4；4前面有个比它小的3，所以d(3)=d(2)+1)
 * 		前4个数的LIS长度d(4)=3(序列：3，4，8；8前面比它小的有3个数，所以 d(4)=max{d(1),d(2),d(3)}+1=3)
 * 
 * 
 * 总结状态转移方程:    d[i] = d[i-1]+1  	A[i-1]<=A[i]
 * 						    	  d[i]=1				A[i-1]>A[i]
 * 
 * 最后结果：max{d[1]...d[N]}
 * 
 * @author lilingyun
 */
import java.util.Arrays;

public class MaxLengthOfFeiJiangZIXuLie {
	
	public static int getLength(Comparable[] arr){
		int[] d=new int[arr.length];
		d[0]=1;
		for(int i=1;i<arr.length;i++){
			if(less(arr[i],arr[i-1])) d[i]=d[i-1]+1;
			else d[i]=1;
		}
		Arrays.sort(d);
		return d[arr.length-1];
	}
	
	private static boolean less(Comparable v, Comparable u) {
		return v.compareTo(u)>=0;
	}

	public static void main(String[] args) {
		Integer[] arr={5,3,4,8,6,7};
//		Integer[] arr={5,4,4,8,6,7};
//		Integer[] arr={5,3,4,,88,6,7};
		System.out.println(getLength(arr));
		
	}
}
