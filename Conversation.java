import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

class Conversation {
  
  private int round;
  private ArrayList<String> transcript;


  public Conversation(int a){
    this.round = a;
    this.transcript = new ArrayList<>();
  }

  public String Response(){
    Scanner inp = new Scanner(System.in);
    String inputString = inp.nextLine();
    String[] words = inputString.split(" ");
    String responseString = "";
    ArrayList<String> mirrorWords = new ArrayList<>();
        mirrorWords.add("I");
        mirrorWords.add("me");
        mirrorWords.add("am");
        mirrorWords.add("you");
        mirrorWords.add("my");
        mirrorWords.add("your");

    boolean checkmirror  = false;
    for(String word : words){
      if (mirrorWords.contains(word)){
            responseString += mirrorWord(word) + " ";
            checkmirror = true;
          } 
      else {
            responseString += word + " ";
          }
      }
    
    if(checkmirror){
      transcript.add(responseString);
        return responseString;
      }
    else{
        String response2 = cannedWord();
        transcript.add(response2);
        return response2;
      }

  }

  public String mirrorWord(String a){
    switch(a){
      case "I":
        return "you";
      case "me":
        return "you";
      case "am":
        return "are";
      case "you":
        return "I";
      case "my":
        return "your";
      case "your":
        return "my";
      default:
        return a;
    }
  }

  public String cannedWord(){
    String[] cannedResponses = {
      "Interesting...",
      "Wow...",
      "Great!",
      "Heyheyhey"
    };
    Random ran = new Random();
    int index = ran.nextInt(cannedResponses.length);
    return cannedResponses[index];
  }

  public ArrayList<String> getTranscript() {
    return transcript;
  }

  public static void main(String[] arguments) {
     
    System.out.println("Enter your round number:");
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    System.out.println("Hey, what's on your mind?");
    Conversation conversation = new Conversation(a);
    ArrayList<String> transcript = conversation.getTranscript();
    transcript.add("Hey, what's on your mind?");
    for (int j = 0; j <= a-1; j++) {
      String printString = conversation.Response();
      System.out.println(printString);
    }
    System.out.println("See Yah!");

    transcript.add("See Yah!");
    System.out.println("\nTranscript:");
    for (String entry : transcript) {
      System.out.println(entry);
    }
  }
}
