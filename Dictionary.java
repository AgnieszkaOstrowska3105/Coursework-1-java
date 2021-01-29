public class Dictionary {
  
  private StringArray dictionary;
  
  public Dictionary(){
    dictionary = readFile();
 }
 
 
  public StringArray readFile(){
    StringArray words = new StringArray();
    FileInput input = new FileInput("british-english");
    while (input.hasNextLine()) {
      String s = input.nextLine();
      words.add(s);
    }
    return words;
  }
  
  
  
  
  
  //to create an object --> Dictionary dictionary = new Dictionary(fileInput)
  
}
