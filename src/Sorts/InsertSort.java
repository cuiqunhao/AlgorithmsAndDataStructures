package Sorts;

/**
 * ֱ�Ӳ������򣺽����ݲ����Ѿ�����õ������У�ÿһ�����������¼�����������¼���ʵ�λ��
 * 
 * ʱ�临�Ӷ�������:��������ã�O(n)
 * ʱ�临�Ӷ�����:��������O(n^2)
 * ʱ�临�Ӷ�ƽ�����:O(n^2)
 * 
 * �ռ临�Ӷ�:O(1)
 * 
 * �ȶ������㷨
 * */
public class InsertSort {

	public static void main(String args[]) {

		int a[] = { 3,6,4,9,1,2,5,8,7,10 };	
		InsertSort insertSort=new InsertSort();
		insertSort.getInsertSort(a);
		insertSort.print(a);
	}
	/**
	 * ��������ֱ�Ӳ���������
	 * @param ����������
	 * */
	public void getInsertSort(int[] a){
		int temp=0;
		int j;
		for(int i=0;i<a.length;i++){
			j=i-1;
			temp=a[j+1];
			while(j>=0 && temp<a[j]){
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=temp;
		}
	}
	
	/**�������
	 * @param a ���������
	 * */
	public void print(int[] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}

}
