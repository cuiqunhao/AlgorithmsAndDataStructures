package Sorts;

/**��·�ݹ�鲢�������з�Ϊ2�������У��ֱ�����������򣬵ݹ�ִ��
 * 
 * ʱ�临�Ӷ�ƽ�����:O(nlog2n)
 * 
 * �ռ临�Ӷ�����:O(n)
 * 
 * �ȶ������㷨
 */
public class MergeSort {

	
	public static void main(String args[]) {

		int a[] = { 3, 6, 4, 9, 1, 2, 5, 8, 7, 10 };

		MergeSort mergeSort = new MergeSort();
		mergeSort.getMergeSort(a);
		mergeSort.print(a);
	}

	/**
	 * �������������У��ϲ�Ϊһ����������
	 * 
	 * @param a
	 *            ����������
	 * @param low
	 *            ��һ��������ʼλ��
	 * @param mid
	 *            ��һ���������λ��
	 * @param high
	 *            �ڶ����������λ��
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
	 * �ݹ��װ
	 * @param a
	 */
	public void getMergeSort(int a[]) {
		getMergeSort(a, 0, a.length - 1);
	}

	/**
	 * �ݹ��·�鲢
	 * 
	 * @param a
	 *            ����������
	 * @param low
	 *            ����������ʼλ��
	 * @param high
	 *            �����������λ��
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
	 * �������
	 * 
	 * @param a
	 *            ���������
	 * */
	public void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

}
