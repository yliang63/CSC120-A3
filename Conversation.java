import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

class Conversation {
  
  private int round;
  private Random ran;

  public Conversation(int a){
    this.round = a;
    this.ran = new Random();
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
        return responseString;
      }
    else{
        String response2 = cannedWord();
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
    int index = ran.nextInt(cannedResponses.length);
    return cannedResponses[index];
  }

  public static void main(String[] arguments) {
    System.out.println("Enter your round number:");
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    System.out.println("Hey, what's on your mind?");
    Conversation conversation = new Conversation(a);
    
    for (int j = 0; j <= a-1; j++) {
      String printString = conversation.Response();
      System.out.println(printString);
    }
    
    System.out.println("See Yah!");
  }
}