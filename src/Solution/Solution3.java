package Solution;

public class Solution3 {

	/***
	 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
	 * 请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
	 * 
	 * @param str
	 * @param n
	 * @return
	 */
	public String LeftRotateString(String str, int n) {
		if ((str.equals("") || str == null) && str.length() < n)
			return "";
		int length = str.length();
		str += str;
		return str.substring(n, n + length);
	}

	public static void main(String args[]) {
		Solution3 solution3 = new Solution3();
		System.out.println(solution3.LeftRotateString("abcdefg", 2));
	}
}
