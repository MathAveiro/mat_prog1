import java.util.*;
import static java.lang.System.*;
import static java.lang.Character.*;

public class exercicio1086 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		out.print("Introduza uma frase: ");
		String frase = sc.nextLine();
		String alterada = changeChars(frase);
		out.println(changeChars(frase));
	}
	public static String changeChars(String frase) {
		String alterada = "";
		for(int i = 0; i < frase.length(); i++) {
			if(!(frase.charAt(i) == 'R' || frase.charAt(i) == 'r')) {
				if(frase.charAt(i) == 'L') { 
					alterada += "U";
				} else if (frase.charAt(i) == 'l') {
					alterada += "u";
				}
				else {
					alterada += frase.charAt(i);
				}
			}
		}
		return 	alterada;
	}	
}