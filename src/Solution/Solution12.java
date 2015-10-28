package Solution;

public class Solution12 {

	public int NumberOf1(int n) {
		int count = 0;
		while (n != 0) {
			++count;
			n = n & (n - 1);
		}
		return count;
	}

	public boolean isEven0(int n) {

		if (n % 2 == 0)
			return true;
		else
			return false;
	}

	public boolean isEven2(int n) {
		int x = n & 1;

		if (x == 0)
			return true;
		else
			return false;
	}

	public boolean isEven1(Object n) {

		Integer integer = 0;
		if (integer instanceof Integer) {
			integer = (Integer) n;
			String paString = integer + "";
			char bit = paString.charAt(paString.length() - 1);
			switch (bit) {
			case '0':
			case '2':
			case '4':
			case '6':
			case '8':
				return true;
			}
			return false;

		} else {

			return false;
		}
	}

}
