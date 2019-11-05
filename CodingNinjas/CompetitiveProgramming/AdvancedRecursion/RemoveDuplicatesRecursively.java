public class Solution {
	public static String removeConsecutiveDuplicates(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		StringBuilder s1 = new StringBuilder(s);
		return removeConseq(s1, 1, s1.charAt(0)).toString();
	}

	public static StringBuilder removeConseq(StringBuilder s, int idx, char last) {
		if (s.length() == idx) {
			return s;
		}

		if (s.charAt(idx) == last) {
			s.deleteCharAt(idx);
			return removeConseq(s, idx, last);
		}

		last = s.charAt(idx);
		return removeConseq(s, idx + 1, last);
	}
}
