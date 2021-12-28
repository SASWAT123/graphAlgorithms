import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphAlgorithms {

    //Create an adjacency list to store the undirected graph
    List<List<Integer>>adj = new ArrayList<>();

    //Visited array to keep track of visited nodes
    List<Integer>visited = new ArrayList<>();

    //Number of vertices
    int vertices;

    public GraphAlgorithms(int v){
        this.vertices = v;

        for(int i = 0; i < v; i++){
            adj.add(new LinkedList<>());
            visited.add(0);
        }
    }

    public void addEdge(int u, int v){
        adj.get(u).add(v);
    }

    public static void main(String[] args) {
        int vertices = 5;
        GraphAlgorithms graph = new GraphAlgorithms(vertices);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 0);
        graph.addEdge(1, 3);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(3, 2);
        graph.addEdge(4, 2);
        graph.addEdge(4, 3);

        for(int i = 0; i < vertices; i++){
            System.out.println(graph.adj.get(i).toString());
        }
    }

}
