import java.util.*;

class Solution {
  /**
   * Sorts a list of words using MSD radix sort.
   *
   * @param words
   *     The list of words to sort.
   * @return The sorted list of words.
   * @throws NullPointerException
   *     If `words` equals `null`.
   */
  static List<String> radixSortMSD(List<String> words) {
    return sortHelper(words,0);
  }
  
  
  static List<String> sortHelper(List<String> words,int index) {
     if (words == null) {
      throw new NullPointerException();
    }
    List<String>[] buckets =(ArrayList<String>[]) new ArrayList[27];
    for (int i = 0; i < buckets.length; i++) {
      buckets[i] = new ArrayList<String>();
    }
    
    for (int i = 0; i < words.size() ; i++) {
      String tempWord = words.get(i);
      if (tempWord.length() <= index) {
        buckets[0].add(tempWord);
        continue;
      }
      char sortValue = Character.toLowerCase(tempWord.charAt(index));
      int indexValue = (int)sortValue - 96;
      
      buckets[indexValue].add(tempWord);
    }
    
    if (words.size() == buckets[0].size()) {
      return words;
    }
    
    
    List<String> result = new ArrayList<String>();
    index++;
    for (int i = 0; i < buckets.length; i++) {
      buckets[i] = sortHelper(buckets[i],index);
      for(int j = 0; j < buckets[i].size() ; j++) {
        result.add(buckets[i].get(j));
      }
      
    }
    
    return result;
    
  }
}


