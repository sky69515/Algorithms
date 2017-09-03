package algs4.sort;
/**
 * 希尔排序
 * 让数组中任意间隔为h的元素都是有序的
 * 对每一个h，用插入排序将h个子数组独立的排序
 * 
 * 是插入排序的改进，复杂度介于O(n)~O(n^2)
 * 
 * @author lilingyun
 *
 */
public class ShellSort {
	public static void sort(Comparable[] a){
		int N=a.length;
		int h=1;
		while (h<N/3) {
			h=h*3+1;
		}
		while (h>=1) {
			for(int i=h;i<N;i++){
				for(int j=i;j>=h && less(a[j], a[j-h]);j-=h){
					exch(a, j, j-h);
				}
			}
			h=h/3;
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
		ShellSort.sort(arrayInteger);
		ShellSort.show(arrayInteger);
	}
}
