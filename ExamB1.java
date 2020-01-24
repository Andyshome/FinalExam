
class Solution {
  /**
   * Counts the number of nodes with an event number of children.
   *
   * @param tree
   *     The tree to count nodes with an even number of children in.
   * @return the number of nodes with an even number of children, or 0 if tree is null.
   */
  public static int countNodesEvenChildren(LibraryTree tree) {
      if (tree == null) {
        return 0;
      }
      int result = 0;
      Queue<LibraryTree> treeQueue = new LinkedList<LibraryTree>();
      
      treeQueue.add(tree);
      
      while(treeQueue.peek() != null) {
        LibraryTree tempTree = treeQueue.poll();
        List<LibraryTree> treeList = tempTree.getChildren();
        int count = treeList.size();
        for (int i = 0 ; i < count ; i++) {
          treeQueue.add(treeList.get(i));
        }
        
        
        
        
        if (count % 2 == 0) {
          result++;
        }
      }
      
      return result;
      
  }
}


