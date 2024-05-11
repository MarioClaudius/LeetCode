package LeetCodeJava;

public class problem0008 {
    public static void main(String[] args) {
        System.out.println(myAtoi("words and 987"));    // should return 0
        System.out.println(myAtoi("0-1"));    // should return 0
        System.out.println(myAtoi(" -042"));    // should return -42
    }
    public static int myAtoi(String s) {
        // remove leading whitespace
        s = s.trim();

        boolean isNegative = false;
        boolean isSignFound = false;
        String numStr = "";
        // loop for check sign / number
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-' && !isSignFound) {
                isNegative = true;
                isSignFound = true;
                continue;
            } else if (s.charAt(i) == '+' && !isSignFound) {
                isSignFound = true;
                continue;
            }

            // check if non-digit character found after digit character found
            // + or - sign should be checked in condition above
            if ((s.charAt(i) < 48 || s.charAt(i) > 57)) {
                break;
            }

            // check number
            if (s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                isSignFound = true;
                numStr += s.charAt(i);
            }
        }

        if (numStr == "") {
            return 0;
        }

        try {
            int num = Integer.parseInt(numStr);
            if (isNegative) {
                return -1 * num;
            }
            return num;
        } catch (NumberFormatException nfe) {
            if (isNegative) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }
}
