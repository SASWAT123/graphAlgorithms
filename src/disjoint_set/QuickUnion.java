package disjoint_set;

//This is a representation of the Quick Find - Disjoint Set
//Time Complexity - Union-find Constructor - O(N)
//Time Complexity - Find - O(N)
//Time Complexity - Union - O(N)
//Time Complexity - Connected - O(N)

public class QuickUnion {

    private int[] root;

    public QuickUnion(int size){
        root = new int[size];
        for(int i= 0; i < size; i++){
            root[i] = i;
        }
    }

    public int find(int element){
        while(element != root[element]){
            element = root[element];
        }
        return element;
    }

    public void union(int x, int y){
        int rootx = find(x);
        int rooty = find(y);

        if(rootx != rooty){
            root[rooty] = rootx;
        }
    }

    public boolean connected(int x, int y){
        return root[x] == root[y];
    }

}
