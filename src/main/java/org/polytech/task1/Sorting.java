package org.polytech.task1;

public class Sorting {
    public static void sort(int[][] value, SortStrategy strategy) {
        int [] key = strategy.sort(value);
        int temp;
        int[] tempArray;
        for (int i = 1; i < strategy.sort(value).length; i++) {
            for (int j = 0; j < key.length - i; j++) {
                if (key[j] > key[j + 1]) {
                    temp = key[j];
                    key[j] = key[j + 1];
                    key[j + 1] = temp;

                    tempArray = value[j];
                    value[j] = value[j + 1];
                    value[j + 1] = tempArray;
                }
            }
        }
    }
}
