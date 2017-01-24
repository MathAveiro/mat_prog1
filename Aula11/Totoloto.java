import java.util.*;
import static java.lang.System.*;

public class Totoloto {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int[] chave = new int[6];
		String[] matriz = new String[49];
		int i = 0;
		do{
			lerChave(i, chave);
			i++;
		}while(i<6);
		construirMatriz(chave, matriz);
		int j = 0;
		for(int k = 0; k < matriz.length; k++) {
			out.printf("%4s", matriz[k]);
			j++;
			if(j==7) {
				j = 0;
				out.println();
			}
		}
	}
	public static void lerChave(int index, int[] chave) {
		boolean valido = false;
		do {
			out.print("Elemento "+(index+1)+" da chave = ");
			int valor = sc.nextInt();
			if(!pertenceChave(index+1, valor, chave)) {
				chave[index] = valor;
				valido = true;
			} else {
				out.println("O elemento já pertence à chave!");
			}
			if(valor > 49 || valor < 0) {
				valido = false;
				out.println("Valor inválido");
			}
		}while(!valido);
	}
	public static boolean pertenceChave(int count, int valor, int[] chave) {
		for(int i = 0; i < count; i++) {
			if(valor == chave[i]) {
				return true;
			}
		}
		return false;
	}
	public static void construirMatriz(int[] chave, String[] matriz) {
		for(int i = 0; i < matriz.length; i++) {
			matriz[i] = "";
		}
		for(int i = 0; i < chave.length; i++) {
			matriz[chave[i]-1] = "x";
		}
		for (int i = 0; i < matriz.length; i++) {
			if(!matriz[i].equals("x")) {
				matriz[i] = ""+(i+1);
			}
		}
	}
}