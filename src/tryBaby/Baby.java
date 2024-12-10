package tryBaby;

public class Baby {

    // ממיר מחרוזת בפורמט "numberPartbbasePart" למספר שלם
    public static int number2Int(String num) {
        int ans = -1; // ערך התחלתי המציין שגיאה
        if (!isNumber(num)) { // בדיקה אם הפורמט תקין
            return ans;
        }

        // פיצול המחרוזת לשני חלקים: המספר והבסיס
        String[] parts = num.split("b");
        String numberPart = parts[0];
        String basePart = parts[1];

        // קביעת הבסיס (אם הוא בייצוג A-G, מתורגם לבסיס מתאים, אחרת ממיר מחרוזת למספר)
        int base = basePart.matches("[A-G]") ? basePart.charAt(0) - 'A' + 10 : Integer.parseInt(basePart);

        try {
            // המרת ה-numberPart למספר שלם בבסיס הנתון
            ans = Integer.parseInt(numberPart, base);
        } catch (NumberFormatException e) {
            ans = -1; // אם יש חריגה, מוחזר ערך השגיאה
        }

        return ans; // הערך המומר או -1 אם אירעה שגיאה
    }

    // בודקת אם מחרוזת בפורמט חוקי של "numberPartbbasePart"
    public static boolean isNumber(String a) {
        boolean ans = true;

        // בדיקות ראשוניות: האם המחרוזת ריקה או חסרה את הסימון 'b'
        if (a == null || a.isEmpty() || !a.contains("b")) return false;

        // פיצול המחרוזת לשני חלקים
        String[] parts = a.split("b");
        if (parts.length != 2) return false;

        String numberPart = parts[0];
        String basePart = parts[1];

        // בדיקת חוקיות הבסיס (2–16 או A-G)
        if (!basePart.matches("[2-9]|10|11|12|13|14|15|16|A|B|C|D|E|F|G")) return false;

        // המרת בסיס לייצוג מספרי
        int base = basePart.matches("[A-G]") ? basePart.charAt(0) - 'A' + 10 : Integer.parseInt(basePart);

        // בדיקה אם כל תו במספר מתאים לבסיס הנתון
        for (char c : numberPart.toCharArray()) {
            if (Character.digit(c, base) == -1) return false;
        }

        return ans; // המחרוזת חוקית אם עברה את כל הבדיקות
    }

    // ממיר מספר שלם למחרוזת בפורמט "numberPartbbasePart"
    public static String int2Number(int num, int base) {
        String ans = "";
        // בדיקת תקינות הקלט (מספר חיובי ובסיס בין 2 ל-16)
        if (num < 0 || base < 2 || base > 16) return ans;

        // המרה לייצוג הבסיס (A-G לבסיסים מעל 10)
        String baseRepresentation = base >= 10 ? String.valueOf((char) ('A' + base - 10)) : String.valueOf(base);

        // המרת המספר למחרוזת בפורמט המבוקש
        ans = Integer.toString(num, base) + "b" + baseRepresentation;

        return ans; // המחרוזת המיוצגת
    }

    // בודקת אם שתי מחרוזות מייצגות את אותו ערך במספר
    public static boolean equals(String n1, String n2) {
        boolean ans = true;

        // המרת שתי המחרוזות לערכים שלמים והשוואתם
        int val1 = number2Int(n1);
        int val2 = number2Int(n2);

        ans = (val1 == val2); // מחזירה true אם הערכים שווים

        return ans;
    }

    // מוצאת את האינדקס של המחרוזת הגדולה ביותר במערך מחרוזות
    public static int maxIndex(String[] arr) {
        int ans = 0; // אינדקס התוצאה
        int maxVal = Integer.MIN_VALUE; // ערך מקסימלי התחלתי

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) { // אם המחרוזת אינה null
                int currentVal = number2Int(arr[i]); // המרת המחרוזת לערך מספרי

                // עדכון אינדקס התוצאה אם נמצא ערך גדול יותר
                if (currentVal > maxVal) {
                    maxVal = currentVal;
                    ans = i;
                }
            }
        }

        return ans; // מחזירה את האינדקס של הערך הגדול ביותר
    }
}
