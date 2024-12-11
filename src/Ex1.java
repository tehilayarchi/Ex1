
/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */

public class Ex1 {

    public static int number2Int(String num) {
        int ans = -1;
        if (!isNumber(num)) {
            return ans;
        }

        String[] parts = num.split("b");
        String numberPart = parts[0];
        String basePart = parts[1];

        int base = basePart.matches("[A-G]") ? basePart.charAt(0) - 'A' + 10 : Integer.parseInt(basePart);

        try {
            ans = Integer.parseInt(numberPart, base);
        } catch (NumberFormatException e) {
            ans = -1;
        }

        return ans;
    }

    public static boolean isNumber(String a) {
        if (a == null || a.isEmpty() || !a.contains("b")) return false;

        String[] parts = a.split("b");
        if (parts.length != 2) return false;

        String numberPart = parts[0];
        String basePart = parts[1];

        if (!basePart.matches("[2-9]|10|11|12|13|14|15|16|A|B|C|D|E|F|G")) return false;

        int base = basePart.matches("[A-G]") ? basePart.charAt(0) - 'A' + 10 : Integer.parseInt(basePart);

        for (char c : numberPart.toCharArray()) {
            if (Character.digit(c, base) == -1) return false;
        }

        return true;
    }

    public static String int2Number(int num, int base) {
        if (num < 0 || base < 2 || base > 16) return "";

        String baseRepresentation = base >= 10 ? String.valueOf((char) ('A' + base - 10)) : String.valueOf(base);

        return Integer.toString(num, base) + "b" + baseRepresentation;
    }

    public static boolean equals(String n1, String n2) {
        int val1 = number2Int(n1);
        int val2 = number2Int(n2);

        return val1 == val2;
    }

    public static int maxIndex(String[] arr) {
        int ans = 0;
        int maxVal = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                int currentVal = number2Int(arr[i]);

                if (currentVal > maxVal) {
                    maxVal = currentVal;
                    ans = i;
                }
            }
        }

        return ans;
    }
}
