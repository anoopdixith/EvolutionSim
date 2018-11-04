package Utility;

import java.util.*;

/**
 */
public class Utilities {
    public static String getDNASequence(int length) {
        return randomString(length, false, false, true);
    }

    public static String randomString(int length) {
        if (length == 0)
            return "";
        return randomString(length, false, false, false);
    }

    public static String randomString(int length, boolean onlyAlphabets, boolean onlyNumbers,
                               boolean onlyAlphaNumeric) {
        char[] randomString = new char[length];
        int asciiBeg = 32, asciiEnd = 126, blockBeg = 58, blockEnd = 96;
        boolean blockEnable = false;
        // if the user has, may be by mistake, chosen true for both "onlylphabets" and
        // "onlyNumbers", then make onlyAlphaNumeric to be true even if it is false.
        if (onlyAlphabets && onlyNumbers) {
            onlyAlphaNumeric = true;
        }
        // using values from ASCII charts
        // Returns small letters only. Clients could use toUpper() for lower cases
        if (onlyAlphabets) {
            asciiBeg = 97;
            asciiEnd = 122;
        } else if (onlyNumbers) {
            asciiBeg = 48;
            asciiEnd = 57;
        }
        // if both (one of onlyAlphabets and onlyNumbers) and onlyAlphaNumeric are true,
        // alphaNumeric gets higher priority. (So, not "else if" in this case.
        if (onlyAlphaNumeric) {
            asciiBeg = 48;
            asciiEnd = 122;
            blockEnable = true;
        }

        Random rand = new Random();
        int randomNumber;
        for (int i = 0; i < length; i++) {
            do {
                randomNumber = rand.nextInt((asciiEnd - asciiBeg)) + asciiBeg;
            } while (blockEnable && randomNumber >= blockBeg && randomNumber <= blockEnd);
            randomString[i] = (char) randomNumber;
        }

        return charToString(randomString);
    }

    public static String charToString(char[] arr) {
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < arr.length; i++) {
            stringBuilder.append(arr[i]);
        }
        return stringBuilder.toString();
    }
}
