import java.util.*;
import java.io.*;
public class A08_02 {
	static Scanner sc = new Scanner (System.in);
	
	public static void main (String[] args) throws IOException {
		String nameIn = "dados.txt";
		File fin = new File(nameIn);
		Scanner scf = new Scanner (fin);
		
		String nameOut = "resultados.txt";
		PrintWriter pw = new PrintWriter (new FileWriter(nameOut, true));
		
		int n = 0;
		while (scf.hasNextLine()){  //conta o numero de linhas do ficheiro
				n++;
				scf.nextLine();
		}
		scf.close();
		
		scf = new Scanner (fin);
		String[] linhas = new String [n];  //cria array com tamanho do nº de linhas
		String s;
		
		for (int i = 0; i<n ; i++){
			s = scf.nextLine();
			linhas[i] = s;
		}
		
		for (int i = n-1; i>=0; i--){
			pw.printf("%s\n", linhas[i]);
		}
		scf.close();
		pw.close();
	}
}

