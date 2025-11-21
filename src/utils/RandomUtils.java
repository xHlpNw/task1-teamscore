package utils;

import java.util.Random;

public class RandomUtils {
    public static int[] generateRandomArray(int quantity, int min, int max) {
        return generateRandomArray(quantity, min, max, new Random());
    }

    public static int[] generateRandomArray(int quantity, int min, int max, Random rand) {
        int[] randomArray = new int[quantity];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = rand.nextInt(min, max + 1);
        }
        return randomArray;
    }
}
