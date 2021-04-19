package myr.vsem;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Mykola Myroshnychenko
 * @version 1.0.0
 * @project finalTesting
 * @class Duplicates
 * @since 19.04.2021 - 18.55
 */


public class Duplicates {
    public  static  boolean hasDuplicates(int[] array){
        Arrays.sort(array);
        //  your code is here


        int number = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (array[i] == number) {
                return true;
            }
            number = array[i];
        }
        return  false;
    }

    public static void main(String[] args) {
        int[] array = {1,5,3,6,2,9,33,21};
        System.out.println(hasDuplicates(array));  // false
        array[5] = 1;
        System.out.println(hasDuplicates(array)); // true
    }
}
/*
This method allows you to check for duplicates in the array.
Result:
false
true
 */