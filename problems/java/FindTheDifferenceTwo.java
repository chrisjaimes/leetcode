class Solution {
    public char findTheDifference(String s, String t) {
        int[] chars = new int[26];
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        
        for (int i = 0; i < sChars.length; i++) {
            chars[sChars[i] - 'a']++;
        }
        for (int i = 0; i < tChars.length; i++) {
            chars[tChars[i] - 'a']--;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 0) {
                return (char)(i+'a');
            }
        }
        return (char)(tChars[tChars.length - 1] + 'a');
    }
}

