package org.hqf.tutorials.java.algorithm;

import java.util.HashSet;
import java.util.Set;

public class SubStr {

    public static void main(String[] args) {
        String str = "abcabcebb";
        int result = getLongestSubstring(str);
        System.out.println("result = " + result);

        int subStrLength = getLengthOfLongestSubstring(str);
        System.out.println("subStrLength = " + subStrLength);

    }

    /**
     * 获取最长不重复子串的长度
     *
     * @param s
     * @return
     */
    public static int getLengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int count = s.length();
        int right = -1, subLength = 0;
        for (int left = 0; left < count; ++left) {

            if (left != 0) {
                set.remove(s.charAt(left - 1));
            }

            while (right + 1 < count
                    && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                ++right;
            }

            subLength = Math.max(subLength, right - left + 1);
        }
        return subLength;
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
