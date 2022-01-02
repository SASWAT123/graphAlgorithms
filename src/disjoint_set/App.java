package disjoint_set;

public class App {

    public static void main(String[] args) throws Exception {

        //QuickFind Implementation
        QuickFind uf = new QuickFind(10);
        // 1-2-5-6-7 3-8-9 4
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        System.out.println(uf.connected(1, 5)); // true
        System.out.println(uf.connected(5, 7)); // true
        System.out.println(uf.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        System.out.println(uf.connected(4, 9)); // true

        System.out.println("------------------------------------------------------------------");
        //QuickUnion Implementation
        QuickUnion qu = new QuickUnion(10);
        // 1-2-5-6-7 3-8-9 4
        qu.union(1, 2);
        qu.union(2, 5);
        qu.union(5, 6);
        qu.union(6, 7);
        qu.union(3, 8);
        qu.union(8, 9);
        System.out.println(qu.connected(1, 5)); // true
        System.out.println(qu.connected(5, 7)); // true
        System.out.println(qu.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        qu.union(9, 4);
        System.out.println(qu.connected(4, 9)); // true

        System.out.println("------------------------------------------------------------------");
        //This optimisation works on top of QuickUnion approach
        UnionRank ufr = new UnionRank(10);
        // 1-2-5-6-7 3-8-9 4
        ufr.union(1, 2);
        ufr.union(2, 5);
        ufr.union(5, 6);
        ufr.union(6, 7);
        ufr.union(3, 8);
        ufr.union(8, 9);
        System.out.println(ufr.connected(1, 5)); // true
        System.out.println(ufr.connected(5, 7)); // true
        System.out.println(ufr.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        ufr.union(9, 4);
        System.out.println(ufr.connected(4, 9)); // true
    }
}
