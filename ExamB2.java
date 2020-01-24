import java.util.*;

class Solution {
  /**
   * Counts the number of vertices in the same connected component as v in graph g.
   * This is done using breadth first search.
   *
   * Returns 0 if the graph or vertex is null
   *
   * @param g
   *     The graph to count vertices in.
   * @param v
   *     The vertex to start counting at.
   * @return the number of vertices in the same connected component.
   */
  public static int countVertices(Graph g, Graph.Vertex v) {
    if (g == null || v == null) {
      return 0;
    }
    Queue<Graph.Vertex> queue = new LinkedList<Graph.Vertex>();
    queue.add(v);
    Set<Graph.Vertex> colored = new HashSet<Graph.Vertex>();
    colored.add(v);
    int count = 0;
    while(queue.peek() != null) {
      
      Graph.Vertex temp = queue.poll();
      count++;
      List<Graph.Vertex> list = g.getNeighbours(temp);
      for (int i = 0 ; i < list.size() ; i++) {
        if (!colored.contains(list.get(i))) {
          queue.add(list.get(i));
          colored.add(list.get(i));
        }
      }
    }
    
    return count;
  }
}


