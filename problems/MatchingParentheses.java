package problems;

public class MatchingParentheses {
    public boolean isValid(String s) {
        String oppenning = "({[";
        String p = "";
        // for every char c in s
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // if c is openning keep in some place p
            if (oppenning.contains(Character.toString(c))) {
                p += c;
            }
            // if c is closing
            else {
                // Get the last from p and compare with c
                if(p.length() == 0) {
                    return false;
                }
                char c2 = p.charAt(p.length()-1);
                if ((c == ')' && c2 != '(') ||
                        (c == '}' && c2 != '{') ||
                        (c == ']' && c2 != '[')) {
                    return false;
                }
                else {
                    p = p.substring(0, p.length()-1);
                }
            }
        }
        // if p still contains something, I have openning not closed
        if (p.length() > 0) {
            return false;
        }
        // If I reach here it is OK
        return true;
    }

    public static void main(String[] args) {
        MatchingParentheses solution = new MatchingParentheses();
        System.out.println(solution.isValid("(){}[]}"));
    }
}
