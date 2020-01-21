import java.util.LinkedList;
import java.util.Queue;

class Solution {
  /**
   * Counts the number of nodes in the tree at a certain level.
   *
   * @param tree
   *     The binary tree to count nodes in.
   * @param level
   *     The specified level to count nodes in.
   * @return the number of nodes at that level, or 0 if tree is null.
   */
  public static int countNodesAtLevel(BinaryTree tree, int level) {
      if (tree == null) {
        return 0;
      } 
      Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
      queue.offer(tree);
      int count = 0;
      int myLevel = -1;
      while(level != myLevel) {
        count = 0;
        Queue<BinaryTree> tempQueue = new LinkedList<BinaryTree>();
        while(queue.peek() != null) {
          BinaryTree tempTree = queue.poll();
          count++;
          if (tempTree.hasLeft()) {
            tempQueue.add(tempTree.getLeft());
          }
          if (tempTree.hasRight()) {
            tempQueue.add(tempTree.getRight());
          }
        }
        queue = tempQueue;
        myLevel++;
      }
      return count;
  }
}


