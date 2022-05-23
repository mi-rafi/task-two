package org.polytech.task1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {


        int[][] array = {{5, 7, 8, 9}, {100, 2, 4, 3}, {99, 98, 97, -1}};

        //Максимальный элемент
        SortStrategy maxSortStrategy = (a) -> {
            int[] maxElements = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                maxElements[i] = Integer.MIN_VALUE;
                for (int j = 0; j < a[0].length; j++) {
                    if (a[i][j] > maxElements[i]) {
                        maxElements[i] = a[i][j];
                    }
                }
            }
            return maxElements;
        };
        SortStrategy sumSortStrategy = (a) -> {
            int[] sumElements = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[0].length; j++) {
                    sumElements[i] += a[i][j];
                }
            }
            return sumElements;
        };

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

        System.out.println("Choose the sorting method\n" +
                "1 - max element\n" +
                "2 - min element\n" +
                "3 - sum elements");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                Sorting.sort(array, maxSortStrategy);
                System.out.println("***********************\n" +
                        "Max element");
                for (int[] value : array) {
                    System.out.println(Arrays.toString(value));
                }
                break;
            case 2:
                Sorting.sort(array, minSortStrategy);
                System.out.println("***********************\n" +
                        "Min element");
                for (int[] value : array) {
                    System.out.println(Arrays.toString(value));
                }
                break;
            case 3:
                Sorting.sort(array, sumSortStrategy);
                System.out.println("***********************\n" +
                        "Sum elements");
                for (int[] value : array) {
                    System.out.println(Arrays.toString(value));
                }
                break;
            default:
                System.out.println("Error");
        }

        

    }
}
