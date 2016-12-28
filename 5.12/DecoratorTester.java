import java.io.*;
import java.util.Scanner;

public class DecoratorTester
{

   public static void main(String[] args) throws IOException
   {
	  Scanner in = new Scanner(System.in);
	  CharArrayWriter cw = new CharArrayWriter();
	  String input = new String();
	  System.out.print("Enter a string that you want to encrypt: ");
	  input = in.nextLine();
	  char[] c = input.toCharArray();
	  
	  EncryptingWriter e = new EncryptingWriter(cw);
      e.write(c, 0, input.length());
      System.out.println(cw);

      System.out.print("Enter a string that you want to decrypt: ");
	  input = in.nextLine();
	  c = input.toCharArray();
	  CharArrayReader cr = new CharArrayReader(c);
      DecryptingReader r = new DecryptingReader(cr);
      r.read(c, 0, input.length());
      System.out.println(c);
      
   } 
}