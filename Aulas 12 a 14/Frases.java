import java.util.*;

public class Frases {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int count = 0;
		String[]frases = new String[10];
		String frase="";
		System.out.println("Introdução das frases: ");
		do {
			System.out.print((count+1)+"ª frase: ");
			frase = sc.nextLine();
			if (frase.compareTo("fim")==0) break;
			frases[count] = frase;
			count++;
		} while(count < 10);
		int max=0;
		for (int i=0; i < count; i++) {
			if(frases[i].length() > max) max = frases[i].length();
		}
		char[][] frasesInvertidas = new char[count][max];
		for (int i=0; i < count; i++) {
			for (int j=0; j < frases[i].length(); j++) {
				frasesInvertidas[i][j] = frases[i].charAt(frases[i].length()-1-j);
			}
		}
		System.out.println();
		System.out.println("Frases invertidas: ");
		for (int i=count-1; i >= 0; i--) {
			for(int j=0; j < max; j++) {
				System.out.print(frasesInvertidas[i][j]);
			}
			System.out.println();
		}
	}
}