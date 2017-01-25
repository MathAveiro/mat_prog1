import java.util.*;
import static java.lang.System.*;
import static java.lang.Character.*;

public class exercicio1087 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		out.print("Introduza uma frase: ");
		String frase = sc.nextLine();
		
		out.println(capitalize(frase));
	}
	public static String capitalize(String frase) {
		String[] parts = frase.split(" ");
		String alterada = "";
		for (int i = 0; i < parts.length; i++) {
			for (int j = 0; j < parts[i].length(); j++ ) {
				if(j==0) alterada += toUpperCase(parts[i].charAt(j));
				else alterada += parts[i].charAt(j);
			}
			alterada += " ";
		}
		return alterada;
	}	
}