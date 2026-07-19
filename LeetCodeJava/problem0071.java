package LeetCodeJava;

import java.util.Stack;

public class problem0071 {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/user/Documents/../Pictures"));
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/.../a/../b/c/../d/./"));
    }

    public static String simplifyPath(String path) {
        String[] splittedPath = path.split("/");
        Stack<String> pathStack = new Stack<>();
        for(int i = 0; i < splittedPath.length; i++) {
            String directory = splittedPath[i];
            if (directory.equals("") || directory.equals(".")) {
                continue;
            }
            if (directory.equals("..")) {
                if (!pathStack.isEmpty()) {
                    pathStack.pop();
                }
                continue;
            }
            pathStack.push(splittedPath[i]);
        }
        String simplifiedPath = "";
        while (!pathStack.isEmpty()) {
            String directory = pathStack.pop();
            simplifiedPath = "/" + directory + simplifiedPath;
        }
        if (simplifiedPath.length() == 0) {
            return "/";
        }
        return simplifiedPath;
    }
}
