import java.util.*;
import java.io.*;
import static java.lang.System.*;
public class A12345 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		String fileName = "source.txt";
		int count = 0;
		File fin = new File (fileName);
		if( verify(fin,fileName) ) 	{
			Scanner sc_fin = new Scanner(fin);
			do {
				count++;
				sc_fin.nextLine();
			} while (sc_fin.hasNextLine());
			sc_fin.close();
		}
		int [] notes = new int [count];
		Scanner sc_fin1 = new Scanner(fin);
		int idx = 0;
		do {
			sc_fin1.nextInt();
			notes[idx] = sc_fin1.nextInt();
			idx++;
		} while (sc_fin1.hasNextLine());
		sc_fin1.close();
		File summary = new File("summary.txt");
		PrintWriter pwr = new PrintWriter(summary);  
		pwr.printf( "Nota máxima:                   \t%2d\n"+
			"Nota mínima:                   \t%2d\n"+
			"Média:                         \t%4.1f\n"+
			"Número de alunos aprovados     \t%2d\n"+
			"Número de alunos reprovados:   \t%2d\n"+
			"Média dos alunos aprovados:    \t%4.1f\n",max(notes),min(notes),media(notes),aprovados(notes),reprovados(notes),media_aprovados(notes));			
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
	public static int max (int [] a) {
		int max = a[0];
		for (int i=1;i<a.length;i++) {
			if(a[i] > max) max = a[i];
		}
		return max;
	}
	public static int min (int [] a) {
		int min = a[0];
		for (int i=1;i<a.length;i++) {
			if(a[i] < min) min = a[i];
		}
		return min;
	}
	public static double media (int [] a) {
		double media = 0;
		for (int i=0;i<a.length;i++) {
			media += a[i];
		}
		return media / a.length;
	}
	public static int aprovados (int [] a) {
		int aprovados = 0;
		for (int i=0;i<a.length;i++) {
			if(a[i] >= 10) aprovados++;
		}
		return aprovados;
	}
	public static int reprovados (int [] a) {
		int reprovados = 0;
		for (int i=0;i<a.length;i++) {
			if(a[i] <= 9) reprovados++;
		}
		return reprovados;
	}
	public static double media_aprovados (int [] a) {
		double media = 0;
		int divisor = 0;
		for (int i=0;i<a.length;i++) {
			if(a[i] >= 10) {
				media += a[i];
				divisor++;
			}
		}
		return media / divisor;
	}
}
