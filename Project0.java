import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JOptionPane;


public class StringUpperLowerFindings {

   public static void main(String[] args) {
       JOptionPane.showMessageDialog (null, "Please type your own words to find the count of Upper and Lower letters!", "Message", JOptionPane.INFORMATION_MESSAGE);
       JOptionPane.showMessageDialog (null, "To stop this process. Please type STOP / stop", "Message", JOptionPane.INFORMATION_MESSAGE);
      
       String sentence;
       do {
           System.out.println(" Please enter the input string :");
           //Reading input from user
           Scanner in = new Scanner(System.in);
           sentence = in.nextLine();
           if (!sentence.equalsIgnoreCase("stop")) {
               //To find number of upper and lower latters
               findUpperLowerLetters(sentence);
           }
       } while (!sentence.equalsIgnoreCase("STOP"));
       JOptionPane.showMessageDialog (null, "Thank You!", "Message", JOptionPane.INFORMATION_MESSAGE);      
   }
  
   private static void findUpperLowerLetters(String sentence) {
       //HashMap to store the each charater
       HashMap<Character, Integer> characterhashtable = new HashMap<Character, Integer>();
       int i, length;
       Character c;
  
       length = sentence.length(); // Scan string and build hash table
       for (i = 0; i < length; i++) {
           c = sentence.charAt(i);
           //If character id Caps
           if (characterhashtable.containsKey(c) && Character.isUpperCase(c)) {
               characterhashtable.put(c, characterhashtable.get(c) + 1);
               //if character is lower
           } else if (characterhashtable.containsKey(c) && Character.isLowerCase(c)) {
               characterhashtable.put(c, characterhashtable.get(c) + 1);
               //Add when letter appeared first time
           } else {
               characterhashtable.put(c, 1);
           }
       }
      
       String[] message = new String[characterhashtable.size()];
      
       // Create output message String
       Set set = characterhashtable.entrySet();
       Iterator iterator = set.iterator();
       int j=0;
       while (iterator.hasNext()) {
           Map.Entry mentry = (Map.Entry) iterator.next();
           message[j++] = mentry.getKey() + " appears " + mentry.getValue()+" times";
       }
       // Message box with Output
       JOptionPane.showMessageDialog(null, message, "Message",
               JOptionPane.INFORMATION_MESSAGE);
   }

}
