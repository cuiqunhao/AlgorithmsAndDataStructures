package Sorts;

/**
 * 选择排序：依次遍历未排序数组最小值，将最小值放到以排序数组后
 * 
 * 时间复杂度最好情况:数组排序好，O(n^2) 
 * 时间复杂度最坏情况:数组逆序，O(n^2)
 *  时间复杂度平局情况:O(n^2)
 * 
 * 空间复杂度:O(1)
 * 
 * 不稳定排序算法｛2，2，1｝
 */
public class SelectSort {

	public static void main(String args[]) {
		int a[] = { 3, 6, 4, 9, 1, 2, 5, 8, 7, 10 };
		SelectSort selectSort = new SelectSort();
		selectSort.getSelectSort(a);
		selectSort.print(a);
	}

	/**
	 * 获得数组的选择排序
	 * 
	 * @param a
	 *            待排序数组
	 */
	public void getSelectSort(int[] a) {
		int min = 0, temp = 0;
		for (int i = 0; i < a.length; i++) {
			min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[min] > a[j]) {
					min = j;
				}
			}
			if (min != i) {
				temp = a[min];
				a[min] = a[i];
				a[i] = temp;
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
