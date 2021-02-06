
import java.util.Arrays;

public class StringArray {
  
  private String[] string_array;
  private int size;
  
  
  public StringArray() {
    string_array = new String[100];
    size = 0;
  }
  
  
  public StringArray(StringArray a) {
    int space = (int) (0.1 * a.string_array.length);
    this.string_array = Arrays.copyOf(a.string_array, (a.string_array.length + space));
  }
  
  
  public int size() {
    return this.size;
  }
  
  
  private void incrementSize() {
    this.size++;
  }
  
  
  private void decrementSize() {
    this.size--;
  }
  
  public boolean isEmpty() {
    return this.size() == 0;
  }
  
  
  public String get(int index) {
    if (index > this.size() - 1 || index < 0) return null;
    else return string_array[index];
  }
  
  
  public void set(int index, String s) {
    if (index < 0 || index > this.size() - 1) {
      //do nothing
    } else putString(index, s);
  }
  
  
  private void enlargeArray() {
    StringArray array = new StringArray(this);
    this.string_array = array.string_array;
  }
  
  
  private void putString(int i, String s){
    string_array[i] = s;
  }
  
  
  public void add(String s) {
    
    if (this.size() == string_array.length) {
      enlargeArray();
    }
    incrementSize();
    putString((this.size()-1), s);
  }
  
  
  public void insert(int index, String s) {
    if (this.size() == string_array.length) {
      enlargeArray();
    }
    if (this.isEmpty()) {
      putString(0, s);
      incrementSize();
    }
    //if index is not out of range
    else if (!(index < 0 || index > this.size() - 1)) {
      incrementSize();
      shiftArrayToRight(index, s);
      putString(index, s);
    }
  }
  
  
  //make space for a string to be inserted
  private void shiftArrayToRight(int indexOfinsert, String s) {
    for (int i = this.size() - 1; i > indexOfinsert; i--) {
      string_array[i] = string_array[i - 1]; //can use putstring here
    }
  }
  
  
  private void shiftArrayToLeft(int removed) {
    System.out.println("this is removed: " + removed);
    for (int i = removed; i < this.size() - 1; i++) {
      string_array[i] = string_array[i + 1];
    }
    string_array[this.size() - 1] = null;
  }
  
  //might add feature to decrease the array
  public void remove(int index) {
    if (this.size() == 1) {
      string_array[0] = null;
    }
    else if (!(index < 0 || index > this.size() - 1)) {
      shiftArrayToLeft(index);
    }
    decrementSize();
  }
  
  private String toLowerCase(String s) {
    String result;
    if (!(s == null)) {
      result = s.toLowerCase();
    } else result = s;
    return result;
  }
  
  
  private boolean compare(String s1, String s2) {
    return (s1 == null ? s2 == null : s1.equals(s2));
  }
  
  //can be done with binary search to make more efficient
  public boolean contains(String s) {
    int i;
    int contains = 0;
    for (i = 0; i < this.size(); i++) {
      if (compare(toLowerCase(s), toLowerCase(string_array[i]))) {
        contains = 1;
        break;
      }
    }
    return (contains == 1);
  }
  
  
  public boolean containsMatchingCase(String s) {
    int i;
    int contains = 0;
    for (i = 0; i < this.size(); i++) {
      if (compare(s, string_array[i])) {
        contains = 1;
        break;
      }
    }
    return (contains == 1);
    
  }
  
  
  public int indexOf(String s) {
    int result = 0;
    if (!this.contains(toLowerCase(s))) result = -1;
    else {
      for (int i = 0; i < this.size(); i++) {
        if (compare(toLowerCase(s), toLowerCase(string_array[i]))) {
          result = i;
          break;
        }
      }
    }
    return result;
  }
  
  
  public int indexOfMatchingCase(String s) {
    int result = 0;
    if (!this.containsMatchingCase(s)) result = -1;
    else {
      for (int i = 0; i < this.size(); i++) {
        if (compare(s, string_array[i])) {
          result = i;
          break;
        }
      }
    }
    return result;
  }
}



