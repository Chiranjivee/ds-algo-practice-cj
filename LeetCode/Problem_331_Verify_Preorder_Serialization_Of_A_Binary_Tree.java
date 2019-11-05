class Solution {
    int index = 0;
    public boolean isValidSerialization(String preorder) {
        String[] sarr = preorder.split(",");
        preorder(sarr);
        if (index != sarr.length - 1) {
            return false;
        }
        return true;
    }
    
    private String preorder(String[]sarr) {
        if (index >= sarr.length || sarr[index].equals("#")) {
            return null;
        }

        String node = sarr[index];

        index++;
        preorder(sarr);

        index++;
        preorder(sarr);

        return node;
    }
}
