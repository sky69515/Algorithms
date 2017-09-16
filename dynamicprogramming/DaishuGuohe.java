package niuketest;

import java.util.Scanner;

public class DaishuGuohe {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		while (in.hasNext()) {
			int n=in.nextInt();
			int[] arr=new int[n+1];
			for (int i = 1; i < arr.length; i++) {
				arr[i]=in.nextInt();
			}
			
			int nextIndex=1;
			int result=0;
			while (nextIndex<=n) {
				if (arr[nextIndex]==0) {
					System.out.println(-1);
					return;
				}
				nextIndex+=arr[nextIndex];
				result++;
			}
			System.out.println(result);
 		}
	}
}
