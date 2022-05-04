package trail;


import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

/**
 * This class is meant to serve ITP 265 students as a help for getting input and error checking on input, but
 * may also be used as a general purpose class to store methods which may be needed across lots of projects.
 *
 * @author Kendra Walther and Spring 2022 students
 * @version Spring 2022
 */

//note: edited by Sara Alvarado, prints differently to fit the style of my game
public class Helper {
    private Scanner sc; //declare

    public Helper(){
        sc = new Scanner(System.in); // initialize
    }
    /**
    * Prompt the user and read one word of text as a String
    * @param prompt: the question to ask the user
    * @return: a one word String - if the user enters multiple words, all other input until the return will be discarded.
    */
   public String inputWord(String prompt) {
       System.out.print(prompt + " >");
       String word = sc.next();
       sc.nextLine(); // remove any "garbage" (like extra whitespace or the return key) after the one word that is read in
       return word;
   }
    /**
    * Prompt the user and read one line of text as a String
    * @param prompt: the question to ask the user
    * @return: a line of user input (including spaces, until they hit enter)
    */
   public String inputLine(String prompt) {
       System.out.print(prompt + " >");
       return sc.nextLine();
   }

    /**
    * Prompt the user and read one word of text as a String, returns a String that matches
    * one allowed matching words passed in as parameters (case sensitive)
    * @param prompt: the question to ask the user
    * @param match1: a word the input is allowed to be
    * @param match2: a word the input is allowed to be
    * @param match3: a word the input is allowed to be
    * @return: a one word  String that matches one of the three allowed words (case-sensitive)
    */
   public String inputWord(String prompt, String match1, String match2, String match3) {
      String word = inputWord(prompt);
       //TODO: finish this method, checking for matching words
       // while NOT GOOD.... --> ask again
       while(!  (word.equals(match1) || word.equals(match2) || word.equals(match3))){
           System.out.println(word + " was not one of the expected words.\nAllowed options are: "
                           + match1 + " or " + match2 + " or " + match3);
           word= inputWord(prompt);
       }
   // equalsIgnoreCase above to match anything, if(word.equalsIgnoreCase(match1)) return match1;
       return word;
   }


   /**
    * Prompt the user and read an int, clearing whitespace or the enter after the number
    * @param prompt: the question to ask the user 
    * @return: an int 
    */
   public int inputInt(String prompt) {
      System.out.print(prompt + " > ");
      while(!sc.hasNextInt()){
          String garbage = sc.nextLine(); // grab the "bad data"
          System.out.println(garbage + " was not an int.");
          System.out.print(prompt + " > ");
      } //here, we know an int is waiting on System.in
      int num = sc.nextInt(); // grab the number
      sc.nextLine();
       return num;
   }

   /**
    * Prompt the user and read an int between (inclusive) of minValue and maxValue, clearing whitespace or the enter after the number
    * @param prompt: the question to ask the user 
    * @return: an int between minValue and maxValue
    */
   public int inputInt(String prompt, int minValue, int maxValue) {
       //get a number
       int number = inputInt(prompt); 
       // check the number is in range
       while(! (number >= minValue && number <= maxValue)){
           System.out.println(number + " is not in the allowed range, [" 
                               + minValue + " - " + maxValue + "]");
           number = inputInt(prompt);
       }

       return number;
   }

   /**
    * Prompt the user and read a floating point number, clearing whitespace or the enter after the number
    * @param prompt: the question to ask the user 
    * @return: a double value 
    */
   public double inputDouble(String prompt) {
      System.out.print(prompt + " > ");
      while(!sc.hasNextDouble()){
          String garbage = sc.nextLine(); // grab the "bad data"
          System.out.println(garbage + " was not a double.");
          System.out.print(prompt + " > ");
      } //here, we know a double is waiting on System.in
      double num = sc.nextDouble(); // grab the number
      sc.nextLine();
       return num;
   }

   /**
    * Prompt the user and read a floating point number between (inclusive) of min and max, 
    * clearing whitespace or the enter after the number
    * @param prompt: the question to ask the user 
    * @return: a double value 
    */
   public double inputDouble(String prompt, double min, double max) {
       //get a number
       double number = inputDouble(prompt); 
       // check the number is in range
       while(! (number >= min && number <= max)){
           System.out.println(number + " is not in the allowed range, [" 
                               + min + " - " + max + "]");
           number = inputDouble(prompt);
       }

       return number;
   }

   /**
    * Prompt the user and read a boolean value, clearing whitespace or the enter after the number
    * @param prompt: the question to ask the user 
    * @return: a boolean value 
    */
   public boolean inputBoolean(String prompt) {
      System.out.print(prompt + " > ");
      while(!sc.hasNextBoolean()){
          String garbage = sc.nextLine(); // grab the "bad data"
          System.out.println(garbage + " was not a boolean Allowed values are:"
                       + "\"true\" or \"false\"");
          System.out.print(prompt + " > ");
      } //here, we know a boolean is waiting on System.in
      boolean answer = sc.nextBoolean(); // grab the cboolean
      sc.nextLine();
       return answer;
   }

   /**
    * Prompt the user enter yes or no (will match y/yes and n/no any case) and 
    * return true for yes and false for no.
    * @param prompt: the question to ask the user 
    * @return: a boolean value 
    */
   public boolean inputYesNo(String prompt) {
       String word = inputWord(prompt);
       while(! ( isYes(word) || isNo(word))){
              // || word.equalsIgnoreCase("n") || word.equalsIgnoreCase("no"))){
           System.out.println(word + " was not a y/n answer. Please enter y or n.");
           word = inputWord(prompt);
       } //exit while loop means word is y/yes OR n/no
       return isYes(word);
   }
   public boolean isYes(String word){
       return word.equalsIgnoreCase("y") || word.equalsIgnoreCase("yes");
   }

    public boolean isNo(String word){
       return word.equalsIgnoreCase("n") || word.equalsIgnoreCase("no");
   }
   /**
    * A shortcut to System.out.println
    * @param msg: the line to be output
    * @return: none 
    */
   public void print(String msg){
       System.out.println(msg);   
   }
   /**
    * A shortcut to System.out.println which will surround the message with some stars to make it stand out.
    * @param msg: the line to be output
    * @return: none 
    */
   //edited this for my purposes
   public void printFancy(String msg){
		for(int i = 0; i<32; i++) {
			System.out.print("-");
		}
       System.out.println("\n" + msg);   
		for(int i = 0; i<32; i++) {
			System.out.print("-");
		}
		System.out.print("\n");
   }
   public void printLine(){
		for(int i = 0; i<32; i++) {
			System.out.print("-");
		}
		System.out.print("\n");
   }
	public LocalDate getBirthday() {
		int year = this.inputInt("Enter year of birth:", 1900, LocalDate.now().getYear());
		int month = this.inputInt("Enter birth month (as num):", 1, 12);
		int day = this.inputInt("Enter birth day (as num):", 1, Month.of(month).maxLength());
		return LocalDate.of(year, month, day); // LocalDate is immutable
	}
}

