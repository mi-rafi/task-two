package org.polytech.task1;

import java.util.Arrays;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {


        int[][] array = {{5, 7, 8, 9}, {100, 2, 4, 3}, {99, 98, 97, -1}};

        //Максимальный элемент
        Sorting.sort(array, (a) -> {
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
        });

        System.out.println("***********************\n" +
                "Max element");
        for (int[] value : array) {
            System.out.println(Arrays.toString(value));
        }

        //Минимальный элемент
        Sorting.sort(array, (a) -> {
            int[] minElements = new int[a.length];
            for (int i = 0; i < a.length; i++){
                minElements[i] = Integer.MAX_VALUE;
                for (int j = 0; j < a[0].length; j++) {
                    if (a[i][j] < minElements[i]) {
                        minElements[i] = a[i][j];
                    }
                }
            }
            return minElements;
        });

        System.out.println("***********************\n" +
                "Min element");
        for (int[] ints : array) {
            System.out.println(Arrays.toString(ints));
        }

        //Сумма
        Sorting.sort(array, (a) -> {
            int[] sumElements = new int[a.length];
            for (int i = 0; i < a.length; i++){
                for (int j = 0; j < a[0].length; j++) {
                    sumElements[i] += a[i][j];
                }
            }
            return sumElements;
        });

        System.out.println("***********************\n" +
                "Sum");
        for (int[] ints : array) {
            System.out.println(Arrays.toString(ints));
        }

    }

    public static int sum(Supplier<Integer> supplier, int a){
        return supplier.get() + a;
    }
}
