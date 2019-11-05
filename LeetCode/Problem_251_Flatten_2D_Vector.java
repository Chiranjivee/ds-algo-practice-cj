/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(v);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
class Vector2D {
    int indexList, indexEle;
    List<List<Integer>> vec; 
    
    public Vector2D(int [][] v) {
        List<List<Integer>> vec2d = new ArrayList<>();
        for (int i = 0; i < v.length; i++) {
            List<Integer> list = new ArrayList<>();
            vec2d.add(list);
            for (int j = 0; j < v[i].length; j++) {
                vec2d.get(i).add(v[i][j]);
            }
        }

        indexList = 0;
        indexEle = 0;
        vec = vec2d;
    }

    public int next() {
        hasNext();
        return vec.get(indexList).get(indexEle++);
    }

    public boolean hasNext() {
        while(indexList < vec.size()){
            if(indexEle < vec.get(indexList).size())
                return true;
            else{
                indexList++;
                indexEle = 0;
            }
        }
        return false;
    }
}
