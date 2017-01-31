import java.util.*;
import java.io.*;
import static java.lang.System.*;
public class B12345 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		String fileName = "source.txt";
		int count = 0;
		File fin = new File (fileName);
		if(verify(fin,fileName)) {
			Scanner sc_fin = new Scanner(fin);
			do {
				count++;
				sc_fin.nextLine();
			} while (sc_fin.hasNextLine());
			sc_fin.close();
		}
		aluno [] alunos = new aluno [count];
		if(verify(fin,fileName)) {
			Scanner sc_fin = new Scanner(fin);
			int idx = 0;
			do {
				alunos[idx] = new aluno();
				alunos[idx].nm = sc_fin.nextInt();
				alunos[idx].nota = sc_fin.nextInt();
				idx++;
			} while (sc_fin.hasNextLine());
			sc_fin.close();
		}
		for (int i=0;i<alunos.length;i++) {
			for (int j=i;j<alunos.length;j++) {
				if(alunos[j].nm < alunos[i].nm) {
					aluno temp = alunos[i];
					alunos[i] = alunos[j];
					alunos[j] = temp;
				}
			}
		}
		String fileNameN = "sourceN.txt";
		File finN = new File (fileNameN);
		if (verify(finN,fileNameN)) {
			Scanner sc_fin1N = new Scanner(finN);
			int idx = 0;
			do {
				sc_fin1N.nextInt();
				alunos[idx].nome = sc_fin1N.nextLine();
				idx++;
			} while (sc_fin1N.hasNextLine());
			sc_fin1N.close();
		}
		File summary = new File("newList.txt");
		PrintWriter pwr = new PrintWriter(summary);
		for (int x=0;x<alunos.length;x++) {
				pwr.printf("%5d %-25s%5d\n",alunos[x].nm,alunos[x].nome,alunos[x].nota);	
		}			
		pwr.close();
	}
	static boolean verify(File my_file, String nameIn) {  
		if (!my_file.exists()) {
			System.out.println("ERROR: input file " + nameIn + " does not exist!");		
			return false;
		} if (my_file.isDirectory()) {
			System.out.println("ERROR: input file " + nameIn + " is a directory!");		
			return false;
		} if (!my_file.canRead()) {
			System.out.println("ERROR: cannot read from input file " + nameIn+ "!");	
			return false;        
		}
		return true; 			
	}
}

class aluno {
	int nm, nota;
	String nome;
}
