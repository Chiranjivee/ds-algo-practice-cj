class Node{
    public int in;
    public char ch;
    
    public Node(int i, char c){
        in = i;
        ch = c;
    }
    
    public void minusOne(){
        in-=1;
    }
}

class Solution {
    public String rearrangeString(String s, int k) {
        if(k == 0 || s.length() < 2) return s;
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i)-'a']++;
        }
        //PriorityQueue<Node> pq = new PriorityQueue<Node>((a,b)-> b.in - a.in == 0 ? a.ch - b.ch : b.in - a.in);
        PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>(){
            @Override
            public int compare(Node a, Node b){
                if(a.in == b.in) return a.ch - b.ch;
                return b.in - a.in;
            }
        });
        for(int i = 0; i < 26; i++){
            if(count[i] != 0)
                pq.add(new Node(count[i], (char)('a'+i)));
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            List<Node> temp = new LinkedList<>();
            for(int i = 0; i < k; i++){
                if(!pq.isEmpty()){
                    Node nd = pq.poll();
                    sb.append(nd.ch);
                    nd.minusOne();
                    if(nd.in > 0) temp.add(nd);
                } else {
                    if(temp.size() == 0) return sb.toString();
                    return "";
                } 
            }
            for(Node nd : temp) {
                pq.add(nd);
            }
        }
        return sb.toString();
    }
}
