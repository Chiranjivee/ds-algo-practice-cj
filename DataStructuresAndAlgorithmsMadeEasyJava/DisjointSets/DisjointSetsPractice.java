import java.util.HashMap;

class DisjointSets {
    HashMap<Integer, DisjointSetNode> map = new HashMap<>();

    int findSet(int data) {
        return findSet(map.get(data)).data;
    }

    DisjointSetNode findSet(DisjointSetNode node) {
        if (node.parent == node) {
            return node;
        }

        return findSet(node.parent);
    }

    void makeSet(int data) {
        DisjointSetNode node = new DisjointSetNode(data);
        this.map.put(data, node);
    }

    void union(int data, int data2) {
        DisjointSetNode dataNode = map.get(data);
        DisjointSetNode dataNode2 = map.get(data2);

        DisjointSetNode dataNodeParent = findSet(dataNode);
        DisjointSetNode dataNode2Parent = findSet(dataNode2);

        if (dataNodeParent == dataNode2Parent) {
            return;
        }
        if (dataNodeParent.rank >= dataNode2Parent.rank) {
            if (dataNodeParent.rank == dataNode2Parent.rank) {
                dataNodeParent.rank += 1;
            } 

            dataNode2Parent.parent = dataNodeParent;
        } else {
            dataNodeParent.parent = dataNode2Parent;
        }
    }
    public static void main(String[] args) {
        DisjointSets set = new DisjointSets();
        set.makeSet(1);
        set.makeSet(2);
        set.makeSet(3);
        set.makeSet(4);
        set.makeSet(5);

        set.union(1, 2);
        set.union(3, 4);
        set.union(4, 5);

        System.out.println("Rank of 5:" + set.findSet(5));
    }
}

class DisjointSetNode {
    int data;
    DisjointSetNode parent;
    int rank;

    public DisjointSetNode(int data) {
        this.data = data;
        this.parent = this;
        this.rank = 0; 
    }
}