package Solution;

public class Solution4 {

	/**
	 * �ж��˿����е�˳��
	 * 
	 * @param numbers
	 * @return
	 */
	public boolean isContinuous(int[] numbers) {
		if (numbers.length == 0 || numbers == null)
			return false;
		
		//����չ����

		int ZeroCount = 0;
		int BankCount = 0;
		for (int i = 0; i < numbers.length && numbers[i] == 0; i++) {//ͳ����ĸ���
			ZeroCount++;
		}

		for (int i = 0; i < numbers.length - 1; i++) {
			if (numbers[i] != 0 && numbers[i + 1] != 0) {
				BankCount += (numbers[i + 1] - numbers[i] - 1);
				if (numbers[i] == numbers[i + 1])//���Ӷ���
					return false;
			}
		}

		if (ZeroCount >= BankCount)
			return true;
		else
			return false;
	}

	public static void main(String args[]) {
		int[] arry = { 0, 0, 0, 2, 2, 3, 4, 5, 10 };

		System.out.println(new Solution4().isContinuous(arry));
	}

}
