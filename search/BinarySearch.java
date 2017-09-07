

import java.util.Scanner;

/**
 * 二分查找
 * 		又称折半查找，前提要求数据序列必须是经过排序的。
 * 
 * 基本思路：
 *		在一组有序序列中，取中间值与给定关键字进行比较
 *		如果给定关键字大于该值关键字，则要查找的关键字位于有序序列的后半部分；
 *		若给定小于该值，则要查找的关键字位于有序序列的前半部分。
 *		每次将有序序列的长度缩小一半之后，再从中间位置的记录进行比较，依次反复进行。
 *		找到给定值，返回给定值在序列中的位置
 *		若给定值无法找到，返回0
 *
 *	时间复杂度为O(logn)
 *
 *	优化：
 *	可以用
 *	int mid = left - （left - right）/2; //防止越界
 *	或
 *	int mid = left&right+(left^right)>>1;//进行计算机最喜欢的位运算，效率略高
 *	来代替  求两个数的平均值的操作
 * 
 * 
 * @author lenovo
 *
 */
public class BinarySearch {
	public static int search(Comparable[] a,Comparable k){
		return search(a, k,0,a.length-1)+1;
	}

	private static int search(Comparable[] a, Comparable k, int lo, int hi) {
//		if (hi<lo) {
//			return -1;
//		}
//		int mid=(lo+hi)/2;
//		if (a[mid].compareTo(k)==0) {
//			return mid;
//		}else if (a[mid].compareTo(k)<0) {
//			return search(a, k, mid+1, hi);
//		}else {
//			return search(a, k, lo, mid-1);
//		}
		while (lo<=hi) {
			int mid=(lo+hi)/2;
			if (a[mid].compareTo(k)==0) 		return mid;
			else if (k.compareTo(a[mid])>0)	lo=mid+1;
			else 											hi=mid-1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Integer[] arrayInteger = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
		Scanner in=new Scanner(System.in);
		while (in.hasNext()) {
			Integer k=in.nextInt();
			System.out.println(search(arrayInteger, k));
		}
	}
}
