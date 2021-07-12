class Solution {
  public int numUniqueEmails(String[] emails) {
    Set<String> set = new HashSet<>();
    for (String email : emails) {
      String local = email.split("@")[0];
      String domain = email.split("@")[1];
      local = local.replace(".", "");
      int plusIndex = local.indexOf("+");
      if (plusIndex != -1) {
        local = local.substring(0, plusIndex);
      }
      set.add(local + "@" + domain);
    }
    
    return set.size();
  }
}