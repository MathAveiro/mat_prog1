import java.util.*;
import java.io.*;
import static java.lang.System.*;
public class valorPH {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args)throws IOException {
		double[] valores = null;
		int[] amostras = null;
		int op = 7;
		int nAmostras = 0;
		double med = 0.0;
		do {
			op = menu();
			switch(op) {
				case 1:
					valores = lerFicheiro();
					break;
				case 2:
					printValores(valores);
					break;
				case 3:
					med = calcularMed(valores);
					break;
				case 4:
					amostras = amostrasAB(valores);
					break;
				case 5:
					if(med == 7) {
						nAmostras = amostras[1];
					} else {
						nAmostras = calcularAmostras(valores, med);
					}
					break;
				case 6:
					printValoresOrdenados(valores);
					break;
				case 7:
					out.println("O programa vai terminar!");
					break;
				default:
					out.println("Opção inválida!");
					break;
			}

		}while(op!=7);
	}
	public static int menu() {
		out.println("Analisador de ph");
		out.println("1 - Ler valores de pH de um ficheiro");
		out.println("2 - Escrever valores de pH no terminal");
		out.println("3 - Calcular pH médio das amostras");
		out.println("4 - Calcular número de amostras ácidas e básicas");
		out.println("5 - Calcular número de amostras com pH superior à média");
		out.println("6 - Escrever valores de pH no terminal ordenados de modo crescente");
		out.println("7 - Terminar o programa");
		out.print("Opção: ");
		return sc.nextInt();
	}
	public static double[] lerFicheiro()throws IOException {
		boolean valido = false;
		String nome;
		File f;
		do {
			out.print("Nome do ficheiro: ");
			nome = sc.nextLine();
			f = new File(nome);
			if(!(!f.canRead() || f.isDirectory() || !f.exists())) {
				valido = true;
			}
		}while(!valido);
		Scanner scf = new Scanner(f);
		int count = 0;
		while(scf.hasNextLine()) {
			scf.nextLine();
			count++;
		}
		scf.close();
		double[] valores = new double[count];
		scf = new Scanner(f);
		int i = 0;
		while(scf.hasNextLine()) {
			valores[i] = Double.parseDouble(scf.nextLine());
			i++;
		}
		scf.close();
		return valores;
	}
	public static void printValores(double[] valores) {
		for(int i = 0; i < valores.length; i++) {
			out.println((i+1)+"º valor: "+valores[i]);
		}
	}
	public static double calcularMed(double[] valores) {
		double total = 0;
		for(int i = 0; i < valores.length; i++) {
			total += valores[i];
		}
		double count = valores.length;
		return total/count;
	}
	public static int[] amostrasAB(double[] valores) {
		int[] amostras = new int[2];
		int a = 0, b = 0;
		for (int i = 0; i < valores.length; i++) {
			if(valores[i] < 7) {
				b++;
			} else if(valores[i] > 7) {
				a++;
			}
		}
		amostras[0] = b;
		amostras[1] = a;
		return amostras;
	}
	public static int calcularAmostras(double[] valores, double med) {
		int count = 0;
		for (int i = 0; i < valores.length; i++) {
			if(valores[i] > med) {
				count++;
			} 
		}

		return count;
	} 
	public static void printValoresOrdenados(double[] valores) {
		double[] aux = new double[valores.length];
		for (int i = 0; i < valores.length; i++) {
			aux[i] = valores[i];
		}
		printValores(aux);
	}
}