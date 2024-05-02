public class problem9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));  // should return true
        System.out.println(isPalindrome(-121));   // should return false because -121 != 121-
        System.out.println(isPalindrome(10));   // should return false
    }

    public static boolean isPalindrome(int x) {
        // negative numbers are not palindrome
        if (x < 0) {
            return false;
        }

        int xTemp = x;
        int xReversed = 0;
        while (xTemp > 0) {
            xReversed = (xReversed * 10) + (xTemp % 10);
            xTemp /= 10;
        }

        return xReversed == x;
    }
}
