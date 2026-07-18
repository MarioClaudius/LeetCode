package LeetCodeJava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class problem0207 {
    public static void main(String[] args) {
        System.out.println(canFinish(7, new int[][]{{1,0},{0,3},{0,2},{3,2},{2,5},{4,5},{5,6},{2,4}}));
        System.out.println(canFinish(20, new int[][]{{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}}));
        System.out.println(canFinish(2, new int[][]{{1,0}}));
        System.out.println(canFinish(2, new int[][]{{1,0},{0,1}}));
    }

    // [[1,0]] -> true
    // [[1,0],[0,1]] -> false
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> coursePrerequisitesMap = new HashMap<>();
        HashMap<Integer, Boolean> canPassPrerequisites = new HashMap<>();

        // loop all prerequisites, length of inner array always 2
        for(int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][1];
            int coursePrerequisite = prerequisites[i][0];
            if (coursePrerequisitesMap.containsKey(course)) {
                coursePrerequisitesMap.get(course).add(coursePrerequisite);
            } else {
                List<Integer> initialList = new ArrayList<>();
                initialList.add(coursePrerequisite);
                coursePrerequisitesMap.put(course, initialList);
            }
        }

        for(int i = 0; i < numCourses; i++) {
            if (coursePrerequisitesMap.containsKey(i)) {
                canPassPrerequisites.put(i, false);
                continue;
            }
            canPassPrerequisites.put(i, true);
        }

        boolean courseCanPassPrerequisitesExist = true;;
        while (courseCanPassPrerequisitesExist) {
            courseCanPassPrerequisitesExist = false;
            for(Integer course : canPassPrerequisites.keySet()) {
                if (canPassPrerequisites.get(course)) {
                    continue;
                }
                boolean currentCourseCanPass = true;
                List<Integer> coursePrerequisites = coursePrerequisitesMap.get(course);
                for(int i = 0; i < coursePrerequisites.size(); i++) {
                    if (!canPassPrerequisites.get(coursePrerequisites.get(i))) {
                        currentCourseCanPass = false;
                    }
                }
                canPassPrerequisites.put(course, currentCourseCanPass);
                if (currentCourseCanPass) {
                    courseCanPassPrerequisitesExist = true;
                }
            }
        }

        boolean canFinish = true;
        for(Integer course : canPassPrerequisites.keySet()) {
            if(!canPassPrerequisites.get(course)) {
                canFinish = false;
                break;
            }
        }
        return canFinish;
    }
}
