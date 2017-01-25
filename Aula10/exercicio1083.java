import java.util.*;
import static java.lang.System.*;
import static java.lang.Character.*;

public class exercicio1083 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		out.print("Introduza uma frase: ");
		String frase = sc.nextLine();
		out.println("countWords(\""+frase+"\") -> \""+countWords(frase)+"\"");
		
	}
	public static int countWords(String frase) {
		String[] parts = frase.split(" ");
		return parts.length;
	}	
}