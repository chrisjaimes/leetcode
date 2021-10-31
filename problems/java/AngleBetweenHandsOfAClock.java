class Solution {
  public double angleClock(int hour, int minutes) {
    double hrAngle = (360 / 12) * ((minutes / 60.0) + hour % 12);
    double minAngle = (360 / 60) * minutes;
  
    double diff = Math.abs(hrAngle - minAngle);
    return Math.min(diff, 360 - diff);
  }
}