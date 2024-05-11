import java.util.Arrays;

public class problem0014 {
    public static void main(String[] args) {
        String[] strs1 = new String[]{"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs1));
        String[] strs2 = new String[]{"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(strs2));
        String[] strs3 = new String[]{"ab", "a"};
        System.out.println(longestCommonPrefix(strs3));
    }

    // ACCEPTED SOLUTION WITH FASTER RUNTIME
    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String firstStr = strs[0];
        String lastStr = strs[strs.length-1];

        for(int i = 0; i < firstStr.length(); i++) {
            if (i == lastStr.length() || firstStr.charAt(i) != lastStr.charAt(i)) {
                return firstStr.substring(0, i);
            }
        }
        return firstStr;
    }

    // ACCEPTED SOLUTION WITH SLOW RUNTIME (LOOP ALL ARRAY)
    public static String longestCommonPrefix1(String[] strs) {
        String longestCommonPrefix = "";
        String firstStr = strs[0];
        for(int i = 0; i < firstStr.length(); i++) {
            boolean isCommonPrefix = true;
            for(int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || firstStr.charAt(i) != strs[j].charAt(i)) {
                    isCommonPrefix = false;
                    break;
                }
            }

            if (!isCommonPrefix) {
                break;
            }

            longestCommonPrefix += firstStr.charAt(i);
        }

        return longestCommonPrefix;
    }
}
