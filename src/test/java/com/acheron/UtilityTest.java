package com.acheron;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

public class UtilityTest {
    @Test
    void multithreadingIntegerTest() throws ExecutionException, InterruptedException {
        Integer[][] matrix = new Integer[2][3];
        matrix[0]= new Integer[]{2,1,3};
        matrix[1]= new Integer[]{213,1,41};
        Utility<Integer> integerUtility = new Utility<>();
        Integer[][] sort = integerUtility.sort(matrix, Integer::compareTo);
        Assertions.assertArrayEquals(matrix[0],sort[0]);
        Assertions.assertArrayEquals(matrix[1],sort[1]);
    }
    @Test
    void defaultIntegerTest() throws ExecutionException, InterruptedException {
        Integer[][] matrix = new Integer[2][3];
        matrix[0]= new Integer[]{2,1,3};
        matrix[1]= new Integer[]{213,1,41};
        Utility<Integer> integerUtility = new Utility<>();
        Integer[][] sort = integerUtility.defaultSort(matrix, Integer::compareTo);
        Assertions.assertArrayEquals(matrix[0],sort[0]);
        Assertions.assertArrayEquals(matrix[1],sort[1]);
    }
}
