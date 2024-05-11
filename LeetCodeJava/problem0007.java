package LeetCodeJava;

public class problem0007 {
    public static void main(String[] args) {
        System.out.println(reverse(123));           // should return 321
        System.out.println(reverse(-123));            // should return -321
        System.out.println(reverse(120));           // should return 21
        System.out.println(reverse(1534236469));    // should return 0
    }

    // using remainder
    public static int reverse(int x) {
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x *= -1;
        }

        int reversedResult = 0;
        while(x > 0) {
            // if reversedResult is gonna ended more than max integer value if the loops continue
            if (reversedResult > (Integer.MAX_VALUE/10) || (reversedResult == (Integer.MAX_VALUE) && x % 10 > 7)) {
                return 0;
            }
            reversedResult = (reversedResult * 10) + (x % 10);
            x /= 10;
        }

        if (isNegative) {
            reversedResult *= -1;
        }

        return reversedResult;
    }

    // convert int to string solution
    public static int reverse1(int x) {
        String xStr = String.valueOf(x);
        String xReversedStr = "";
        if (xStr.charAt(0) == '-') {
            xStr = xStr.substring(1);
            xReversedStr = "-";
        }
        for(int i = xStr.length() - 1; i >= 0; i--) {
            xReversedStr += xStr.charAt(i);
        }

        try {
            int a = Integer.parseInt(xReversedStr);
            return a;
        } catch (NumberFormatException nfe) {
            return 0;
        }
    }
}
