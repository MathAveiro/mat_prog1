import java.util.*;
import java.io.*;
import static java.lang.System.*;
public class B12345 {
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

		max_min[] obj_max_min = new max_min[n_dias];

		Scanner sc_fin1 = new Scanner(fin);
		int idx = 0;
		do {
			obj_max_min[idx] = new max_min();
			obj_max_min[idx].min = sc_fin1.nextInt();
			obj_max_min[idx].max = obj_max_min[idx].min;
			for (int i=0;i<3;i++) {
				int temp = sc_fin1.nextInt();
				if(obj_max_min[idx].min > temp) obj_max_min[idx].min = temp;
				if(obj_max_min[idx].max < temp) obj_max_min[idx].max = temp;
			}
			idx++;
		} while (sc_fin1.hasNextLine());
		sc_fin1.close();

		for (int i=0;i<obj_max_min.length;i++) {
			for (int j=i;j<obj_max_min.length;j++) {
				if(obj_max_min[i].max>obj_max_min[j].max) {
					max_min temp = obj_max_min[i];
					obj_max_min[i] = obj_max_min[j];
					obj_max_min[j] = temp;
				}
			}
		}
		
		File summary = new File("mamiList.txt");
		PrintWriter pwr = new PrintWriter(summary);
		for (int i=0;i<n_dias;i++) {
			save_results(pwr, obj_max_min, i);	
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
	static void save_results(PrintWriter pwr, max_min [] max_min_t,int h) {
		pwr.printf("%2d %2d\n", max_min_t[h].max, max_min_t[h].min);
	}
}
class stat { 
	double md,mn,vd,vn;
	int dn; 
}
class max_min { 
	int max, min; 
}