import java.util.*;
import java.io.*;
public class A08_01 {
	static Scanner sc = new Scanner (System.in);
	
	public static void main (String[] args) throws IOException {
		System.out.print ("Ficheiro: ");
		String nameIn = sc.nextLine();
		File fin = new File(nameIn);
		Scanner scf = new Scanner(fin);
		
		if (!fin.exists()){
			System.out.println ("ERRO: O ficheiro " + nameIn + " nao existe!");
			System.exit(2); //desde que o valor seja diferente de zero é porque deu erro
		}
		
		if (fin.isDirectory()){
			System.out.println ("ERRO: O ficheiro " + nameIn + " e um diretorio!");
			System.exit(3);
		}
		
		if(!fin.canRead()){
			System.out.println ("ERRO: O ficheiro " + nameIn + " nao pode ser lido!");
			System.exit(4);
		}
		
		System.out.println ("Ficheiro valido!");
		
		int cont = 0;  //conta o numero de linhas do ficheiro
		while (scf.hasNextLine()){
			cont++;
			scf.nextLine();
		}
		scf.close();
		
		scf = new Scanner(fin);
		String[] linhas = new String[cont];
		String s;
		
		for (int i = 0; i<cont ; i++){
			s = scf.nextLine();
			linhas[i] = s;
		}
		
		for (int i = 0; i<cont ; i++){
			System.out.println(linhas[i]);
		}
		scf.close();
	}
}

