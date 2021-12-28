import java.util.*;

public class GraphAlgorithms {

    //Create an adjacency list to store the undirected graph
    List<List<Integer>>adj = new ArrayList<>();

    //Visited array to keep track of visited nodes
    List<Integer>visited = new ArrayList<>();

    //Queue to keep track of vertices during BFS
    Queue<Integer> queue = new LinkedList<>();

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
        adj.get(v).add(u);
    }

    //1. Breadth First Traversal of a graph
    public void bfs(){
        while(!queue.isEmpty()){
            int currentNode = queue.poll();
            if(visited.get(currentNode) != 1){
                System.out.print(currentNode + "-> ");
                visited.set(currentNode, 1);
                queue.addAll(adj.get(currentNode));
            }
        }
    }

    //2. Depth First Search Traversal
    public void dfs(int i){
        visited.set(i, 1);
        System.out.print(i + "-> ");
        for(Integer neighbor : adj.get(i)){
            if(visited.get(neighbor) != 1){
                dfs(neighbor);
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        GraphAlgorithms graph = new GraphAlgorithms(vertices);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        System.out.println("Printing the above graph");
        for(int i = 0; i < vertices; i++){
            System.out.println(graph.adj.get(i).toString());
        }

        //BFS Traversal
        System.out.println("\n");
        System.out.println("The BFS traversal of the graph is: ");
        graph.queue.add(0);
        graph.bfs();

        //DFS Traversal
        System.out.println("\n");
        System.out.println("The DFS traversal of the graph is: ");
        //Reinitialise the visited array for the DFS traversal
        Collections.fill(graph.visited, 0);
        for(int i = 0; i < graph.visited.size(); i++){
            if(graph.visited.get(i) != 1){
                graph.dfs(i);
            }
        }

    }

}
