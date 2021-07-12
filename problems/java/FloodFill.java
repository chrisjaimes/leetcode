class Solution {
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    if (image[sr][sc] == newColor) {
      return image;
    }
      
    fill(image, sr, sc, image[sr][sc], newColor);
    return image;
  }
  private void fill(int[][] image, int sr, int sc, int currentColor, int newColor) {
    if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[sr].length || image[sr][sc] != currentColor) {
      return;
    }
    
    image[sr][sc] = newColor;
    fill(image, sr + 1, sc, currentColor, newColor);
    fill(image, sr - 1, sc, currentColor, newColor);
    fill(image, sr, sc + 1, currentColor, newColor);
    fill(image, sr, sc - 1, currentColor, newColor);
  }
}