package com.johnysoft.rain;

import java.util.Arrays;


public class RainCounter {

    private static final int BLOCK = 1;

    public static void main(String[] args) {
        System.out.println(countWater(new int[]{2,3,1,1,1,5,5,3,3,7,7,2,2,2,2,2}));
    }


    public static int countWater(int[] structure) {
        int totalWater = 0;
        int[][] area = buildArea(structure);
        for (int i = 0; i< area[0].length;i++) {
            int block = -1;
            for (int j = 0;j<area.length;j++){
                if (area[j][i] > 0) {
                    if(block == -1) {
                        block = j;
                    } else {
                        totalWater += (j - (block+1));
                        block = j;
                    }
                }
            }
        }
        return totalWater;
    }


    private static int[][] buildArea(int[] structure) {
        int height = Arrays.stream(structure).max().getAsInt();
        int[][] area = new int[structure.length][height];
        for (int i = 0;i<structure.length;i++) {
            for (int j = 0;j< structure[i];j++) {
                area[i][j] = BLOCK;
            }
        }

        return area;
    }
}
