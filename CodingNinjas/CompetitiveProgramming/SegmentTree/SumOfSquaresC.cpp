#include <bits/stdc++.h> 
using namespace std; 

class TreeNode {
    public:
        long long sum = 0;
        long long sqSum = 0;
};

class LazyTreeNode {
    int type = -1;
    long long value;
};

TreeNode query(TreeNode[] tree, LazyTreeNode[] lazy, int low, int high, int startR, int endR, int currentPosition) {
        if (lazy[currentPosition] != null && lazy[currentPosition].type != -1) {
            if (lazy[currentPosition].type == 1) {
                // Update by incriment
                tree[currentPosition].sqSum += ((lazy[currentPosition].value * lazy[currentPosition].value)
                        * (high - low + 1) + (2 * lazy[currentPosition].value * tree[currentPosition].sum));

                tree[currentPosition].sum += (lazy[currentPosition].value * (high - low + 1));
            } else if (lazy[currentPosition].type == 0) {
                // Update by value.
                tree[currentPosition].sqSum = (lazy[currentPosition].value * lazy[currentPosition].value
                        * (high - low + 1));
                tree[currentPosition].sum = (lazy[currentPosition].value * (high - low + 1));
            }

            if (high != low) {
                lazy[2 * currentPosition] = new LazyTreeNode();
                lazy[2 * currentPosition].type = lazy[currentPosition].type;
                lazy[2 * currentPosition].value = lazy[currentPosition].value;

                lazy[(2 * currentPosition) + 1] = new LazyTreeNode();
                lazy[(2 * currentPosition) + 1].type = lazy[currentPosition].type;
                lazy[(2 * currentPosition) + 1].value = lazy[currentPosition].value;
            }
            lazy[currentPosition] = null;
        }
        // Fully outside
        if (startR > high || endR < low)
            return new TreeNode();
        // Fully overlap
        if (startR <= low && high <= endR)
            return tree[currentPosition];

        // Partially overlap
        int mid = (low + high) / 2;
        TreeNode left = query(tree, lazy, low, mid, startR, endR, currentPosition * 2);
        TreeNode right = query(tree, lazy, mid + 1, high, startR, endR, currentPosition * 2 + 1);
        TreeNode ans = new TreeNode();
        ans.sqSum = left.sqSum + right.sqSum;
        ans.sum = left.sum + right.sum;
        return ans;
    }

int main() { 
  
    // Declare an object of class geeks 
    Geeks obj1; 
  
    // accessing data member 
    obj1.geekname = "Abhi"; 
  
    // accessing member function 
    obj1.printname(); 
    return 0; 
} 

