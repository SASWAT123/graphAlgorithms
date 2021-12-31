package disjoint_set;

//This is a representation of the Quick Find - Disjoint Set
//Time Complexity - Union-find Constructor - O(N)
//Time Complexity - Find - O(1)
//Time Complexity - Union - O(N)
//Time Complexity - Connected - O(1)

import java.util.Arrays;

public class QuickFind {
    private int[] root;

    public QuickFind(int size){
        root = new int[size];
        for(int i = 0; i < size; i++){
            root[i] = i;
        }
    }

    public int find(int element){
        return root[element];
    }

    public void union(int x, int y){
        int rootx = find(x);
        int rooty = find(y);

        if(rootx != rooty){
            for(int i = 0; i < root.length; i++){
                if(root[i] == rooty){
                    root[i] = rootx;
                }
            }
        }
    }

    public boolean connected(int x, int y){
        return root[x] == root[y];
    }
}

