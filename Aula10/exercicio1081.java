import java.util.*;
import static java.lang.System.*;
import static java.lang.Character.*;

public class exercicio1081 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		out.print("Introduza uma frase: ");
		String frase = sc.nextLine();
		int minusculos = 0, maiusculos = 0, digitos = 0, vogais = 0, consoantes = 0;
		for(int i = 0; i < frase.length(); i++) {
			if(isDigit(frase.charAt(i))) {
				digitos++;
			} else {
				if(isVowel(frase.charAt(i))) {
					vogais++;
				} else {
					consoantes++;
				}
				if(isUpperCase(frase.charAt(i))) {
					maiusculos++;
				} else if(isLowerCase(frase.charAt(i))) {
					minusculos++;
				}
			}
		}
		out.println("Análise de uma frase");
		out.println("Frase de entrada -> "+frase);
		out.println("Número de caracteres minúsculos -> "+minusculos);
		out.println("Número de caracteres maiúsculos -> "+maiusculos);
		out.println("Número de caracteres numéricos -> "+digitos);
		out.println("Número de vogais -> "+vogais);
		out.println("Número de consoantes -> "+consoantes);
	}
	public static boolean isVowel(char c) {
		if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
			return true;
		} else {
			return false;
		}
	}
}