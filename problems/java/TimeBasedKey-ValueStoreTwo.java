class TimeMap {

  class Value {
    String value;
    int timestamp;
    Value(String value, int timestamp) {
      this.value = value;
      this.timestamp = timestamp;
    }
  }

  /** Initialize your data structure here. */
  HashMap<String, List<Value>> map;
  public TimeMap() {
    this.map = new HashMap<>();
  }
  
  public void set(String key, String value, int timestamp) {
    this.map.putIfAbsent(key, new ArrayList<Value>());
    this.map.get(key).add(new Value(value, timestamp));
  }
  
  public String get(String key, int timestamp) {
    int index = bs(map.getOrDefault(key, new ArrayList<Value>()), timestamp);
    if (index == -1) {
      return "";
    }
    return map.get(key).get(index).value;
  }

  private int bs(List<Value> list, int timestamp) {
    int left = 0;
    int right = list.size() - 1;
    int index = -1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (list.get(mid).timestamp > timestamp) {
        right = mid - 1;
      } else if (list.get(mid).timestamp < timestamp) {
        left = mid + 1;
        index = mid;
      } else {
        return mid;
      }
    }

    return index;
  }
}

/**
* Your TimeMap object will be instantiated and called as such:
* TimeMap obj = new TimeMap();
* obj.set(key,value,timestamp);
* String param_2 = obj.get(key,timestamp);
*/