
import java.util.Scanner;
/**
 * 选择排序
 * 找到数组中最小元素，将他和数组的第一个元素交换位置
 * 在剩下的元素中找到最小元素，将他和数组的第二个元素交换位置
 * 如此反复
 * 
 * 复杂度：需要N^2/2次比较和N次交换
 * 
 * 鲜明特点:比较次数与输入无关；数据移动次数最少
 * 
 * @author lly
 *
 */
public class SelectionSort {
	public static void sort(Comparable[] a){
		for (int i = 0; i < a.length; i++) {
			int minPosition = i;
			for (int j = i+1; j < a.length; j++) {
				if (less(a[j], a[minPosition])) {
					minPosition=j;
				}
			}
			exch(a, i, minPosition);
		}
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
		SelectionSort.sort(arrayInteger);
		SelectionSort.show(arrayInteger);
	}
}
