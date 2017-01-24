import java.util.*;
import java.io.*;
import static java.lang.System.*;
public class A12345 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		String fileName = "source.txt";
		int n_dias = 0;
		File fin = new File (fileName);
		if( verify(fin,fileName) ) 	{
			Scanner sc_fin = new Scanner(fin);
			do {
				sc_fin.nextLine();
				n_dias++;
			} while (sc_fin.hasNextLine());
			sc_fin.close();
		}

		int[][] t_noite = new int[n_dias][2];
		int[][] t_dia = new int[n_dias][2];
		int[][] t_dia_noite = new int[n_dias][4];

		Scanner sc_fin1 = new Scanner(fin);
		int idx = 0;
		do {
			t_noite[idx][0] = sc_fin1.nextInt();
			t_noite[idx][1] = sc_fin1.nextInt();
			t_dia[idx][0] = sc_fin1.nextInt();
			t_dia[idx][1] = sc_fin1.nextInt();
			t_dia_noite[idx][0] = t_noite[idx][0];
			t_dia_noite[idx][1] = t_noite[idx][1];
			t_dia_noite[idx][2] = t_dia[idx][0];
			t_dia_noite[idx][3] = t_dia[idx][1];
			idx++;
		} while (sc_fin1.hasNextLine());
		sc_fin1.close();
		stat obj_stat = new stat();;
		obj_stat.md = media(t_dia);
		obj_stat.mn = media(t_noite);
		obj_stat.vd = variancia(t_dia);
		obj_stat.vn = variancia(t_noite);
		obj_stat.dn = dias_t_negativas(t_dia_noite);
		File summary = new File("summary.txt");
		PrintWriter pwr = new PrintWriter(summary);
		save_results(pwr, obj_stat, n_dias);
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
	public static double media(int[][] a) {
		double soma, media_dia, media = 0;
		for (int i=0;i<a.length;i++) {
			soma = (a[i][0] + a[i][1]);
			media_dia = (soma / 2);
			media += media_dia;
		}
		return (media / a.length);
	}
	static double variancia(int[][] a) {
		double soma, media_dia, media = 0, variancia = 0;
		for (int i=0;i<a.length;i++) {
			soma = (a[i][0] + a[i][1]);
			media_dia = (soma / 2);
			variancia += (Math.pow(media_dia,2));
			media += media_dia;
		}
		media = (media / a.length);
		return (variancia / a.length) - (Math.pow(media,2));
	}
	static int dias_t_negativas(int[][] a) {
		int total = 0;
		for (int i=0;i<a.length;i++) {
			if(a[i][0] < 0 || a[i][1] < 0 || a[i][2] < 0 || a[i][3] < 0) total++;
		}
		return total;
	}
	static void save_results(PrintWriter pwr, stat Rg,int N) {
		pwr.printf( "Número de dias:  \t%2d\n"+
			"Média dia:       \t%4.1f\n"+
			"Média noite:     \t%4.1f\n"+
			"Variância dia:   \t%4.1f\n"+
			"Variância noite: \t%4.1f\n"+
			"Dias t negativas:\t%2d\n",N,Rg.md,Rg.mn,Rg.vd,Rg.vn,Rg.dn);	
	}
}
class stat { 
	double md,mn,vd,vn;
	int dn; 
}