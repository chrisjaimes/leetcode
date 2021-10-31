class Solution {
  public int distanceBetweenBusStops(int[] distance, int start, int destination) {
    int clockwiseDistance = 0;
    int totalDistance = 0;
    
    for (int i = 0; i < distance.length; i++) {
      totalDistance += distance[i];
      
      if (start < destination && (i >= start && i < destination)) {
        clockwiseDistance += distance[i];
      }
      if (start > destination && (i >= start || i < destination)) {
        clockwiseDistance += distance[i];
      }
    }
    
    return Math.min(clockwiseDistance, totalDistance - clockwiseDistance);
  }
}