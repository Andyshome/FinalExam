class SolutionHashTable {
  public Entry[] table;
  public int capacity;

  /**
   * Constructs a new HashTable.
   *
   * Capacity of the hash table can not be 0 or negative.
   *
   * @param capacity
   *     to be used as capacity of the table.
   * @throws IllegalArgumentException
   *     if the input capacity is invalid.
   */
  public SolutionHashTable(int capacity) {
    if (capacity <= 0  ) {
      throw new IllegalArgumentException();
    } else {
        this.capacity = capacity;
        this.table = new Entry[capacity];
    }
  }

  /**
   * Add a new Entry to the hash table,
   * uses linear probing to deal with collisions.
   *
   * Returns false, if the key is null or the table is full.
   *
   * @param key
   *     String representing the key of the entry.
   * @param value
   *     String representing the value of the entry.
   * @return true iff entry has been added successfully, else false.
   */
  public boolean put(String key, String value) {
    if (key == null) {
      return false;
    }
    int hashValue = hash(key);
    
    
    
    for (int i = 0 ; i < table.length ; i++ ) {
      int index = (hashValue + i) % capacity;
      if (table[index] != null && table[index].getKey() != null &&table[index].getKey().equals(key)  ) {
        table[index] = new Entry(key,value);
        return true;
      } 
      if (table[index] == null || table[index].getKey() == null ) {
        table[index] = new Entry(key,value);
        return true;
      } 
    }
    
    return false;
    
    
    
  }

  /**
   * Retrieve the value of the entry associated with this key.
   *
   * Returns null, if the key is null.
   *
   * @param key
   *     String representing the key of the entry to look for.
   * @return value of the entry as String iff the entry with this key is found in the hash table, else null.
   */
  public String get(String key) {
    if (key == null) {
      return null;
    }
    int hashValue = hash(key);
    for (int i = 0 ; i < table.length ; i++ ) {
      int index = (hashValue + i) % capacity;
      
      if (table[index] != null && table[index].getKey() != null &&table[index].getKey().equals(key) ) {
        return table[index].getValue();
      } 
    }
    return null;
  }

  /**
   * Remove the entry associated with this key from the hash table.
   *
   * Returns false, if the key is null.
   *
   * @param key
   *     String representing the key of the entry to remove.
   * @return true iff the entry has been successfully removed, else false.
   */
  public boolean remove(String key) {
    if (key == null) {
      return false;
    }
    
    int hashValue = hash(key);
    for (int i = 0 ; i < table.length ; i++ ) {
      int index = (hashValue + i) % capacity;
      
      if (table[index] != null && table[index].getKey() != null &&table[index].getKey().equals(key)  ) {
        setDefunct(index);
        return true;
      } 
    }
    return false;
  }

  /**
   * Takes as input an index and sets the entry in that location as defunct.
   *
   * @param index
   *     The index of the spot that is defunct.
   */
  public void setDefunct(int index) {
    this.table[index] = new Entry(null, null);
  }
  
  /**
   * Hashes a string representing a key.
   *
   * @param key
   *     String that needs to be hashed.
   * @return the hashcode of the string, modulo the capacity of the HashTable.
   */
  public int hash(String key) {
    return Math.abs(key.hashCode()) % capacity;
  }
}


