import java.util.Map;
import java.util.HashMap;

class DisjointSets {

    Map<Long, Node> hm = new HashMap<>();
    class Node {
        long data;
        Node parent;
        int rank;

        public Node(long data) {
            this.data = data;
            this.parent = this;
            this.rank = 0;
        }
    }

    long findSet(long data) {
        return findSet(hm.get(data)).data;
    }

    Node findSet(Node data) {
        if (data.parent == data) {
            return data;
        }

        return findSet(data.parent);
    }

    makeSet(long data) {
        hm.put(data, new Node(data));
    }

    void union(long data, long data2) {
        Node a = hm.get(data);
        Node b = hm.get(data2);

        Node parentA = findSet(data);
        Node parentB = findSet(data2);

        if (a.data == b.data) return;

        if (parentA.rank >= parentB.rank) {
            if (parentA.rank == parentB.rank) {
                parentA.rank += 1;
            }

            parentB.parent = parentA;
        } else {
            parentA.parent = parentB;
        }
    }

    public static void main(String[] args) {
        DisjointSets set = new DisjointSets();
        set.makeSet(1);
        set.makeSet(2);
        set.makeSet(3);
        set.makeSet(4);
        set.makeSet(5);
        set.makeSet(6);
        set.makeSet(7);
        set.makeSet(8);
        set.makeSet(9);
        set.makeSet(10);

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        ds.union(3, 7);
        ds.union(8, 9);
        ds.union(9, 10);

        System.out.println("Parent of 1 is: " + set.findSet(1));
        System.out.println("Parent of 2 is: " + set.findSet(2));
        System.out.println("Parent of 3 is: " + set.findSet(3));
        System.out.println("Parent of 4 is: " + set.findSet(4));
        System.out.println("Parent of 5 is: " + set.findSet(5));
        System.out.println("Parent of 6 is: " + set.findSet(6));
        System.out.println("Parent of 7 is: " + set.findSet(7));
        System.out.println("Parent of 8 is: " + set.findSet(8));
        System.out.println("Parent of 9 is: " + set.findSet(9));
    }

}