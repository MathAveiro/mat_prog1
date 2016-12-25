import static java.lang.System.*;
import java.util.*;
import java.io.*;
public class Notas {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args)throws IOException {
		int op = 7;
		Aluno alunos[]=null;
		do {
			op=menu();
			switch(op) {
				case 1: alunos=lerFicheiro(alunos);
					break;
				case 2: imprimirTabela(alunos);
					break;
				case 3: info(alunos);
					break;
				case 4: alunos=alterarInfo(alunos);
					break;
				case 5: histograma(alunos);
					break;
				case 6:
					break;
				case 7: out.println("O programa vai terminar!");
					break;
				default:
					break;
			}
		}while(op!=7);		
	}
	private static int menu() {
		out.println("");
		out.print("1 - Ler ficheiro com números mec. e pedir informação de notas\n2 - Imprimir no terminal a informação da disciplina\n3 - Calcular estatísticas das notas finais\n4 - Alterar as notas de um aluno\n5 - Imprimir um histograma de notas\n6 - Gravar num ficheiro a informação da disciplina (ordenada)\n7- Terminar o programa\nOpção: ");
		return sc.nextInt();
	}
	private static Aluno[] lerFicheiro(Aluno[] alunos)throws IOException {
		File f;
		String nameIn;
		out.println();
		do {
			out.print("Nome do ficheiro: ");
			nameIn=sc.next();
			f=new File(nameIn);
		}while(!f.isFile()||!f.exists()||!f.canRead());
		Scanner scf=new Scanner(f);
		int count=0;
		scf.nextLine();
		while(scf.hasNextLine()) {
			count++;
			scf.nextLine();
		}
		scf.close();
		alunos=new Aluno[count];
		scf=new Scanner(f);
		int i=0;
		scf.nextLine();
		while(scf.hasNextLine()) {
			String temp=scf.nextLine();
			String parts[]=temp.split(" - ");
			alunos[i]=new Aluno();
			alunos[i].nmec=Integer.parseInt(parts[0]);
			out.print("NMec: "+parts[0]+"\n");
			int notaN=99, notaR=99, notaF=99;
			do {
				out.print("Nota da época Normal: ");
				notaN=sc.nextInt();
			} while(notaN<0 || (notaN>20 && notaN!=77));
			alunos[i].notaN=notaN;
			do {
				out.print("Nota da época de Recurso: ");
				notaR=sc.nextInt();
			} while(notaR<0 || (notaR>20 && notaR!=77));
			alunos[i].notaR=notaR;
			if(notaN>notaR) {
				if(notaN==77) notaF=notaR;
				else notaF=notaN;
			}
			else if(notaR>notaN) {
				if(notaR==77) notaF=notaN;
				else notaF=notaR;
			}
			else if(notaN==notaR) {
				notaF=notaN;
			}
			alunos[i].notaF=notaF;
			i++;
		}
		FileWriter fw=new FileWriter(f);
		fw.write("Lista de alunos:\n");
		for(int j=0; j<count; j++) {
			fw.write(alunos[j].nmec+" - "+alunos[j].notaN+" - "+alunos[j].notaR+" - "+alunos[j].notaF+"\n");
		}
		fw.flush();
		fw.close();
		out.println();
		return alunos;
	}
	private static void imprimirTabela(Aluno[] alunos) {
		out.println("");
		out.println("Pauta de uma disciplina!");
		out.println("---------------------------");
		for(int i=0; i<alunos.length; i++) {
			out.printf("| %8d | %2d | %2d | %2d |\n", alunos[i].nmec, alunos[i].notaN, alunos[i].notaR, alunos[i].notaF);
		}
		out.println("---------------------------");
		out.println("");
	}
	private static void info(Aluno[] alunos) {
		int nmec=0, aprov=0, reprov=0, notaMax=0;
		Double notas=0.0;
		for(int i=0; i<alunos.length; i++) {
			if(alunos[i].notaF>notaMax) {
				notaMax=alunos[i].notaF;
				nmec=alunos[i].nmec;
			}
			if(alunos[i].notaF!=77) {
				notas+=alunos[i].notaF;
				if(alunos[i].notaF>=10) aprov++;
				else reprov++;
			} else {
				reprov++;
			}
		}
		for(int i=0; i<alunos.length; i++) {
			if(alunos[i].nmec==nmec) {
				out.println("");
				out.println("Melhor aluno");
				out.println("---------------------------");
				out.printf("| %8d | %2d | %2d | %2d |\n", nmec, alunos[i].notaN, alunos[i].notaR, notaMax);
				out.println("---------------------------");
			}
		}
		Double med = notas/alunos.length;
		out.println("");
		out.println("Média de todos os alunos: "+med);
		out.println("Alunos aprovados: "+aprov+" - Alunos reprovados: "+reprov);
		out.println("");
	}
	private static Aluno[] alterarInfo(Aluno[] alunos) {
		out.println("");
		out.print("NMec: ");
		int nmec=sc.nextInt();
		int pos=0;
		boolean existe=false;
		for(int i=0; i<alunos.length; i++) {
			if(nmec==alunos[i].nmec) {
				pos=i;
				existe=true;
				break;
			} 
		}
		if(!existe) {
			out.println("O aluno com o NMec "+nmec+" não existe!");
			out.println("");
			return alunos;
		} else {
			int notaN=99, notaR=99, notaF=99;
			int i=pos;
			do {
				out.print("Nota da época Normal: ");
				notaN=sc.nextInt();
			} while(notaN<0 || (notaN>20 && notaN!=77));
			alunos[i].notaN=notaN;
			do {
				out.print("Nota da época de Recurso: ");
				notaR=sc.nextInt();
			} while(notaR<0 || (notaR>20 && notaR!=77));
			alunos[i].notaR=notaR;
			if(notaN>notaR) {
				if(notaN==77) notaF=notaR;
				else notaF=notaN;
			}
			else if(notaR>notaN) {
				if(notaR==77) notaF=notaN;
				else notaF=notaR;
			}
			else if(notaN==notaR) {
				notaF=notaN;
			}
			alunos[i].notaF=notaF;
			out.println("");
			return alunos;
		}
	}
	private static void histograma(Aluno[] alunos) {
		String[][] histograma=new String[21][alunos.length];
		for(int i=0; i<histograma.length; i++) {
			for(int j=0; j<histograma[i].length; j++) {
				histograma[i][j]=" ";
			}
		}
		for(int i=0; i<histograma.length; i++) {
			int l=0;
			for(int j=0; j<histograma[i].length; j++) {
				if(alunos[j].notaF==i) {
					histograma[i][l]="*";
					l++;
				} 
			}
		}
		out.println("Histograma Vertical");
		out.println("-------------------------------------------------------------");
		for(int l=alunos.length-1;l>=0;l--){ //Neste caso, como queremos o histograma ao contrário, teremos de o ler da última linha para a primeira.
			for(int c=0;c<histograma.length;c++){
				out.print(histograma[c][l]);
				out.print("  ");
			}
			out.println();
		}
		out.println("-------------------------------------------------------------");
		out.println("0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20");
	}
}
class Aluno {
		int nmec, notaN, notaR, notaF;
}