class Solution {
    int teamSize;
    HashSet<Integer> resTeam;
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        teamSize = people.size()+1;
        resTeam = new HashSet();
        HashMap<String,List<Integer>> skillMap = new HashMap();
        for(int i=0; i<people.size(); i++){
            for(String skill : people.get(i)){
                if(!skillMap.containsKey(skill)){
                    skillMap.put(skill, new ArrayList<Integer>());
                }
                skillMap.get(skill).add(i);
            }
        }
        find(skillMap, req_skills, 0, new HashSet());
        int[] res = new int[resTeam.size()];
        int index = 0;
        for(int person : resTeam){
            res[index++] = person;
        }
        return res;
    }
    
    public void find(HashMap<String,List<Integer>> skillMap, String[] req_skills, int cur, HashSet<Integer> team){
        if(team.size()>teamSize) return;
        if(cur==req_skills.length){
            if(team.size()<teamSize){
                teamSize = team.size();
                resTeam = new HashSet<Integer>();
                resTeam.addAll(team);
            }
            return;
        }
        for(int person : skillMap.get(req_skills[cur])){
            boolean isRemove = !team.contains(person);
            team.add(person);
            find(skillMap, req_skills, cur+1, team);
            if(isRemove) team.remove(person);
        }
    }
}
