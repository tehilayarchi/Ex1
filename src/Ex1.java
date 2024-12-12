/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over bases ranging from binary to hexadecimal.
 * [2-16], 10-16 are represented by A, B, ..., G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., "135bA" (i.e., "135", as 10 is the default base), "100111b2", "12345b6", "012b5", "123bG", "EFbG".
 * The following are NOT in the format (not a valid number):
 * "b2", "0b1", "123b", "1234b11", "3b3", "-3b5", "3 b4", "GbG", "", null,
 */

public class Ex1 {

    /**
     * Convert the given number (num) to a decimal representation (as int).
     * If the given number is not in a valid format, returns -1.
     * @param num a String representing a number in bases [2,16]
     * @return the decimal value of the number, or -1 if invalid
     */
    public static int number2Int(String num) {
        int ans = -1;

        // Check if input is valid using isNumber
        if (!isNumber(num)) {
            return ans; // Invalid input
        }

        try {
            // If no base is provided, assume base 10
            if (!num.contains("b")) {
                return Integer.parseInt(num); // Direct conversion
            }

            // Split the number and base
            String[] parts = num.split("b");
            String numberPart = parts[0]; // Number part
            String basePart = parts[1];   // Base part

            // Convert the base (letters or digits)
            int base = basePart.matches("[A-G]")
                    ? basePart.charAt(0) - 'A' + 10 // Convert A-G to 10-16
                    : Integer.parseInt(basePart);   // Convert numeric base

            // Convert to decimal value
            return Integer.parseInt(numberPart, base); // Convert using the base
        } catch (NumberFormatException e) {
            return -1; // Invalid input or base
        }
    }

    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     * @param a a String representing a number
     * @return true if the given String is in a valid number format
     */
    public static boolean isNumber(String a) {
        // Default - the string is considered valid
        boolean ans = true;

        // Null or empty strings are invalid
        if (a == null || a.isEmpty()) return false;

        // Strings starting with 'b' are invalid
        if (a.startsWith("b")) return false;

        // Check that there are no lowercase letters except 'b'
        if (a.matches(".*[a-z&&[^b]].*")) {
            return false; // If a lowercase letter other than 'b' is found, the string is invalid
        }

        // If no 'b', ensure it is a valid decimal number
        if (!a.contains("b")) {
            return a.matches("\\d+"); // If no base, the number must be valid in base 10
        }

        // Split the string into number and base parts
        String[] parts = a.split("b");
        if (parts.length != 2) return false; // Must have exactly two parts

        String numberPart = parts[0];
        String basePart = parts[1];

        // Validate the base
        if (!basePart.matches("[2-9]|10|11|12|13|14|15|16|A|B|C|D|E|F|G")) {
            ans = false; // Base must be between 2 and 16 (or A-G for 10-16)
        } else {
            int base = basePart.matches("[A-G]")
                    ? basePart.charAt(0) - 'A' + 10 // Convert A-G to 10-16
                    : Integer.parseInt(basePart);  // Numeric base

            // Check that all characters in the number part are valid for the base
            for (char c : numberPart.toCharArray()) {
                if (Character.digit(c, base) == -1) {
                    ans = false; // Invalid character for the given base
                    break;
                }
            }
        }

        return ans; // Return the value of ans after all checks
    }

    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16], the function should return "" (the empty String).
     * @param num the natural number (including 0)
     * @param base the base [2,16]
     * @return a String representing a number (in base) equal to num, or an empty String (if input is invalid)
     */
    public static String int2Number(int num, int base) {
        String ans ="";
        // Validate inputs
        if (num < 0 || base < 2 || base > 16) return ans;

        // Determine the representation of the base (e.g., 10 as 'A')
        String baseRepresentation = base >= 10 ? String.valueOf((char) ('A' + base - 10)) : String.valueOf(base);

        // Convert the number to the given base and append "b" with the base representation
        return Integer.toString(num, base) + "b" + baseRepresentation;
    }

    /**
     * Checks if the two numbers have the same value.
     * @param n1 first number
     * @param n2 second number
     * @return true if the two numbers have the same value
     */
    public static boolean equals(String n1, String n2) {
        boolean ans = true; // Initialize ans to true by default

        // Convert both numbers to decimal values
        int val1 = number2Int(n1);
        int val2 = number2Int(n2);
        ans = val1 == val2;  // Update ans based on the comparison result
        return ans;        // Return the value of ans

    }

    /**
     * Finds the index of the maximum integer value in an array of formatted numbers.
     * @param arr an array of formatted numbers
     * @return the index of the maximum number, or 0 if all are invalid or the array is empty
     */
    public static int maxIndex(String[] arr) {
        // Handle null or empty array
        if (arr == null || arr.length == 0) return 0;

        int ans = 0; // Default index
        int maxVal = Integer.MIN_VALUE; // Initialize max value to the smallest integer

        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) { // Skip null entries
                int currentVal = number2Int(arr[i]); // Convert current number to decimal

                // Update the maximum value and index if needed
                if (currentVal > maxVal) {
                    maxVal = currentVal;
                    ans = i;
                }
            }
        }

        return ans; // Return the index of the maximum value
    }
}
