import java.util.*;

class DisjointSets {
    HashMap<Integer, DisjointSetNode> map = new HashMap<>();

    boolean hasNode(int data) {
        return this.map.containsKey(data);
    }

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

public class Main {

    public static void main(String[] args) {
        // Write our code here
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            List<Query> queries = new ArrayList<>();
            for (int j = 0; j < q; j++) {
                queries.add(new Query(sc.nextInt(), sc.nextInt(), sc.nextInt()));
            }

            System.out.println(solve(n, q, queries));
        }
    }

    public static String solve(int n, int q, List<Query> queries) {

        DisjointSets set = new DisjointSets();
        int[] arr = new int[n];
        int i = 0;

        // iterate on the queries and figure out zero value queries and fill
        // 3 on the array at those places.
        List<Query> oneQueries = new ArrayList<>();
        for (Query query : queries) {
            if (!set.hasNode(query.i)) {
                set.makeSet(query.i);
            }
            if (!set.hasNode(query.j)) {
                set.makeSet(query.j);
            }

            if (query.val == 0) {
                set.union(query.i, query.j);
            } else {
                oneQueries.add(query);
            }
        }

        for (Query query : oneQueries) {
            // check all i j are in different sets
            int a = query.i;
            int b = query.j;
            if (set.findSet(a) == set.findSet(b)) {
                return "no";
            }
        }

        return "yes";
    }

    public static boolean solveUtil(int[] arr, int i, int q, List<Query> queries) {
        // array is filled.
        if (i == arr.length) {
            return true;
        }
        return false;
    }
}

class Query {
    int i, j, val;

    public Query(int i, int j, int val) {
        this.i = i;
        this.j = j;
        this.val = val;
    }
}