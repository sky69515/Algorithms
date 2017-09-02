package algs4.sort;
/**
 * 插入排序
 * 在已排序序列中从后向前扫描，找到相应位置插入
 * 
 * 复杂度
 * 		最坏情况下需要N^2/2次比较，N^2/2次交换
 * 
 * @author lly
 *
 */
public class InsertionSort {
	public static void sort(Comparable[] a){
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
				exch(a, j, j-1);
			}
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
		InsertionSort.sort(arrayInteger);
		InsertionSort.show(arrayInteger);
	}
}
