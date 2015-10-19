package Solution;

public class Solution3 {

	/***
	 * �����������һ����λָ�����ѭ�����ƣ�ROL���������и��򵥵����񣬾������ַ���ģ�����ָ���������������һ���������ַ�����S��
	 * �������ѭ������Kλ���������������磬�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ��������XYZdefabc����
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
