import java.util.*;

public class problem0012 {
    public static void main(String[] args) {
        ArrayList<Integer> numList = new ArrayList<>();
        numList.add(1);
        numList.add(2);
        numList.remove(0);
        System.out.println(intToRoman(3749));
    }

    // input : 1 <= num <= 3999
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
        //Arrays.asList(1, 5, 10, 50, 100, 500, 1000);
        String romanNum = "";
        int multiplier = 1;

        while (num > 0) {
            int lastDigit = num % 10;
            int remainder = lastDigit % 5;
            switch (remainder) {
                case 4:
                    for(int i = 0; i < numCheckList.size(); i++) {
                        if (lastDigit * multiplier > numCheckList.get(i)) {
                            // i++;
                        } else {
                            char firstChar = mapIntToRoman.get(numCheckList.get(i-2));
                            char secondChar = mapIntToRoman.get(numCheckList.get(i-1));
                            romanNum = firstChar + "" + secondChar + "" + romanNum;
                            break;
                        }
                    }
                    multiplier *= 10;
                    for(int j = 0; j < 2; j++) {
                        numCheckList.remove(0);
                    }
                    num /= 10;
                    break;
                case 0:
                    multiplier *= 10;
                    num /= 10;
                    if (numCheckList.size() > 2) {
                        numCheckList.remove(0);
                        numCheckList.remove(1);
                    }
                    break;
                default:
                    int count = 0;
                    for(int i = 0; i < numCheckList.size(); i++) {
                        if (lastDigit * multiplier < numCheckList.get(i)) {
                            count++;
                        }
                    }
                    for(int j = 0; j < remainder; j++) {
                        romanNum = mapIntToRoman.get(numCheckList.get(0)) + romanNum;
                    }
                    if (count == 2) {
                        romanNum = mapIntToRoman.get(numCheckList.get(1)) + romanNum;
                    }
                    if (numCheckList.size() > 2) {
                        numCheckList.remove(0);
                        numCheckList.remove(1);
                    }
                    num /= 10;
                    break;
            }

        }
        return romanNum;
    }
}
