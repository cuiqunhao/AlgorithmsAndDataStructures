package Sorts;

/**
 * ѡ���������α���δ����������Сֵ������Сֵ�ŵ������������
 * 
 * ʱ�临�Ӷ�������:��������ã�O(n^2) 
 * ʱ�临�Ӷ�����:��������O(n^2)
 *  ʱ�临�Ӷ�ƽ�����:O(n^2)
 * 
 * �ռ临�Ӷ�:O(1)
 * 
 * ���ȶ������㷨��2��2��1��
 */
public class SelectSort {

	public static void main(String args[]) {
		int a[] = { 3, 6, 4, 9, 1, 2, 5, 8, 7, 10 };
		SelectSort selectSort = new SelectSort();
		selectSort.getSelectSort(a);
		selectSort.print(a);
	}

	/**
	 * ��������ѡ������
	 * 
	 * @param a
	 *            ����������
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
