package org.hqf.tutorials.java.algorithm;

public class SubStr {

    public static void main(String[] args) {
        int result = getLongestSubstring("abcabcebb");
        System.out.println("result = " + result);
    }

    public static int getLongestSubstring(String s) {
        int length = s.length();
        char[] chars = s.toCharArray();
        if (length == 0) {
            return 0;
        }

        int[] freq = new int[256];
        int result = 0;
        int left = 0;
        int right = -1;

        while (left < length) {
            if ((right + 1 < length)
                    && (freq[chars[right + 1] - 'a'] == 0)) {
                freq[chars[right + 1] - 'a']++;
                right++;
            } else {
                freq[chars[left] - 'a']--;
                left++;
            }
            result = max(result, right - left + 1);
        }
        return result;
    }

    public static int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }
}
