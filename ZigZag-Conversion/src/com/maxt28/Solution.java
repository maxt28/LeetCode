package com.maxt28;

public class Solution {
    public String convert(String s, int numRows) {
        String[] stringArray = new String[numRows];
        String result = "";
        int space = (2 * numRows - 2);
        if (s.length() <= numRows || numRows == 1) {
            return s;
        }
        for (int row = 0; row < numRows; row++) {
            stringArray[row] = "";
            stringArray[row] += s.charAt(row);
            for (int index = space; index - row < s.length(); index += space) {
                if (row != 0 && (row != numRows - 1)) {
                    stringArray[row] += s.charAt(index - row);
                }
                if (index + row < s.length()) {
                    stringArray[row] += s.charAt(index + row);
                }
            }
            result += stringArray[row];
        }
        return result;
    }
}
