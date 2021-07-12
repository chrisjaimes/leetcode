class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (Character.isLetterOrDigit(c)) {
                stack.push(Character.toLowerCase(c));
            }
        }
        
        int sLength = s.length();
        for(int i = 0; i < sLength; i++) {
            char c = Character.toLowerCase(s.charAt(i));
            if (Character.isLetterOrDigit(c) && c != stack.pop()) {
                return false;
            }
        }
        
        return true;
    }
}