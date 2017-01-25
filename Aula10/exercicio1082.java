import java.util.*;
import static java.lang.System.*;
import static java.lang.Character.*;

public class exercicio1082 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		out.print("Introduza uma frase: ");
		String frase = sc.nextLine();
		String acro = acronimo(frase);
		out.println("acronimo(\""+frase+"\") -> \""+acro+"\"");
		
	}
	public static String acronimo(String frase) {
		String acronimo = "";
		for(int i = 0; i < frase.length(); i++) {
			if(isUpperCase(frase.charAt(i))) {
				acronimo += frase.charAt(i);
			}
		}
		return acronimo;
	}	
}