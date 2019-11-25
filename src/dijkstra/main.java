package dijkstra;

public class main 
{
	public static void main(String[] args) 
	{
		Graph g = new Graph(4);
        g.input("a1", "a2", 3);
        g.input("a1", "a4", 4);
        g.input("a2", "a3", 2);
        g.dijkstra(1);
	}
}
