class Solution {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int stations = gas.length;
    int tank = 0;
    int currentGas = 0;
    int gasStation = 0;
      
    for (int i = 0; i < stations; i++) {
      tank += gas[i] - cost[i];
      currentGas += gas[i] - cost[i];
      if (currentGas < 0) {
        gasStation = i + 1;
        currentGas = 0;
      }
    }
      
    return (tank >= 0) ? gasStation : -1;
  }
}