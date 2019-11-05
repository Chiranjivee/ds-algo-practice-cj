class Solution {
    private int width = 5; // 'abcde'
    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        int[] curLocation = new int[2], nextLocation = null;
        int charVal = 0;
        for(int i = 0; i < target.length(); ++i) {
            charVal = target.charAt(i) - 'a';
            nextLocation = new int[] {charVal / width, charVal % width};
            moveToNextLocation(curLocation, nextLocation, sb);
            sb.append('!');
            curLocation = nextLocation;
        }
        
        return sb.toString();
    }
    
    private void moveToNextLocation(int[] source, int[] target, StringBuilder sb) {
        // alwasy move up down first.
        if(source[0] == 5) {
            move(target[0], source[0], 'U', sb);
            move(source[1], target[1], 'R', sb);
            
        } else if(target[0] == 5) {
            move(target[1], source[1],  'L', sb);
            move(source[0], target[0], 'D', sb);
            
        } else {
            move(Math.min(source[1], target[1]), Math.max(source[1], target[1]), source[1] < target[1] ? 'R' : 'L', sb);
            move(Math.min(source[0], target[0]), Math.max(source[0], target[0]), source[0] < target[0] ? 'D' : 'U', sb);
        }
    }
    
    private void move(int start, int end, char c, StringBuilder sb) {
        while(start < end) {
            sb.append(c);
            ++start;
        }
    }
}
