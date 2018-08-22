class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> st = new Stack<>();
        Map<Character, Character> pair = new HashMap<>();
        pair.put(')', '(');
        pair.put('}', '{');
        pair.put(']', '[');
        
        
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            
            if (current == '(' || current == '{' || current == '[') {
                 st.push(current);   
            }
            
            else if (current == ')' || current == '}' || current == ']') {
                if (st.isEmpty() || st.peek() != pair.get(current)) 
                    return false;
                
                st.pop();
            }
        }
        
        return st.isEmpty() ? true : false;
    }
}
