import java.util.*;
class Solution {
  /**
   * Given a Binary Search Tree and an Integer, returns the Entry in this tree
   * with the smallest key that is strictly larger than k.
   *
   * @param tree
   *     Binary search tree to search in.
   * @param k
   *     The key of the resulting entry should be strictly larger than this k.
   * @return The entry with smallest key, strictly larger than k.
   */
  static Entry higherEntry(BinarySearchTree tree, int k) {
    if (tree == null) {
      return null;
    }
    Stack<BinarySearchTree> stack = new Stack<BinarySearchTree>();
    stack.push(tree);
    BinarySearchTree result = null;
    while(!stack.empty()) {
      BinarySearchTree temp = stack.pop();
      if (temp.hasLeft()){
        stack.push(temp.getLeft());
      } 
      if (temp.hasRight()){
        stack.push(temp.getRight());
      }
      int tempValue = temp.getKey();
      if(tempValue > k) {
        if (result == null) {
          result = temp;
        } else if (tempValue < result.getKey()) {
          result = temp;
        }
      }
      
    }
    if (result == null) {
      return null;
    }
    return result.getEntry();
  }
  
}


