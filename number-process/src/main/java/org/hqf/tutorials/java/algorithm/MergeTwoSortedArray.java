package org.hqf.tutorials.java.algorithm;

public class MergeTwoSortedArray {

    public static void main(String[] args) {
        int[] numsA = new int[]{1, 3, 5, 7};
        int[] numsB = new int[]{2, 4, 6, 8};
        int[] numsC = mergeSortedArray(numsA, numsB);

        System.out.println("numsC = " );
        for (int i = 0; i < numsC.length; i++) {
            System.out.print( numsC[i]);
        }

        System.out.println();

    }

    private static int[] mergeSortedArray(int[] numsA, int[] numsB) {

        int[] numsC = new int[numsA.length + numsB.length];
        int index = 0;
        int j = 0;
        int i = 0;
        while (i < numsA.length) {

            while (j < numsB.length) {
                if (i < numsA.length && numsA[i] <= numsB[j]) {
                    numsC[index] = numsA[i];
                    i += 1;
                } else if (j < numsB.length) {
                    numsC[index] = numsB[j];
                    j += 1;
                }
                index += 1;
            }

        }

        return numsC;

    }
}
