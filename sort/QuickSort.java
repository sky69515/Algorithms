
/**
 * 快速排序
 * 使用分治的思想。
 * 选择一个元素作为基准，对数组进行分区操作
 * 左边分区中的值不大于基准，右边分区中的值不小于基准，于是基准就拍好序了
 * 递归调用，其它n-1个元素也会调整到排序后的正确位置
 * 
 * 复杂度
 * 		最坏的情况是每次选取的都是最大/小值，此时的时间复杂度是O(n^2)
 * 		最好的情况是每次选取的都是中值，此时的时间复杂度是O(nlgn)
 * 
 * 改进思路
 * 		对小规模数组使用插入排序，小规模的数组会频繁调用递归方法
 * 
 * @author lilingyun
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuickSort {
	public static void sort(Comparable[] a){
		List list=Arrays.asList(a);
		Collections.shuffle(list);
		a=(Comparable[]) list.toArray();
		sort(a,0,a.length-1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi<=lo) {
			return;
		}
		int j=partition(a,lo,hi);
		sort(a, lo, j-1);
		sort(a,j+1,hi);
	}

	private static int partition(Comparable[] a, int lo, int hi) {
		int i=lo;
		int j=hi+1;
		Comparable v=a[lo];
		while(true){
			while (less(a[++i], v)) {
				if (i==hi) {
					break;
				}
			}
			while(less(v, a[--j])){
				if (j==lo) {
					break;
				}
			}
			if (i>=j) {
				break;
			}
			exch(a, lo, j);
		}
		return j;
	}

	private static boolean less(Comparable v, Comparable w){
		return v.compareTo(w)<0;
	}
	
	private static void exch(Comparable[] a,int i,int j){
		Comparable temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	
	private static void show(Comparable[] a){
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	public static boolean isSorted(Comparable[] a){
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i-1])) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Integer[] arrayInteger = new Integer[]{3,1,5,7,2,4,9,6};
		QuickSort.sort(arrayInteger);
		QuickSort.show(arrayInteger);
	}
}
