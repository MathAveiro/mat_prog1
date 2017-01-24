import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Alunos {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args)throws IOException {
		boolean valido = false;
		String nome;
		File f;
		do {
			out.print("Nome do ficheiro: ");
			nome = sc.nextLine();
			f = new File(nome);
			if(!(!f.exists() || f.isDirectory() || !f.canRead())) {
				valido = true;
			}
		} while(!valido);
		Scanner scf = new Scanner(f);
		int count = 0;
		while(scf.hasNextLine()) {
			count++;
			scf.nextLine();
		}
		scf.close();
		int[] nmec = new int[count];
		String[] nomes = new String[count];
		scf = new Scanner(f);
		int index = 0;
		while(scf.hasNextLine()) {
			String linha = scf.nextLine();
			String[] parts = linha.split(" ", 2);
			nmec[index] = Integer.parseInt(parts[0]);
			nomes[index] = parts[1];
			index++;
		}
		scf.close();
		int num = 0;
		do {
			out.print("NMec: ");
			num = sc.nextInt();
			for(int i = 0; i < count; i++) {
				if(nmec[i]== num) {
					out.println("Nmec: " + num);
					out.println("Nome: " + nomes[i]);
				}
			}
		} while(num != 0);
	}
}