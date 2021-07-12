class Solution {
  public int leastInterval(char[] tasks, int n) {
    int[] freqs = new int[26];
    for (char c : tasks) {
      freqs[c - 'A']++;
    }
      
    Arrays.sort(freqs);
    int maxFreq = freqs[25];
    int idle = (maxFreq - 1) * n;
    
    for (int i = 24; i >= 0; i--) {
      idle -= Math.min(freqs[i], maxFreq - 1);
    }
      
    return (idle > 0) ? idle + tasks.length : tasks.length;
  }
}
