package myr.vsem;

/**
 * @author Mykola Myroshnychenko
 * @version 1.0.0
 * @project finalTesting
 * @class Prefix
 * @since 19.04.2021 - 18.48
 */
public class Prefix {

    public static String prefix(String[] array) {
        // your code is here

        String longestPrefix = "";
        if (array.length > 0) {
            longestPrefix = array[0];
        }
        for (int i = 1; i < array.length; i++) {
            String analyzing = array[i];
            int j = 0;
            for (; j < Math.min(longestPrefix.length(), array[i].length()); j++) {
                if (longestPrefix.charAt(j) != analyzing.charAt(j)) {
                    break;
                }
            }
            longestPrefix = array[i].substring(0, j);
        }
        return longestPrefix;
    }

    public static void main(String[] args) {
        String[] array = {"abc", "abcd", "abfce", "abcac"} ;

        System.out.println(prefix(array));  // ab

        String[] array2 = {"abc", "abcd", "abce", "abcac"} ;

        System.out.println(prefix(array2)); // abc
    }
}
/*
This method allows you to find a common prefix among words.
Result:
ab
abc
 */