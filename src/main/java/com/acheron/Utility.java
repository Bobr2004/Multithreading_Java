package com.acheron;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.*;

public class Utility<T> {
    public T[][] sort(T[][] array, Comparator<T> comparator) throws ExecutionException, InterruptedException {
        try (ExecutorService executorService = Executors.newFixedThreadPool(2)) {
            CompletableFuture<Void>[] futures = new CompletableFuture[array.length];
            for (int i = 0; i < array.length; i++) {
                int finalI = i;
                futures[i] = CompletableFuture.supplyAsync(() -> Arrays.stream(array[finalI]).sorted(comparator).toArray(), executorService)
                        .thenApply(sortedArray -> {
                            array[finalI] = (T[]) Arrays.copyOf(sortedArray, sortedArray.length, array[0].getClass());
                            return null;
                        });
            }
            CompletableFuture.allOf(futures).join();
        }
        return array;
    }
    public T[][] defaultSort(T[][] array, Comparator<T> comparator) throws ExecutionException, InterruptedException {
        for (int i = 0; i < array.length; i++) {
            Object[] sortedArray = Arrays.stream(array[i]).sorted(comparator).toArray();
            array[i] = (T[]) Arrays.copyOf(sortedArray, sortedArray.length, array[i].getClass());
        }
        Thread.sleep(110);
        return array;
    }

    public static Integer[][] generateMatrix(int rows, int cols) {
        Integer[][] matrix = new Integer[rows][cols];
        Random rand = new Random();


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(100);
            }
        }

        return matrix;
    }


}
