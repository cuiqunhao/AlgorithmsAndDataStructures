package Solution;

public class Solution13 {

	public boolean isEven(int n) {

		if (n % 2 == 0)
			return true;
		else
			return false;
	}

	public void reOrderArray(int[] array) {
		if (array == null || array.length == 0)
			return;
		int low = 0;
		int high = array.length - 1;

		while (low < high) {
			if (isEven(array[low]) && isEven(array[high]))
				high--;
			else if (!isEven(array[low]) && !isEven(array[high]))
				low++;
			else if (!isEven(array[low]) && isEven(array[high])) {
				low++;
				high--;
			} else {
				int temp = array[low];
				array[low] = array[high];
				array[high] = temp;
				low++;
				high--;
			}
		}
	}
	
	public void reOrderArray1(int[] array) {
		if (array == null || array.length == 0)
			return;
		for (int i = 0; i < array.length; i++) {
			for (int j = array.length - 1; j > 0; j--) {
				if (!isEven(array[j]) && isEven(array[j-1])) {
					int temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}
			}
		}
	}

}
