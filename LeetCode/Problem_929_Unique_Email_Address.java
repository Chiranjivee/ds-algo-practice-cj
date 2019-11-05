class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String[] parts = email.split("@");
            String[] localParts = parts[0].split("\\+");
            set.add(localParts[0].replace(".", "") + "@" + parts[1]);
        }
        return set.size();
    }
}
