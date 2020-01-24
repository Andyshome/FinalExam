class Solution {
  /**
   * @param list
   *     The singly linked list to sort.
   * @return A new singly linked list that contains the elements as the input list sorted in non-decreasing order.
   */
  static SLList insertionSort(SLList list) {
    if (list == null) {
      return null;
    }
    
    
    SLList result = new SLList();
    SLList helpList = new SLList();
  
    while(list.getFirst() != null) {
      int tempValue = list.removeFirst();
      while (result.getFirst() != null) {
        int indexValue = result.removeFirst();
        if (tempValue < indexValue) {
          helpList.addFirst(tempValue);
          tempValue = indexValue;
        } else {
          helpList.addFirst(indexValue);
        }
      }
      result.addFirst(tempValue);
      while(helpList.getFirst()!= null) {
        result.addFirst(helpList.removeFirst());
      }
    }
    
    return result;
    
    
  }
}


