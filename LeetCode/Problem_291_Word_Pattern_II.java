class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        if(pattern==null||pattern.length()==0)return str.length()==0;
        return find(pattern,0,str,0,new HashMap<Character,String>(),new HashMap<String,Character>());
    }
    
    public boolean find(String p,int i,String s,int j,Map<Character,String> m,Map<String,Character> reverse){

        if(i==p.length()&&j==s.length())return true;
        if(i==p.length()||j==s.length())return false;
        if(m.containsKey(p.charAt(i))){
            String v=m.get(p.charAt(i));
            if(j+v.length()>s.length()||!v.equals(s.substring(j,j+v.length())))return false;
            else return find(p,i+1,s,j+v.length(),m,reverse);
        }else{
            for(int k=j+1;k<=s.length();k++){
                if(!reverse.containsKey(s.substring(j,k))){
                    m.put(p.charAt(i),s.substring(j,k));
                    reverse.put(s.substring(j,k),p.charAt(i));
                    if(find(p,i+1,s,k,m,reverse)) return true;   
                    reverse.remove(s.substring(j,k));
                    m.remove(p.charAt(i));
                }
            }
            return false;
        }
    }
}