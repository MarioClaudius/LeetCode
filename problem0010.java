public class problem0010 {
    public static void main(String[] args) {
        System.out.println(isMatch("a", "b.."));      // should return true
        System.out.println(isMatch("aabcbcbcaccbcaabc", ".*a*aa*.*b*.c*.*a*"));      // should return true
        System.out.println(isMatch("a", "..*"));      // should return true
        System.out.println(isMatch("aba", ".*.*"));      // should return true
        System.out.println(isMatch("a", ".*..a*"));      // should return false
        System.out.println(isMatch("aaa", "aa"));      // should return false
        System.out.println(isMatch("aaa", "ab*a*c*a"));      // should return true
        System.out.println(isMatch("aaa", ".a"));      // should return false
        System.out.println(isMatch("aaa", "aaaa"));     // should return false
        System.out.println(isMatch("mississippi", "mis*is*p*.")); // should return false
        System.out.println(isMatch("aab", "c*a*b"));     // should return true
        System.out.println(isMatch("aa", "a"));     // should return false
        System.out.println(isMatch("aa", "a*"));    // should return true
        System.out.println(isMatch("ab", ".*"));    // should return true
    }

    // ACCEPTED SOLUTION USING RECURSIVE
    public static boolean isMatch(String s, String p) {
        if (p.length() == 1) {
            if (p.charAt(0) == '.') {
                return s.length() == 1;
            }

            if (Character.isAlphabetic(p.charAt(0))) {
                return s.length() == 1 && s.charAt(s.length()-1) == p.charAt(0);
            }
        }

        if (p.length() == 2) {
            if (p.charAt(1) != '*') {
                if (p.charAt(1) == '.') {
                    if (s.length() > 0) {
                        return isMatch(s.substring(0, s.length()-1), p.substring(0, p.length()-1));
                    }
                    return false;
                }
                if (Character.isAlphabetic(p.charAt(1))) {
                    if (p.charAt(1) == s.charAt(s.length()-1)) {
                        return isMatch(s.substring(0, s.length()-1), p.substring(0, p.length()-1));
                    } else {
                        return false;
                    }
                }
            } else {
                if (p.charAt(0) == '.') {
                    return true;
                }
                if (Character.isAlphabetic(p.charAt(0))) {
                    for(int i = 0; i < s.length(); i++) {
                        if (s.charAt(i) != p.charAt(0)) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }

        if (p.charAt(p.length()-1) == '*') {
            if (p.charAt(p.length()-2) == '.') {
                // always check for case no character eliminated from this regex rules
                boolean isMatchRegex = isMatch(s, p.substring(0, p.length()-2));
                for(int i = s.length()-1; i >= 0; i--) {
                    isMatchRegex = isMatchRegex || isMatch(s.substring(0, i), p.substring(0, p.length()-2));
                }
                return isMatchRegex;
            } else if (Character.isAlphabetic(p.charAt(p.length()-2))) {
                int lastIndex = s.length() - 1;
                if (s.length() == 0) {
                    return isMatch(s, p.substring(0, p.length()-2));
                }
                if (s.length() > 0 && s.charAt(lastIndex) != p.charAt(p.length()-2)) {
                    return isMatch(s, p.substring(0, p.length()-2));
                }

                // always check for case no character eliminated from this regex rules
                boolean isMatchRegex = isMatch(s, p.substring(0, p.length()-2));
                for(int i = s.length()-1; i >= 0; i--) {
                    if (s.charAt(i) == p.charAt(p.length()-2)) {
                        isMatchRegex = isMatchRegex || isMatch(s.substring(0, i), p.substring(0, p.length()-2));
                    } else {
                        break;
                    }
                }
                return isMatchRegex;
            }
        }

        if (p.charAt(p.length()-1) == '.') {
            if (s.length() > 0) {
                return isMatch(s.substring(0, s.length()-1), p.substring(0, p.length()-1));
            } else {
                return false;
            }
        }

        if (Character.isAlphabetic(p.charAt(p.length()-1))) {
            if (s.length() > 0 && s.charAt(s.length()-1) == p.charAt(p.length()-1)) {
                return isMatch(s.substring(0, s.length()-1), p.substring(0, p.length()-1));
            } else {
                return false;
            }
        }
        return true;
    }

    // uncomplete solution using loop (only 319 / 356 testcase passed)
    public static boolean isMatch1(String s, String p) {
        if (p.charAt(p.length()-1) == s.charAt(s.length()-1)) {
            p = p.substring(0, p.length()-1);
            s = s.substring(0, s.length()-1);
        }

        if (s.length() >= 1 && p.length() > 1 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') && p.charAt(1) != '*') {
            p = p.substring(1);
            s = s.substring(1);
        }

        if (s.length() > 0 && p.length() == 0) {
            return false;
        }

        int indexPattern = p.length() - 1;
        int indexInput = s.length() - 1;
        boolean onAsterisk = false;
        while(indexPattern >= 0) {
            if (p.charAt(indexPattern) == '*') {
                onAsterisk = true;
                indexPattern--;
                continue;
            }

            if (p.charAt(indexPattern) == '.') {
                if (onAsterisk) {
                    int indexBeforeDot = indexPattern - 1;
                    if (indexBeforeDot == -1) {
                        return true;
                    } else {
                        while(p.charAt(indexBeforeDot) == '*') {
                            indexBeforeDot--;
                            indexInput--;
                        }
                        char charBeforeDot = p.charAt(indexBeforeDot);
                        while(indexInput >= 0 && s.charAt(indexInput) != charBeforeDot) {
                            indexInput--;
                        }
                        onAsterisk = false;
                        indexPattern--;
                    }
                } else {
                    if (indexInput >= 0) {
                        indexInput--;
                    } else {
                        break;
                    }
                    indexPattern--;
                    continue;
                }
            }

            if (Character.isAlphabetic(p.charAt(indexPattern))) {
                if (onAsterisk) {
                    while(indexInput >= 0 && p.charAt(indexPattern) == s.charAt(indexInput)) {
                        indexInput--;
                    }
                    indexPattern--;
                    onAsterisk = false;
                } else {
                    if (indexInput == -1 || p.charAt(indexPattern) != s.charAt(indexInput)) {
                        return false;
                    } else {
                        indexInput--;
                        indexPattern--;
                    }
                }
                
            }
        }

        return (indexInput == -1 && indexPattern == -1);
    }
}
