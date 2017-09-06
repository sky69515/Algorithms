
/**
 * 堆排序
 * 		堆实际上是一棵完全二叉树
 * 		对于n个元素数组{k1，k2，…,kn}
 * 		最大化堆的定义是Ki>=K2i&&Ki>=K2i+1
 * 		定义下沉sink操作：将小于子节点的父节点顺着较大的子节点往下沉
 * 
 * 		对于一个数组，使用下沉操作可以构造一个最大化堆
 * 		在执行数组中的首尾互换，下沉；反复执行，最后得到有序数组
 * 
 * 复杂度
 * 		时间复杂度NlogN
 * 
 * @author lilingyun
 *
 */
public class HeapSort {
	
    public static void sort(Comparable[] pq) {
        int n = pq.length;
        for (int k = n/2; k >= 1; k--)
            sink(pq, k, n);
        while (n > 1) {
            exch(pq, 1, n--);
            sink(pq, 1, n);
        }
    }

    private static void sink(Comparable[] pq, int k, int n) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && less(pq, j, j+1)) j++;
            if (!less(pq, k, j)) break;
            exch(pq, k, j);
            k = j;
        }
    }

    private static boolean less(Comparable[] pq, int i, int j) {
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }

    private static void exch(Object[] pq, int i, int j) {
        Object swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }

    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args) {
    	Integer[] arrayInteger = new Integer[]{6, 5, 3, 1, 8, 7, 2, 4};
        HeapSort.sort(arrayInteger);
        show(arrayInteger);
    }
}
