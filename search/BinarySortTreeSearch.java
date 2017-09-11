package algs4.search;
/**
 * 二叉查找树
 * 		一个二叉树中的每个节点都大于其左子树中任意节点的值
 * 		而小于右子树任意节点的值
 * 
 * 查找过程
 * 		传入数组参数，利用插入操作构造二叉排序树
 * 		进行比较查找
 * 		返回要查找的值所在数组位置，从1开始，未找到返回0
 * 
 * 复杂度
 * 		O(n)~O(logn)
 * 
 * @author lilingyun
 */
import java.util.Scanner;

public class BinarySortTreeSearch {
	private class TreeNode{
		private int index;
		private Comparable value;
		private TreeNode lChild,rChild;
		
		public TreeNode(int index,Comparable value){
			this.index=index;
			this.value=value;
			lChild=null;
			rChild=null;
		}
	}
		
	private TreeNode root;
	
	public void insertNode(int index,Comparable value){
		root=insertNode(root, index,value);
	}

	private TreeNode insertNode(TreeNode currentNode, int index,
			Comparable value) {
		if (currentNode==null)				return new TreeNode(index, value);;
		int cmp=value.compareTo(currentNode.value);
		if (cmp>0)									currentNode.rChild=insertNode(currentNode.rChild, index, value);
		else if(cmp<0)							currentNode.lChild=insertNode(currentNode.lChild, index, value);
		return currentNode;
	}
	
	public int search(Comparable key){
		return search(root,key)+1;
	}

	private int search(TreeNode currentNode, Comparable key) {
		if(currentNode==null)				return -1;
		int cmp=key.compareTo(currentNode.value);
		if(cmp==0) 							return currentNode.index;
		else if(cmp<0)						return search(currentNode.lChild, key);
		else 										return search(currentNode.rChild, key);
	}
	
	public BinarySortTreeSearch(Comparable[] arr) {
		for(int i=0;i<arr.length;i++)
			insertNode(i, arr[i]);
	}
	
	public static void main(String[] args) {
		Integer[] arr=new Integer[]{1,2,3,4,5,6,7};
		BinarySortTreeSearch search=new BinarySortTreeSearch(arr);

		System.out.println(search.search(new Integer(3)));
	}
}
