import java.util.*;

public class problem6 {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));   // should return / print PAHNAPLSIIGYIR
        System.out.println(convert("PAYPALISHIRING", 4));   // should return / print PINALSIGYAHRPI
        System.out.println(convert("A", 1));
    }

    public static String convert(String s, int numRows) {
        if(s.length() < numRows) {
            return s;
        }

        Map<Integer, String> mapRowStr = new HashMap<>();
        int incrementOrDecrement = 1;
        int row = 0;
        for(int i = 0; i < s.length(); i++) {
            if (row == numRows - 1) {
                incrementOrDecrement = -1;
            } else if (row == 0) {
                incrementOrDecrement = 1;
            }

            if (mapRowStr.containsKey(row % numRows)) {
                mapRowStr.put(row % numRows, mapRowStr.get(row % numRows) + s.charAt(i));
            } else {
                mapRowStr.put(row % numRows, "" + s.charAt(i));
            }

            row += incrementOrDecrement;
        }

        String convertedString = "";
        for(int j = 0; j < numRows; j++) {
            if (mapRowStr.get(j) != null) {
                convertedString += mapRowStr.get(j);
            }
        }

        return convertedString;
    }
}
