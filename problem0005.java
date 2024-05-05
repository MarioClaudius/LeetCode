public class problem0005 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad")); // should print bab / aba
        System.out.println(longestPalindrome("cbbd"));  // should print bb
	}

    public static String longestPalindrome(String s) {
        String longestPalindromeStr = "";
        // for odd length palindrome
        for(int i = 0; i < s.length(); i++) {
            if (i == 0 || i == s.length()-1) {
                if (longestPalindromeStr.length() < 1) {
                    longestPalindromeStr = s.substring(i, i+1);
                }
            } else {
                int left = i;
                int right = i;
                while(left >= 0 && right < s.length()) {
                    if (s.charAt(left) == s.charAt(right)) {
                        left--;
                        right++;
                    } else {
                        left++;
                        right--;
                        break;
                    }
                }
                if (left == -1 || right == s.length()) {
                    left++;
                    right--;
                }
                String palindromeSubStr = s.substring(left, right+1);
                if (longestPalindromeStr.length() < palindromeSubStr.length()) {
                    longestPalindromeStr = palindromeSubStr;
                }
            }
        }

        // for even length palindrome
        for(int j = 0; j < s.length()-1; j++) {
            if (j == 0 || j == s.length()-2) {
                if ((longestPalindromeStr.length() < 2) && (s.charAt(j) == s.charAt(j+1))) {
                    longestPalindromeStr = s.substring(j, j+2);
                }
            } else {
                int left = j;
                int right = j + 1;
                while (left >= 0 && right < s.length()) {
                    if (s.charAt(left) == s.charAt(right)) {
                        left--;
                        right++;
                    } else {
                        left++;
                        right--;
                        break;
                    }
                }
                if (left == -1 || right == s.length()) {
                    left++;
                    right--;
                }
                String palindromeSubStr = s.substring(left, right+1);
                if (longestPalindromeStr.length() < palindromeSubStr.length()) {
                    longestPalindromeStr = palindromeSubStr;
                }
            }
        }
        return longestPalindromeStr;
    }
}
