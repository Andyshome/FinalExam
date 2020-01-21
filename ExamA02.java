import java.util.*;

class Solution {
  /**
   * Counts the number of vertices in the same connected component as v in graph g.
   * This is done using depth first search.
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
    
    Set<Graph.Vertex> colored = new HashSet<Graph.Vertex>();
    Stack<Graph.Vertex> stack = new Stack<Graph.Vertex>();
    stack.push(v);
    int count =0;
    while(stack.empty() == false) {
      Graph.Vertex temp = stack.pop();
      colored.add(temp);
      count++;
      List<Graph.Vertex> tempList = g.getNeighbours(temp);
      for (Graph.Vertex tempVertex:tempList) {
        if (!colored.contains(tempVertex)) {
          stack.push(tempVertex);
          colored.add(tempVertex);
        }
      }
    }
    
    
    return count;
    
    
    
    
    
    
    
    
    
    
    
  }
}


