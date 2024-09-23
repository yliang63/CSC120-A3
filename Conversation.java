import java.util.Scanner;
import java.util.ArrayList;

class Conversation {
  
  private int round;
  
  public Conversation(int a){
    this.round = a;
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

    for(String word : words){
      if (mirrorWords.contains(word)){
        responseString += mirrorWord(word)+" ";
      }
      else{
        responseString += word+" ";
      }
    }
    return responseString;
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


  public static void main(String[] arguments) {
    System.out.println("Enter your round number:");
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    System.out.println("Hey, what's on your mind?");
    Conversation conversation = new Conversation(a);
    for(int j=0; j<=a-1;j++){
    String printString = conversation.Response();
    System.out.println(printString);
    }
    System.out.println("See yah!");
  }
}
