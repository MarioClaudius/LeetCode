package LeetCodeJava;

import java.util.ArrayList;
import java.util.List;

public class problem0043 {
    public static void main(String[] args) {
        System.out.println(multiply("2", "3"));         // 6
        System.out.println(multiply("98", "9"));        // 882    
        System.out.println(multiply("123", "456"));     // 56088
        System.out.println(multiply("9133", "0"));      // 0
        System.out.println(multiply("408", "5"));       // 2040
        System.out.println(multiply("678", "0"));       // 0
        System.out.println(multiply("0", "332620029")); // 0
    }

    public static String multiply(String num1, String num2) {
        List<String> multiplyResultList = new ArrayList<>();
        for(int i = num1.length() - 1; i >= 0; i--) {
            int firstNumCurrentDigit = Character.getNumericValue(num1.charAt(i));
            int lastExceess = 0;
            String result = "";
            for(int j = num2.length() - 1; j >= 0; j--) {
                int secondNumCurrentDigit = Character.getNumericValue(num2.charAt(j));
                int multiplyResult = (firstNumCurrentDigit * secondNumCurrentDigit) + lastExceess;
                lastExceess = multiplyResult / 10;
                int remainder = multiplyResult % 10;
                if (j == 0) {
                    result = String.format("%d", multiplyResult) + result;
                } else {
                    result = String.format("%d", remainder) + result;
                }
            }
            multiplyResultList.add(result);
        }

        String result = "";
        for(int i = 0; i < multiplyResultList.size(); i++) {
            if (i == 0) {
                result = multiplyResultList.get(i);
                continue;
            }
            String addNumString = multiplyResultList.get(i);
            for(int j = 0; j < i; j++) {
                addNumString += "0";
            }

            String newResult = "";
            int lastExceess = 0;
            for(int a = 0; a < result.length(); a++) {
                int resultDigit = Character.getNumericValue(result.charAt(result.length()-1-a));
                int addNumDigit = Character.getNumericValue(addNumString.charAt(addNumString.length()-1-a));
                int addResult = resultDigit + addNumDigit + lastExceess;
                lastExceess = addResult / 10;
                int remainder = addResult % 10;
                newResult = remainder + newResult;
            }
            if (addNumString.length() != result.length()) {
                for(int b = addNumString.length() - result.length() - 1; b >= 0; b--) {
                    int lastAddResult = Character.getNumericValue(addNumString.charAt(b)) + lastExceess;
                    if (b == 0) {
                        newResult = (Character.getNumericValue(addNumString.charAt(b)) + lastExceess) + newResult;
                        continue;
                    }
                    int lastRemainder = lastAddResult % 10;
                    lastExceess = lastAddResult / 10;
                    newResult = lastRemainder + newResult;
                }
            } else {
                if (lastExceess > 0) {
                    newResult = lastExceess + newResult;
                }
            }
            result = newResult;
        }

        // remove any prefix zero
        String resultAfterRemoveLeadingZero = result;
        for(int i = 0; i < result.length(); i++) {
            if (result.charAt(i) != '0') {
                break;
            }
            resultAfterRemoveLeadingZero = resultAfterRemoveLeadingZero.substring(1);
        }
        if (resultAfterRemoveLeadingZero.length() == 0) {
            return "0";
        }
        return resultAfterRemoveLeadingZero;
    }
}
