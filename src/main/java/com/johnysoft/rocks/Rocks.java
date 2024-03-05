package com.johnysoft.rocks;

public class Rocks {

    public static void main(String[] args) {
        int[][] trace = {{0, 0, 0, 0, 5}, {0, 1, 1, 1, 0}, {2, 0, 0, 0, 0}};
        System.out.println(collectRocks(trace));
    }

    public static int collectRocks(int[][] trace) {
        int xPosition = 0;
        int yPosition = trace.length - 1;
        int endXPosition = trace[0].length - 1;
        int endYPosition = 0;
        int sum = trace[yPosition][xPosition];

        while (xPosition < endXPosition && yPosition > endYPosition) {
            if (trace[yPosition - 1][xPosition] > trace[yPosition][xPosition + 1]) {
                sum += trace[--yPosition][xPosition];
            } else {
                sum += trace[yPosition][++xPosition];
            }
        }

        if (xPosition < endXPosition) {
            while (xPosition < endXPosition) sum += trace[yPosition][++xPosition];
        }

        if (yPosition > endYPosition) {
            while (yPosition > endYPosition) sum += trace[--yPosition][xPosition];
        }

        return sum;
    }

}

