import static java.lang.System.*;
import java.io.*;
import java.util.*;

public class ER12345 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		Aluno [] alunos = new Aluno [1];
		Aluno [] novoAlunos;
		int op = 0;

		do {
			out.printf("2) Leitura pelo teclado\n3) Leitura de um ficheiro\n4) Imprimir no terminal as notas dos alunos\n5) Grvar as notas num ficheiro\n6) Ordenar as notas pelo número do aluno\n7) Remover números repetidos\n0) Sair\nOPCAO -> ");
			op = sc.nextInt();
			if (op == 0) break;
			switch (op) {
				case 2:
				out.printf("Introduza o número de alunos: ");
				int num = sc.nextInt();
				alunos = lerDadosTeclado(num);
				break;
				case 3:
				File fin = new File ("notas.txt");
				alunos = lerDadosFicheiro(fin);
				break;
				case 4:
				imprimirNotas(alunos);
				break;
				case 5:
				File finFile = new File ("notasFinais.txt");
				guardarFicheiro(finFile, alunos);
				break;
				case 6:
				ordernarArray(alunos);
				break;
				case 7:
				novoAlunos = removerRepetidos(alunos);
				break;
			}

		} while(op != 0);
	}
	public static Aluno [] lerDadosTeclado (int num) {
		Aluno [] alunos = new Aluno [num];
		for (int i = 0; i < alunos.length; i++) {
			alunos[i] = new Aluno();
			out.printf("Introduza o número do aluno %d: ", i);
			alunos[i].numero = sc.nextInt();
			out.printf("Introduza o nome do aluno com número %d: ", alunos[i].numero);
			alunos[i].nome = sc.next();
			out.printf("Introduza a nota do primeiro teste: ");
			do alunos[i].teste1 = sc.nextInt(); while (alunos[i].teste1 < -1 || alunos[i].teste1 > 20);
			out.printf("Introduza a nota do segundo teste: ");
			do alunos[i].teste2 = sc.nextInt(); while (alunos[i].teste2 < -1 || alunos[i].teste2 > 20);
			if (alunos[i].teste1 == -1 && alunos[i].teste2 == -1) alunos[i].notaFinal = 0;
			else if(alunos[i].teste1 == -1) alunos[i].notaFinal = arredondarMedia(alunos[i].teste2*0.5);
			else if (alunos[i].teste2 == -1) alunos[i].notaFinal = arredondarMedia(alunos[i].teste1*0.5);
			else alunos[i].notaFinal = arredondarMedia(alunos[i].teste1*0.5 + alunos[i].teste2*0.5);
		}
		return alunos;
	}
	public static Aluno [] lerDadosFicheiro (File fin) throws IOException {
		Scanner scf = new Scanner (fin);
		int length = scf.nextInt();
		Aluno [] alunos = new Aluno [length];
		scf.nextLine();
		int idx = 0;
		do {
			alunos[idx] = new Aluno();
			alunos[idx].numero = scf.nextInt();
			alunos[idx].nome = scf.next();	
			alunos[idx].teste1 = scf.nextInt();
			alunos[idx].teste2 = scf.nextInt();
			if (alunos[idx].teste1 == -1 && alunos[idx].teste2 == -1) alunos[idx].notaFinal = 0;
			else if(alunos[idx].teste1 == -1) alunos[idx].notaFinal = arredondarMedia(alunos[idx].teste2*0.5);
			else if (alunos[idx].teste2 == -1) alunos[idx].notaFinal = arredondarMedia(alunos[idx].teste1*0.5);
			else alunos[idx].notaFinal = arredondarMedia(alunos[idx].teste1*0.5 + alunos[idx].teste2*0.5);
			idx++;
			if (idx == length) return alunos;
		} while (scf.hasNextLine());
		scf.close();
		return alunos;
	}

	public static void imprimirNotas (Aluno [] alunos) {
		out.printf("Numero\tNome\tT1\tT2\tFinal\n");
		for (int i = 0;i < alunos.length ;i++) out.printf("%d\t%s\t%d\t%d\t%d\n", alunos[i].numero, alunos[i].nome, alunos[i].teste1, alunos[i].teste2, alunos[i].notaFinal);
	}

	public static void guardarFicheiro (File fin, Aluno [] alunos) throws IOException {
		PrintWriter pwr = new PrintWriter (fin);
		pwr.printf("Numero\tNome\tT1\tT2\tFinal\n");
		for (int i = 0;i < alunos.length ;i++) pwr.printf("%d\t%s\t%d\t%d\t%d\n", alunos[i].numero, alunos[i].nome, alunos[i].teste1, alunos[i].teste2, alunos[i].notaFinal);
		pwr.close();
	}

	public static void ordernarArray (Aluno [] alunos) {
		for (int i = 0;i < alunos.length; i++) {
			for (int j = 0;j < alunos.length ; j++ ) {
				if (alunos[i].numero > alunos[j].numero) {
					Aluno temp = alunos[i];
					alunos[i] = alunos[j];
					alunos[j] = temp; 
				}
			}
		}
	}

	public static Aluno [] removerRepetidos (Aluno [] alunos) {
		int count = 0;

		for (int i = 1; i< alunos.length; i++) if (alunos[i].numero == alunos[i-1].numero) count++;
		
		Aluno [] novoAlunos = new Aluno[alunos.length - count];
		Aluno [] temp = alunos;

		for (int i = 1; i< temp.length; i++) if (temp[i].numero == temp[i-1].numero) for (int j = i; j < temp.length-1; j++) temp[j] = temp [j+1];		

		for (int i = 0; i < novoAlunos.length; i++) novoAlunos[i] = temp[i];
		return novoAlunos;

	}

	public static int arredondarMedia (double media) {
		if (media - (int)media < 0.5) return (int)media;
		else return (int)media + 1;
	}
}

class Aluno {
	int numero, teste1, teste2, notaFinal;
	String nome;
}