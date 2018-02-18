/*
 * @Copyright Victor Manuel Piron Mardones.
 */
package ca.uqam.romains;

/**
 *
 * @author Victor
 */
public class Romains {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                  
          TextIO.putln("A) Enter a Roman numeral and I will convert it to an ordinary");
          TextIO.putln("   arabic integer.");
          TextIO.putln("B) Enter an integer in the range 1 to 3999 and I will convert");
          TextIO.putln("   it to a Roman numeral.");
          TextIO.putln("C) Press return when you want to quit.");
          
          while (true) {
    
             TextIO.putln();
             TextIO.put("> ");
             
             /* Skip blanks at the beginning of the input line.
                Break out of the loop if there is nothing else on the line. */             
              while (TextIO.peek() == ' ' || TextIO.peek() == '\t') {
                  TextIO.getAnyChar();
              }
              
              if (TextIO.peek() == '\n') {
                  break;
              }                
                
             /* If the first non-blank character is a digit, read an arabic
                numeral and convert it to a Roman numeral.  Otherwise, read
                a Roman numeral and convert it to an arabic numeral. */
                
             if ( Character.isDigit(TextIO.peek()) ) {
                int arabic = TextIO.getlnInt();
                try {
                    RomanNumeral romanNumeral = new RomanNumeral(arabic);
                    TextIO.putln(romanNumeral.toInt() + " = " + romanNumeral.toString());
                }
                catch (NumberFormatException e) {
                    TextIO.putln("Invalid input.");
                    TextIO.putln(e.getMessage());
                }
             }
             else {
                String roman = TextIO.getln();
                try {
                    RomanNumeral N = new RomanNumeral(roman);
                    TextIO.putln(N.toString() + " = " + N.toInt());
                }
                catch (NumberFormatException e) {
                    TextIO.putln("Invalid input.");
                    TextIO.putln(e.getMessage());
                }
             }
    
          }  // end while
          
          TextIO.putln("OK.  Agur!");
    
       }  // end main()

}
