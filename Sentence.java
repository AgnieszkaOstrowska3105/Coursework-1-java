public class Sentence {
  
  private String word;
  
  public Sentence(){
    word = new String();
  }
  
  
  public void readFile(){
    FileInput input = new FileInput("sentence.txt");
    while(input.hasNextChar()){
      isLetter(input.nextChar());
    }
    lastWord();
  }
  
  private void isLetter(char c){
    if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')){
      concatWord((c));
    }
    //if whitespace encountered --> the word is finished,
    // so I can check if it's in my dictionary and then assign to an empty string
    else if (Character.isWhitespace(c)){
      //if we have multiple consecutive whitespace characters they're ignored
      if (!(word == "")) {
        checkWord();
        emptyWord();
      }
    }
  }
  
  
  private void lastWord(){
    if (!word.equals("")){
      checkWord();
    }
  }
  
  
  private void concatWord(char c){
    word += c;
  }
  
  private void emptyWord() { word = ""; }
  
  
  private void checkWord(){
    StringArray sa = Dictionary.readFile();
    if (!sa.contains(word)) writeToFile();
  }
  
  
  private void writeToFile(){
    FileOutput out = new FileOutput("incorrect_words.txt", true);
    out.writeString(word);
    System.out.println("this is a word to be put in a file " + word);
    out.writeString(", ");
  }
  
}
