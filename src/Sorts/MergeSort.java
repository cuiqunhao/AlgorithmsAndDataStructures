package Sorts;

/**二路递归归并：将序列分为2个子序列，分别对子序列排序，递归执行
 * 
 * 时间复杂度平均情况:O(nlog2n)
 * 
 * 空间复杂度最坏情况:O(n)
 * 
 * 稳定排序算法
 */
public class MergeSort {

	
	public static void main(String args[]) {

		int a[] = { 3, 6, 4, 9, 1, 2, 5, 8, 7, 10 };

		MergeSort mergeSort = new MergeSort();
		mergeSort.getMergeSort(a);
		mergeSort.print(a);
	}

	/**
	 * 两个有序子序列，合并为一个有序序列
	 * 
	 * @param a
	 *            待排序数组
	 * @param low
	 *            第一个子序起始位置
	 * @param mid
	 *            第一个子序结束位置
	 * @param high
	 *            第二个子序结束位置
	 */
	public void Merge(int a[], int low, int mid, int high) {
		int[] a_temp = new int[a.length];
		for (int index = 0; index < a.length; index++) {
			a_temp[index] = a[index];
		}
		int i, j, k;
		for (i = low, j = mid + 1, k = i; i <= mid && j <= high; k++) {
			if (a_temp[i] > a_temp[j])
				a[k] = a_temp[j++];
			else
				a[k] = a_temp[i++];
		}
		while (i <= mid)
			a[k++] = a_temp[i++];
		while (j <= high)
			a[k++] = a_temp[j++];
	}

	/**
	 * 递归封装
	 * @param a
	 */
	public void getMergeSort(int a[]) {
		getMergeSort(a, 0, a.length - 1);
	}

	/**
	 * 递归二路归并
	 * 
	 * @param a
	 *            待排序数组
	 * @param low
	 *            排序数组起始位置
	 * @param high
	 *            排序数组结束位置
	 */
	public void getMergeSort(int a[], int low, int high) {
		if (low >= high) {
			return;
		}
		int mid = (low + high) / 2;
		getMergeSort(a, low, mid);
		getMergeSort(a, mid + 1, high);
		Merge(a, low, mid, high);
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
