import java.util.*;

class Solution {
  /**
   * Sorts a list of Dutch mobile phone numbers using LSD radix sort.
   *
   * @param phoneNumbers
   *     The list of phone numbers to sort.
   * @return The sorted list of phone numbers.
   * @throws NullPointerException
   *     If `phoneNumbers` equals `null`.
   */
  static List<String> radixSortLSD(List<String> phoneNumbers) {
    int maxLength = 0;
    for (int i = 0; i < phoneNumbers.size() ; i++) {
      String temp = phoneNumbers.get(i);
      if (temp.length() > maxLength ) {
        maxLength = temp.length();
      }
    }
    
    List<String> result = phoneNumbers;
    
    for (int i = maxLength ; i >= 1; i--) {
      result = sortHelper(result,i);
    }
    return result;
    
  }
  
  
  static List<String> sortHelper(List<String> numberList,int index) {
    ArrayList<String>[] bucket = new ArrayList[11];
    for (int i = 0 ; i < bucket.length; i++) {
      bucket[i] = new ArrayList<String>();
    }
    
    for (int i = 0 ; i < numberList.size() ; i++ ) {
      String temp = numberList.get(i);
      if (temp.length() < index) {
        bucket[0].add(temp);
      } else {
        char value = temp.charAt(index-1);
        int bucketPosition = Character.getNumericValue(value);
        bucket[bucketPosition+1].add(temp);
      }
    }
    
    ArrayList<String> tempList = new ArrayList<String>();
    
    for (int i = 0 ; i < bucket.length ; i ++) {
      tempList.addAll(bucket[i]);
    }
    
    return tempList;
    
    
  }
}


