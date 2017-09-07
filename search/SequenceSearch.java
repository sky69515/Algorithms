

import java.util.Scanner;

/**
 * 顺序查找
 * 		从表的一端开始，顺序扫描线性表
 * 		依次将扫描到的关键字与给定值比较
 * 		若相等，则查找成功，返回给定值是数组中的第几个数
 * 		若扫描结束，仍未发现相等的值，则查找失败，返回0
 * 
 * 时间复杂度：
 *          顺序查找平均关键字匹配次数为表长的一半，其时间复杂度为O(n)。
 *          
 *顺序查找的评估：
 *          顺序查找的优点是对表无要求，插入数据可在O(1)内完成。缺点是时间复杂度较大，数据规模较大时，效率较低。
 * 
 * @author lilingyun
 *
 */
public class SequenceSearch {
	public static int search(Comparable[] a,Comparable k){
		for(int i=0;i<a.length;i++){
			if (a[i].compareTo(k)==0) {
				return i+1;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		Integer[] arrayInteger = new Integer[]{6, 5, 3, 1, 8, 7, 2, 4};
		Scanner in=new Scanner(System.in);
		while (in.hasNext()) {
			Integer k=in.nextInt();
			System.out.println(search(arrayInteger, k));
		}
	}
}
