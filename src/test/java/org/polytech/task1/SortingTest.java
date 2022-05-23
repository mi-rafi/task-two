package org.polytech.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortingTest {

    @Test
    void sortMax() {
        //given
        int[][] array = {{5, 7, 8, 9}, {100, 2, 4, 3}, {99, 98, 97, -1}};
        SortStrategy strategy = (a) -> {
            int[] maxElements = new int[a.length];
            for (int i = 0; i < a.length; i++){
                maxElements[i] = Integer.MIN_VALUE;
                for (int j = 0; j < a[0].length; j++) {
                    if (a[i][j] > maxElements[i]) {
                        maxElements[i] = a[i][j];
                    }
                }
            }
            return maxElements;
        };

        int[][] rightArray = {{5, 7, 8, 9}, {99, 98, 97, -1}, {100, 2, 4, 3}};

        //when
        Sorting.sort(array, strategy);

        //then
        for (int[] ints : array) {
            Assertions.assertArrayEquals(rightArray, array);
        }
    }

    @Test
    void sortSum() {
        //given
        int[][] array = {{5, 7, 8, 9}, {100, 2, 4, 3}, {99, 98, 97, -1}};
        SortStrategy sumSortStrategy = (a) -> {
            int[] sumElements = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[0].length; j++) {
                    sumElements[i] += a[i][j];
                }
            }
            return sumElements;
        };

        int[][] rightArray = {{5, 7, 8, 9}, {100, 2, 4, 3}, {99, 98, 97, -1}};

        //when
        Sorting.sort(array, sumSortStrategy);

        //then
        for (int[] ints : array) {
            Assertions.assertArrayEquals(rightArray, array);
        }
    }

    @Test
    void sortMin() {
        //given
        int[][] array = {{5, 7, 8, 9}, {100, 2, 4, 3}, {99, 98, 97, -1}};
        SortStrategy minSortStrategy = (a) -> {
            int[] minElements = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                minElements[i] = Integer.MAX_VALUE;
                for (int j = 0; j < a[0].length; j++) {
                    if (a[i][j] < minElements[i]) {
                        minElements[i] = a[i][j];
                    }
                }
            }
            return minElements;
        };

        int[][] rightArray = {{99, 98, 97, -1}, {100, 2, 4, 3}, {5, 7, 8, 9}};

        //when
        Sorting.sort(array, minSortStrategy);

        //then
        for (int[] ints : array) {
            Assertions.assertArrayEquals(rightArray, array);
        }
    }
}