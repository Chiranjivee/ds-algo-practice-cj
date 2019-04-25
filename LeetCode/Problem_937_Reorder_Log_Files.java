class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> digitLogs = new ArrayList<>();
        List<String> letterLogs = new ArrayList<>();
        for (String log: logs) {
            if (Character.isDigit(log.charAt(log.indexOf(" ") + 1))) {
                digitLogs.add(log);
            } else {
                letterLogs.add(log);
            }
        }
        
        Collections.sort(letterLogs, (a, b) -> {
            int s1FirstSpaceIdx = a.indexOf(" "); 
            int s2FirstSpaceIdx = b.indexOf(" ");
            
            String logA = a.substring(s1FirstSpaceIdx + 1);
            String logB = b.substring(s2FirstSpaceIdx + 1);
            
            int compare = logA.compareTo(logB);
            if (compare == 0) {
                return a.substring(0, s1FirstSpaceIdx).compareTo(b.substring(0, s2FirstSpaceIdx));
            }
            
            return compare;            
        });
        
        letterLogs.addAll(digitLogs);
        String [] res = new String[logs.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = letterLogs.get(i);
        }
        return res;
    }
}
