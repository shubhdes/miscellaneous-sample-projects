package com.algorithms;

public class ExcelColumnNameToColumnNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(find("ZY"));
	}

	public static long find(String input) {
		long result = 0;
		for (int i = 0; i < input.length(); i++) {
			result = result * 26;
			result = result + input.charAt(i) - 'A' + 1;
		}
		return result;
	}
}
