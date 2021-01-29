public class Sentence {
  private String word;
  
  
  public Sentence(){
    word = new String();
  }
  
  
  public void myDictionary() {
    Dictionary dictionary = new Dictionary();
  }
  
  
  public void readFile(){
    myDictionary(); //created an object to which I can refer when checking the spelling
    FileInput input = new FileInput("sentence.txt");
    while(input.hasNextChar()){
      isLetter(input.nextChar());
    }
  }
  
  
  public void isLetter(char c){
    if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')){
      concatWord((c));
    }
    else if (c == ' '){
      checkWord();
      newWord();
    }
  }
  
  
  public void concatWord(char c){
    word += c;
  }
  
  
  public void checkWord(){
    if (!dictionary.contains(word)) writeToFile();
  }
  
  
  public void newWord(){
    word = "";
  }
  
  
  public void writeToFile(){
    FileOutput out = new FileOutput("reversed.txt");
    out.writeString(word);
    out.writeString(", ");
  }
  
  
  public void go(){
    this.readFile();
  }
}
