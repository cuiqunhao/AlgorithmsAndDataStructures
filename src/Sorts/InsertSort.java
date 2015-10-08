package Sorts;

/**
 * 直接插入排序：将数据插入已经排序好的数组中，每一步将待排序记录插入已排序记录中适当位置
 * 
 * 时间复杂度最好情况:数组排序好，O(n)
 * 时间复杂度最坏情况:数组逆序，O(n^2)
 * 时间复杂度平局情况:O(n^2)
 * 
 * 空间复杂度:O(1)
 * 
 * 稳定排序算法
 * */
public class InsertSort {

	public static void main(String args[]) {

		int a[] = { 3,6,4,9,1,2,5,8,7,10 };	
		InsertSort insertSort=new InsertSort();
		insertSort.getInsertSort(a);
		insertSort.print(a);
	}
	/**
	 * 获得数组的直接插入排序结果
	 * @param 待排序数组
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
	
	/**输出数组
	 * @param a 待输出数组
	 * */
	public void print(int[] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}

}
