import java.util.*;

public class problem0004 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
	}

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> mergedList = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;
        while(index1 < nums1.length || index2 < nums2.length) {
            Integer a;
            if(index1 == nums1.length) {
                a = null;
            } else {
                a = nums1[index1];
            }
            Integer b;
            if(index2 == nums2.length) {
                b = null;
            } else {
                b = nums2[index2];
            }

            if(a != null && b != null) {
                if(a < b) {
                    mergedList.add(a);
                    index1++;
                } else {
                    mergedList.add(b);
                    index2++;
                }
            } else if(a != null && b == null) {
                mergedList.add(a);
                index1++;
            } else if(b != null && a == null) {
                mergedList.add(b);
                index2++;
            }
        }

        if(mergedList.size() % 2 == 1) {
            return mergedList.get(mergedList.size() / 2);
        }

        return (mergedList.get(mergedList.size() / 2) + mergedList.get((mergedList.size() / 2) - 1)) / 2.0;
    }
}
