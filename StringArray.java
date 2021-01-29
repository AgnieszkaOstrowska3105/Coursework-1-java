import java.util.Arrays;

public class StringArray {
  
  private String[] StringArray;
  
  
  
  public StringArray(){
    StringArray = new String[100];
  }
  
  
  public StringArray(StringArray a){
    this.StringArray = Arrays.copyOf(a.StringArray, (a.StringArray.length + 10));
  }
  
  
//  public String[] getArray(){
//    return this.StringArray;
//  }
  
  
  public int size(){
    int result = 0;
    for (int i=0; i<StringArray.length; i++){
      if (StringArray[0] == null) {
        result = 0;
        break;
      }
      else if (StringArray[i] == null) {
        result = i;
        break;
      }
      else if (i == StringArray.length-1) result = StringArray.length;
      }
    return result;
    }
    
    
  public boolean isEmpty(){
    return StringArray[0] == null;
  }
  
  
  public String get(int index){
    if (index > this.size() || index < 0) return null;
    else return StringArray[index];
  }
  
  
  public void set(int index, String s){
    if (index < 0 || index > this.size()){
      //do nothing
    }
    else StringArray[index] = s;
  }
  
  
  public void add(String s) {
    
    if (this.size() == StringArray.length) {
      StringArray array = new StringArray(this);
      this.StringArray = array.StringArray;
    }
    StringArray[this.size()] = s;
  }
  
  
  public void insert(int index, String s){
    if (this.size() == StringArray.length){
      StringArray array = new StringArray(this);
      this.StringArray = array.StringArray;
    }
    
    if (index < 0 || index > this.size()-1){
      //do nothing
    }
    else if (this.isEmpty()){
      StringArray[0] = s;
    }
    else {
      for(int i = this.size(); i>index; i--){
        StringArray[i] = StringArray[i-1];
      }
      StringArray[index] = s;
    }
  }
  
  
  //might add feature to decrease the array
  public void remove(int index){
    if (index < 0 || index > this.size()-1){
      //do nothing
    }
    if (this.size() == 1){
      StringArray[0] = null;
    }
    for(int i = this.size()-2; i>index-1; i--){
      StringArray[i] = StringArray[i+1];
    }
    StringArray[this.size()-1] = null;
  }
  
  
  //can be done with binary search to make more efficient
  public boolean contains(String s){
    String string = s.toLowerCase();
    int i;
    for(i=0; i<this.size()+1; i++){
      if (string.equals(StringArray[i].toLowerCase())) break;
    }
    return (!(i >= this.size()));
  }
  
  
  public boolean containsMatchingCase(String s){
    int i;
    for(i=0; i<this.size()+1; i++){
      if (s.equals(StringArray[i])) break;
    }
    return (!(i >= this.size()));
  }
  
  
  public int indexOf(String s){
    String string = s.toLowerCase();
    int result = 0;
    if(!contains(string)) result = -1;
    else{
      for(int i=0; i<this.size()+1; i++) {
        if (string.equals(StringArray[i].toLowerCase())) {
          result = i;
          break;
        }
      }
    }
    return result;
  }
  
  
  public int indexOfMatchingCase(String s){
    int result = 0;
    if(!containsMatchingCase(s)) result = -1;
    else{
      for(int i=0; i<this.size()+1; i++) {
        if (s.equals(StringArray[i])) {
          result = i;
          break;
        }
      }
    }
    return result;
  }
  
  
  
  
  
  
  
  
  
  /*public static void main(String[] args) {
    StringArray check = new StringArray();
    check.add("kasia");
    System.out.println("this is size: " + check.size());
    check.add("Martyna");
    check.add("martyna");
    check.add("krystian");
    check.add("lukasz");
    check.add("Pola");
    System.out.println(check);
    System.out.println(check.size());
    System.out.println("is empty? " + check.isEmpty() + "\n");
    System.out.println("get index 3 " + check.get(3) + "\n");
    check.insert(0, "Aga");
    System.out.println("Aga inserted at position 0 " + Arrays.toString(check.StringArray) + "\n");
    check.remove(5);
    System.out.println("index 5 removed " + Arrays.toString(check.StringArray) + "\n");
    System.out.println("contains Kasia? " + check.contains("Kasia") + "\n");
    System.out.println("containsmatchingcase Pola? " + check.containsMatchingCase("pola") + "\n");
    System.out.println("index of Martyna: " + check.indexOf("martyna") + "\n");
    System.out.println(("index of Krystian: ") + check.indexOfMatchingCase("Krystian") + "\n");
  }
  */
}


