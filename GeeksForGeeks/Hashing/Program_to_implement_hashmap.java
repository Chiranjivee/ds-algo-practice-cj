class Solution { 
    class TableNode {
        Integer data;
        TableNode next;

        public TableNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    class HashTable {
        double loadFactor = 0.75;
        TableNode [] table;
        int elementCount;

        public HashTable() {
            this.table = new TableNode[100];
        }

        public Integer getKey(Integer key) {
            int index = hashKey(key.hashCode()) % table.length;
            System.out.println("Calculated index: " + index + " Value at index: "  + table[index].data);
            if (table[index] == null) return null;
            else
            {
                TableNode cur = table[index];
                while (true)
                {
                    if (cur.data.equals(key)) return cur.data;
                    if (cur.next == null) break;
                    cur = cur.next;
                }

                return null;
            }
        }

        public boolean contains(Integer key) {
            int index = hashKey(key.hashCode()) % table.length;
            if (table[index] == null) return false;
            else
            {
                TableNode cur = table[index];
                while (true)
                {
                    if (cur.data.equals(key)) return true;
                    if (cur.next == null) break;
                    cur = cur.next;
                }

                return false;
            }
        }

        public void putKey(Integer key) {
            if (elementCount > table.length * loadFactor) resize();
        
            int index = hashKey(key.hashCode()) % table.length;
            TableNode newNode = new TableNode(key);
            if (table[index] == null) {
                table[index] = newNode;
                elementCount++;
            }  else {
                TableNode cur = table[index];
                while (true)
                {
                    if (cur.next == null) break;
                    cur = cur.next;
                }
                cur.next = newNode;
                elementCount++;
            }
        }

        public int hashKey(int h) {
            h ^= (h >>> 20) ^ (h >>> 12);
            return h ^ (h >>> 7) ^ (h >>> 4);
        }

        public void resize() {
            int newSize = table.length * 2;
            TableNode[] newTable = new TableNode[newSize];
            for (int i = 0; i < table.length; i++) newTable[i] = table[i];
            this.table = newTable;
        }
    }

    public void execute() {
        HashTable table = new HashTable();
        int [] keys = {90890, 23, 876, 9876, 10000};
        for (int i = 0; i < keys.length; i++) 
            table.putKey(keys[i]);

        int [] input = {56, 23, 876, 9876, 10000, 90890, 9089, 3456, 0};
        long currentTimeInMilis = System.currentTimeMillis();
        for (int i = 0; i < input.length; i++) {
            System.out.println("Contains: " + input[i] + " " + table.contains(input[i]) + ". Time taken: " + (System.currentTimeMillis() - currentTimeInMilis));
            currentTimeInMilis = System.currentTimeMillis();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.execute();
    }
}