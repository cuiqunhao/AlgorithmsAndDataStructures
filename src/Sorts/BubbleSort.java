package Sorts;
/**
 * 冒泡排序：比较相邻的元素。如果第一个比第二个大，就交换他们两个
 * 
 * 时间复杂度最好情况:数组排序好，O(n)
 * 时间复杂度最坏情况:数组逆序，O(n^2) 
 * 时间复杂度平局情况:O(n^2)
 * 
 * 空间复杂度:O(1)
 * 
 * 稳定排序算法
 */
public class BubbleSort {
	
	public static void main(String args[]) {
		int a[] = { 3, 6, 4, 9, 1, 2, 5, 8, 7, 10 };
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.getBubbleSort(a);
		bubbleSort.print(a);
	}

	/**
	 * 获得数组的冒泡排序
	 * 
	 * @param a
	 *            待输出数组
	 */
	public void getBubbleSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = a.length - 1; j > i; j--) {
				if (a[j - 1] > a[j]) {
					int temp = a[j - 1];
					a[j - 1] = a[j];
					a[j] = temp;
				}
			}
		}
	}

	/**
	 * 输出数组
	 * 
	 * @param a
	 *            待输出数组
	 * */
	public void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

}
