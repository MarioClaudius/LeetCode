package LeetCodeJava;

public class problem0344 {
    public static void main(String[] args) {
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        System.out.print("[ ");
        for(int i = 0; i < s.length; i++) {
            System.out.print(s[i] + " ");
        }
        System.out.println("]");
    }

    public static void reverseString(char[] s) {
        int leftIndex = 0;
        int rightIndex = s.length - 1;
        while (leftIndex <= rightIndex) {
            char temp = s[leftIndex];
            s[leftIndex] = s[rightIndex];
            s[rightIndex] = temp;
            leftIndex++;
            rightIndex--;
        }
    }
}
