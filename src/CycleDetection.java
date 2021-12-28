import java.util.*;

class Pair{
    int first;
    int second;

    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }
}

public class CycleDetection {

    int vertices;

    //Create an adjacency list to store the undirected graph
    List<List<Integer>>adj = new ArrayList<>();

    //Visited array to keep track of visited nodes
    List<Integer>visited = new ArrayList<>();

    //Queue to keep track of nodes during BFS
    Queue<Pair>queue = new LinkedList<>();

    public CycleDetection(int vertices){
        this.vertices = vertices;

        //Initialise a list of linkedList to represent the adjacency list
        for(int i = 0; i < vertices; i++){
            adj.add(new LinkedList<>());

            //Initialise the visited list with all 0's
            visited.add(0);
        }
    }

    public void addEdge(int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    //1. Cycle detection using BFS
    public boolean detectCycle(){

        queue.add(new Pair(0, -1));
        while(!queue.isEmpty()){
            Pair node = queue.poll();
            int currentNode =node.getFirst();
            int currentNodeParent = node.getSecond();
            visited.set(currentNode, 1);

            for (Integer i : adj.get(currentNode)){
                if(visited.get(i) != 1){
                    visited.set(i, 1);
                    queue.add(new Pair(i, currentNode));
                }else if(i != currentNodeParent){
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int vertices  = 5;

        CycleDetection graph = new CycleDetection(vertices);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 1);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);

        System.out.println("Printing the above graph");
        for(int i = 0; i < vertices; i++){
            System.out.println(graph.adj.get(i).toString());
        }

        //Cycle detection using BFS
        System.out.println(graph.detectCycle());

    }

}
