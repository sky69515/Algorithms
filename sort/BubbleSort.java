
/**
 * 非降序冒泡排序算法
 * 		比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 		对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
 * 		针对所有的元素重复以上的步骤，除了最后一个。
 * 		持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 * 
 * 复杂度分析
 * 		其外层循环执行 N - 1次。(说法有问题,应该分为比较和交换的次数)内层循环最多的时候执行N次，最少的时候执行1次，平均执行 (N+1)/2次。
 * 		所以循环体内的比较交换约执行 (N - 1)(N + 1) / 2 = (N^2 - 1)/2。按照计算复杂度的原则，去掉常数，去掉最高项系数，其复杂度为O(N^2)。
 * 	
 * 鲜明特点:比较次数与输入无关
 * 
 * 改进思路:鸡尾酒排序
 * 	
 * @author lilingyun
 *
 */
public class BubbleSort {
	/**
	 * 针对所有实现Comparable元素的排序
	 * @param a	需要排序的数组
	 */
	public static void sort(Comparable[] a){
		for (int i = 0; i < a.length-1; i++) {
			for (int j = 0; j < a.length-i-1; j++) {
				if (less(a[j+1], a[j])) {
					exch(a, j, j+1);
				}
			}
		}
	}
	/**
	 * 比较两个元素大小
	 * @param v	元素1
	 * @param w	元素2
	 * @return	v>w?
	 */
	private static boolean less(Comparable v, Comparable w){
		return v.compareTo(w)<0;
	}
	/**
	 * 交换数组中指定位置的两个元素
	 * @param a	数组
	 * @param i	元素1的位置
	 * @param j	元素2的位置
	 */
	private static void exch(Comparable[] a,int i,int j){
		Comparable temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	/**
	 * 打印数组
	 * @param a	数组
	 */
	private static void show(Comparable[] a){
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	
	public static void main(String[] args) {
		Integer[] arrayInteger = new Integer[]{6, 5, 3, 1, 8, 7, 2, 4};
		System.out.println(BubbleSort.isSorted(arrayInteger));
		BubbleSort.sort(arrayInteger);
		BubbleSort.show(arrayInteger);
		System.out.println(BubbleSort.isSorted(arrayInteger));
	}
}
