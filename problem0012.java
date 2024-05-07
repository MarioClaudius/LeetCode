import java.util.*;

public class problem0012 {
    public static void main(String[] args) {
        System.out.println(intToRoman(3749));       // should return MMMDCCXLIX
        System.out.println(intToRoman(58));         // should return LVIII
        System.out.println(intToRoman(10));         // should return X
    }

    // input : 1 <= num <= 3999
    // 20ms runtime solution
    public static String intToRoman(int num) {
        Map<Integer, Character> mapIntToRoman = Map.of(
            1, 'I',
            5, 'V',
            10, 'X',
            50, 'L',
            100, 'C',
            500, 'D',
            1000, 'M'
        );
        List<Integer> numCheckList = new ArrayList<>();
        numCheckList.add(1);
        numCheckList.add(5);
        numCheckList.add(10);
        numCheckList.add(50);
        numCheckList.add(100);
        numCheckList.add(500);
        numCheckList.add(1000);
        String romanNum = "";
        int multiplier = 1;

        while (num > 0) {
            int lastDigit = num % 10;
            int remainder = lastDigit % 5;
            int count = 0;
            switch (remainder) {
                case 4:
                    for(int i = 0; i < numCheckList.size(); i++) {
                        if (lastDigit * multiplier > numCheckList.get(i)) {
                            count++;
                        } else {
                            char firstChar = mapIntToRoman.get(numCheckList.get(i-count));
                            char secondChar = mapIntToRoman.get(numCheckList.get(i));
                            romanNum = firstChar + secondChar + romanNum;
                            break;
                        }
                    }
                    multiplier *= 10;
                    for(int j = 0; j < 2; j++) {
                        numCheckList.remove(0);
                    }
                    num /= 10;
                    count = 0;
                    break;
                case 0:
                    if (lastDigit == 5) {
                        romanNum = mapIntToRoman.get(numCheckList.get(1)) + romanNum;
                    }
                    multiplier *= 10;
                    num /= 10;
                    if (numCheckList.size() > 2) {
                        for(int i = 0; i < 2; i++) {
                            numCheckList.remove(0);
                        }
                    }
                    break;
                default:
                    for(int i = 0; i < numCheckList.size(); i++) {
                        if (lastDigit * multiplier > numCheckList.get(i)) {
                            count++;
                        } else {
                            break;
                        }
                    }
                    for(int j = 0; j < remainder; j++) {
                        romanNum = mapIntToRoman.get(numCheckList.get(0)) + romanNum;
                    }
                    if (count == 2) {
                        romanNum = mapIntToRoman.get(numCheckList.get(1)) + romanNum;
                    }
                    if (numCheckList.size() > 2) {
                       for(int i = 0; i < 2; i++) {
                        numCheckList.remove(0);
                       }
                    }
                    num /= 10;
                    multiplier *= 10;
                    count = 0;
                    break;
            }

        }
        return romanNum;
    }
}
