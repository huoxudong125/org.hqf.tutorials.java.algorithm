package org.hqf.tutorials.java.algorithm;

/**
 * 倒转字符串
 *
 * @author Frank
 */
public class ReverseNumber {

    public static void main(String[] args) {
        int x = 789123;
        int num = reverseNum(x);
        System.out.println("num = " + num);

    }

    /**
     * Reverse Numbers
     *
     * @param originNum
     * @return
     */
    public static int reverseNum(int originNum) {
        int result = 0;
        while (originNum != 0) {
            result = (result * 10) + (originNum % 10);
            originNum = originNum / 10;
        }

        //可选，不是算法的核心
        if (result > 1 << 31 - 1 || result < -(1 << 31)) {
            throw new RuntimeException();
        }
        return result;
    }
}
