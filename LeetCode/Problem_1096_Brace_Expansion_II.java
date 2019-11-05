class Solution {
    public List<String> braceExpansionII(String expression) {
       String s = expression;
       char preSign = ',';
       Stack<List<String>> stack = new Stack<>();// Save List<String>
       for (int i = 0; i < s.length(); i++){
           char c = s.charAt(i);
           // case 1. {...} recursive, stack.operate(resList) by preSign
           if (c == '{'){
               int j = i, p = 1;
               while (s.charAt(j) != '}' || p != 0){
                   j++;
                   if (s.charAt(j) == '{') p++;
                   if (s.charAt(j) == '}') p--;
               }
               List<String> slist = braceExpansionII(s.substring(i+1, j));
               if (preSign == '*'){
                   stack.push(merge(stack.pop(), slist));
               }
               else stack.push(slist);
               i = j;
   			//default preSign is *
               preSign = '*';
           }
           // case 2 letter operate by preSign
           else if (Character.isLetter(c)){
               List<String> slist = new ArrayList<>();
               slist.add(""+c);
               if (preSign == '*'){
                   stack.push(merge(stack.pop(), slist));
               }
               else stack.push(slist);
   			// //default preSign is *
               preSign = '*';
           }
           // case 3. if  == ", ", preSign is  plus, (default preSign is *);
           if (c ==',' || i == s.length()-1){
               preSign = ',';
           }
       }
       // output stack to one dimesion list;
       List<String> res = new ArrayList<>();
       while(!stack.isEmpty()){
           for (String l : stack.pop())
               if (!res.contains(l))res.add(l);
       }
   	// sort by lexi-order
       Collections.sort(res);
       return res;
   }
   // multiply operation of 2 List<letter>
   public List<String> merge(List<String> list1, List<String> list2){
       List<String> res = new ArrayList<>();
       for (String l1 : list1){
           for (String l2 : list2){
               res.add(l1+l2);
           }
       }
       return res;
   }
}