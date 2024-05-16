package com.acheron;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        integerTest();
        System.out.println("//");
        userTest();
    }

    private static void integerTest() throws ExecutionException, InterruptedException {
        Utility<Integer> integerUtility = new Utility<>();
        Integer[][] matrix = Utility.generateMatrix(1000, 1000);
        long time = System.currentTimeMillis();
        Integer[][] sortedMatrix = integerUtility.sort(matrix, Integer::compareTo);
        System.out.println("Multithreading sort:");
        System.out.println(System.currentTimeMillis() - time);
        long time1 = System.currentTimeMillis();
        Integer[][] integers = integerUtility.defaultSort(matrix, Integer::compareTo);
        System.out.println("Default sort:");
        System.out.println(System.currentTimeMillis() - time1);
    }
    private static void userTest() throws ExecutionException, InterruptedException {
        Utility<User> integerUtility = new Utility<>();
        User[][] matrix = new User[1000][1000];
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                matrix[i][j] = User.generateRandomUser();
            }
        }
        long time = System.currentTimeMillis();

        User[][] sortedMatrix = integerUtility.sort(matrix, (user1,user2)-> user1.getEmail().compareTo(user2.getEmail()));
        System.out.println("Multithreading sort:");
        System.out.println(System.currentTimeMillis() - time);
        long time1 = System.currentTimeMillis();
        User[][] users = integerUtility.defaultSort(matrix, (user1,user2)-> user1.getEmail().compareTo(user2.getEmail()));
        System.out.println("Default sort:");
        System.out.println(System.currentTimeMillis() - time1);
    }


}