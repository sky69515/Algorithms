package algs4.sort;
/**
 * 归并排序
 * 先分解再合并
 * 分解：每次将数组折半分解
 * 合并：将划分后的数组两两合并，并在合并过程中排序
 * 
 * 复杂度
 * 		时间复杂度为O(nlgn)
 * 		空间复杂度为O(n)
 * 
 * 改进思路
 * 		对小规模数组使用插入排序，递归会使小规模问题频繁调用方法
 * 		判断子数组是否有序，在merge方法前添加判断条件a[mid]>a[mid+1]才执行merge
 * 
 * 
 * @author lilingyun
 *
 */
public class MergeSort {
	
	private static Comparable[] aux;
	//自顶向下
	public static void sort(Comparable[] a){
		aux=new Comparable[a.length];
		sort(a,0,a.length-1);
	}
	
	public static void sortBU(Comparable[] a){
		int N=a.length;
		aux=new Comparable[a.length];
		for (int sz = 1; sz < N; sz=sz+sz) {
			for (int lo = 0; lo < N-sz; lo+=sz+sz) {
				merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
			}
		}
	}
	
	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi<=lo) {
			return;
		}
		int mid=lo+(hi-lo)/2;
		sort(a, lo, mid);
		sort(a, mid+1, hi);
		merge(a, lo, mid, hi);
	}


	public void setAux(Comparable[] aux) {
		this.aux=new Comparable[aux.length];
	}
	
	public static void merge(Comparable[] a,int lo,int mid,int hi){
		int i=lo;
		int j=mid+1;
		
		for (int k = lo; k <= hi; k++) {
			aux[k]=a[k];
		}
		
		for (int k = lo; k <= hi; k++) {
			if (i>mid) {
				a[k]=aux[j++];
			}else if (j>hi) {
				a[k]=aux[i++];
			}else if (less(aux[j], aux[i])) {
				a[k]=aux[j++];
			}else {
				a[k]=aux[i++];
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
		Integer[] aStrings={3,3,4,5,6,1,2,3,6,7};
		MergeSort.sort(aStrings);
		MergeSort.show(aStrings);
	}
}
