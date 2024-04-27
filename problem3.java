import java.util.*;

public class problem3
{
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("ggububgvfk"));
	}
	
	public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int count = 0;
        int countIndex = 0;
        Map<Character, Integer> mapChar = new HashMap<>();
        Map<Integer, Character> mapIndex = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(mapChar.containsKey(s.charAt(i))) {
                if(count > max) {
                    max = count;
                }
                int lastIndex = mapChar.get(s.charAt(i));
                count = i - lastIndex;
                while(countIndex <= lastIndex) {
                    mapChar.remove(mapIndex.get(countIndex));
                    countIndex++;
                }
                mapChar.put(s.charAt(i), i);
                mapIndex.put(i, s.charAt(i));
            } else {
                count++;
                mapChar.put(s.charAt(i), i);
                mapIndex.put(i, s.charAt(i));
            }
        }

        if(count > max) {
            max = count;
        }

        return max;
    }
}
