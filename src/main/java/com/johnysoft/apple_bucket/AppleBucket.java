package com.johnysoft.apple_bucket;

import java.util.Arrays;

public class AppleBucket {

    public static void main(String[] args) {
        int[][] bucketsWithApples = new int[][] {
                {0,2,0,0},
                {0,3,0,0},
                {0,3,2,3},
                {0,1,0,0},
        };
        rebalance(bucketsWithApples, 4);
        System.out.println(Arrays.deepEquals(bucketsWithApples, new int[][]{{0,3,0,0},{1,0,3,1},{1,2,0,1}, {0,2,2,1}}));
    }

    private static void rebalance(int[][] bucketsWithApples, int applesToPutCount) {
        rebalance(bucketsWithApples, applesToPutCount, bucketsWithApples.length/2, bucketsWithApples.length/2);
    }

    private static void rebalance(int[][] bucketsWithApples, int applesToPutCount, int x, int y) {
        if(isOutOfBounds(bucketsWithApples.length, x) ||isOutOfBounds(bucketsWithApples.length, y)) {
            return;
        }

        for (int i = 1; i<= applesToPutCount;i++) {
            bucketsWithApples[x][y] += 1;
            if (bucketsWithApples[x][y] == 4) {
                bucketsWithApples[x][y] = 0;
                rebalance(bucketsWithApples, 1, x - 1, y);
                rebalance(bucketsWithApples, 1, x + 1, y);
                rebalance(bucketsWithApples, 1, x, y - 1);
                rebalance(bucketsWithApples, 1, x, y + 1);
            }
        }
    }

    private static boolean isOutOfBounds(int bucketSize, int x) {
        return x >= bucketSize || x < 0;
    }

}
