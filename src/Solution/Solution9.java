package Solution;

public class Solution9 {
	public String replaceSpace(StringBuffer str) {
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {

			if (str.charAt(i) == ' ')
				stringBuffer.append("%20");
			else
				stringBuffer.append(str.charAt(i));
		}

		return stringBuffer.toString();
	}
}
