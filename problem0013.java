import java.util.*;

public class problem0013 {
    public static void main(String[] args) {
        System.out.println(romanToInt("III"));      // should return 3
        System.out.println(romanToInt("LVIII"));    // should return 58
        System.out.println(romanToInt("MCMXCIV"));  // should return 1994
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> mapRomanToInt = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
        );

        int result = 0;
        int maxIntRomanValueBefore = 0;
        for(int i = s.length()-1; i >= 0; i--) {
            if (mapRomanToInt.get(s.charAt(i)) < maxIntRomanValueBefore) {
                result -= mapRomanToInt.get(s.charAt(i));
            } else {
                result += mapRomanToInt.get(s.charAt(i));
                maxIntRomanValueBefore = mapRomanToInt.get(s.charAt(i));
            }
        }
        return result;
    }
}
