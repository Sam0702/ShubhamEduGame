package com.jc897407.ShubhamEduApp.helper;

import java.util.Random;

public class Utility {
    //shuffle the int array elements

    public static void shuffleIntArray(int[] intArray) {

        Random random = new Random();
        int temp_index;
        int temp_obj;
        for (int i = 0; i < intArray.length - 1; i++) {
            //a random number between i+1 and intArray.length - 1
            temp_index = i + 1 + random.nextInt(intArray.length - 1 - i);
            //swap the element at i with the element at temp_index
            temp_obj = intArray[i];
            intArray[i] = intArray[temp_index];
            intArray[temp_index] = temp_obj;
        }
    }
}
