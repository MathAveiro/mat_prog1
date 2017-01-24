import java.util.*;
import static java.lang.System.*;

public class TotolotoBool {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int[] chave = new int[6];
		boolean[] matriz = new boolean[49];
		int i = 0;
		do{
			lerChave(i, chave);
			i++;
		}while(i<6);
		construirMatriz(chave, matriz);
		for(int k = 0; k < matriz.length; k++) {
			out.printf("%3d", (k+1));
		}
		out.println();
		for(int k = 0; k < matriz.length; k++) {
			if(matriz[k]) out.printf("%3s", "T");
			else out.print("   ");
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
	public static void construirMatriz(int[] chave, boolean[] matriz) {
		for(int i = 0; i < chave.length; i++) {
			matriz[chave[i]-1] = true;
		}
	}
}