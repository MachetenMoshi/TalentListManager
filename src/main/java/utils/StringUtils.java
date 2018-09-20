package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class StringUtils {
	public static boolean isInteger(String s) {
		return isInteger(s, 10);
	}

	public static boolean isInteger(String s, int radix) {
		if (s.isEmpty())
			return false;
		for (int i = 0; i < s.length(); i++) {
			if (i == 0 && s.charAt(i) == '-') {
				if (s.length() == 1)
					return false;
				else
					continue;
			}
			if (Character.digit(s.charAt(i), radix) < 0)
				return false;
		}
		return true;
	}

	public static Integer parseToInt(String var) {
		if (var != null && !var.isEmpty()) {
			String digits = var.replaceAll("[^0-9]", "");
			if (!digits.isEmpty()) {
				return Integer.parseInt(digits);
			}
		}
		return null;
	}

	public static List<String> splitOnWhitespaces(String value) {
		return Arrays.asList(value.trim().split("\\s+"));
	}

	public static List<String> splitOnSemicolon(String value) {
		return Arrays.asList(value.trim().split(";", -1));
	}

	public static List<String> splitOnBraces(String value) {
		return Arrays.asList(value.trim().split("[\\(||\\)]"));
	}

	public static String removeAllNonDigits(String value) {
		return value.replaceAll("[^0-9]", "");
	}

	public static boolean isNullOrEmpty(String value) {
		return value == null || value.isEmpty();
	}

	public static StringBuffer getContent(InputStreamReader inputStreamReader) {
		BufferedReader in = new BufferedReader(inputStreamReader);
		String inputLine;
		StringBuffer content = new StringBuffer();
		try {
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			in.close();
		} catch (IOException e) {
			if (in != null)
				try {
					in.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			e.printStackTrace();
		}
		return content;
	}
}
