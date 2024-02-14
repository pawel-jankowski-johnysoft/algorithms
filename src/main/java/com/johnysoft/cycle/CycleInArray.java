package com.johnysoft.cycle;

import java.util.HashSet;
import java.util.Set;

public class CycleInArray {
    private CycleInArray(){}


    public static void main(String[] args) {
        System.out.println(hoopsForCycle(new int[]{1,2,0}, 0));
        System.out.println(hoopsForCycle(new int[]{1,2,3}, 0));
        System.out.println(hoopsForCycle(new int[]{1,2,0,5}, 0));
        System.out.println(hoopsForCycle(new int[]{1,2,0,0}, 3));
        System.out.println(hoopsForCycle(new int[]{1,2,0,0}, 4));
    }
    /*
     *
     * hoopsForCycle({1,2,0}, 0) = 3
     * hoopsForCycle({1,2,3}, 0) = -1
     * hoopsForCycle({1,2,0,5}, 0) = 3
     *
     *
     *
     * */

    public static int hoopsForCycle(int[] elems, int startIndex) {
        Set<Integer> visited = new HashSet<>();
        int hops = 0;
        int current = startIndex;
        while (true) {
            if(!visited.add(current)) {
                return hops;
            }

            hops++;

            if (current >= elems.length) {
                break;
            }
            current = elems[current];
        }

        return -1;
    }
}
