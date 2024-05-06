public class problem0011 {
    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    // ACCEPTED SOLUTION
    public static int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int maxArea = 0;
        while (start < end) {
            int smallestHeight = 0;
            if (height[start] < height[end]) {
                smallestHeight = height[start];
            } else {
                smallestHeight = height[end];
            }
            int area = (end - start) * smallestHeight;
            if (maxArea < area) {
                maxArea = area;
            }

            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return maxArea;
    }

    // this solution will timeout
    public static int maxArea1(int[] height) {
        int maxArea = 0;
        for(int i = 0; i < height.length; i++) {
            for(int j = i; j < height.length; j++) {
                int smallestHeight = 0;
                if (height[i] < height[j]) {
                    smallestHeight = height[i];
                } else {
                    smallestHeight = height[j];
                }
                int area = (j - i) * smallestHeight;
                if (maxArea < area) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }
}
