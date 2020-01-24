import java.util.*;

class Solution {
  /**
   * @param g
   *     The graph to search in.
   * @param v
   *     The vertex to start searching from.
   * @param n
   *     The number of edges n that can be traversed from v.
   * @return The number of vertices that are reachable from v (including v), using at most n edges.
   */
  static int countVertices(Graph g, Vertex v, int n) {
    
    
    int count = 0;
    
    Queue<Vertex> queue = new LinkedList<Vertex>();
    Set<Vertex> colored = new HashSet<Vertex>();
    queue.add(v);
    colored.add(v);
    count++;
    for (int i = 0; i <n ; i++) {
      if (queue.peek() == null) {
        break;
      }
      Queue<Vertex> currentSearching = queue;
      queue = new LinkedList<Vertex>();
      while(currentSearching.peek() != null) {
        Vertex temp = currentSearching.poll();
        List<Vertex> tempList = g.getNeighbours(temp);
        for (Vertex index : tempList) {
          if (!colored.contains(index)) {
            colored.add(index);
            queue.add(index);
            count++;
          }
        }
      }
    }
    return count;
  }
}


