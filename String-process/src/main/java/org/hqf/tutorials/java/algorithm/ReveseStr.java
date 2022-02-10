package org.hqf.tutorials.java.algorithm;

import java.util.Stack;

public class ReveseStr {

    public static void main(String[] args) {
        String str = "hello abc !";
        String reverseStr = reverseStr(str);
        System.out.println("reverseStr = " + reverseStr);
    }

    private static String reverseStr(String str) {
        if (str == null) {
            return str;
        }
        StringBuilder result = new StringBuilder();
        char[] chars = str.toCharArray();

        Stack<Character> stack = new Stack<Character>();
        boolean isNewWord;
        for (int i = 0; i < chars.length; i++) {
            char currentChar = chars[i];


            if (!Character.isWhitespace(currentChar)) {
                stack.push(currentChar);
                if (i == (chars.length - 1)) {
                    isNewWord = true;
                } else {
                    isNewWord = false;
                }
            } else {
                isNewWord = true;
            }


            if (!stack.isEmpty() && isNewWord) {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
            }
            if (Character.isWhitespace(currentChar)) {

                result.append(currentChar);
            }

        }

        return result.toString();
    }
}
