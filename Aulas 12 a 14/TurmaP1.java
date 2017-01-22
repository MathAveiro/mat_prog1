import java.util.*;
import static java.lang.System.*;

public class TurmaP1 {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		Aluno[] alunos = new Aluno[20];
		int count = 0;
		int op = 0;
		do {
			op = menu();
			switch(op) {
				case 1:
					count = inserirInfo(count, alunos);
					break;
				case 2:
					mostrarInfo(count, alunos);
					break;
				case 3:
					count = alterarInfo(count, alunos);
					break;
				case 4:
					mostrarInfoPorNMEC(count, alunos);
					break;
				case 5:
					mostrarInfoPorNF(count, alunos);
					break;
				case 6:
					calcularMediaFinal(count, alunos);
					break;
				case 7:
					mostrarMelhorAluno(count, alunos);
					break;
				case 0:
					out.println("O programa vai terminar!");
					break;
				default:
					out.println("Opção inválida");
					break;
			}
		} while ( op != 0);
	}
	public static int menu() {
		out.printf("Gestão de uma turma:\n1 - Inserir informação da turma\n2 - Mostrar informação de um aluno\n3 - Alterar informação de um aluno\n4 - Listar alunos ordenados pelo nmec\n5 - Listar alunos ordenados pela nota final\n6 - Média das notas finais\n7 - Melhor aluno\n0 - Terminar programa\nOpção: ");
		return sc.nextInt();
	}
	public static int inserirInfo(int count, Aluno[] alunos) {
		int nmec = 0;
		do {
			alunos[count] = new Aluno();
			out.print("Número mecanográfico: ");
			nmec = sc.nextInt();
			if(nmec==0) break;
			alunos[count].nmec = nmec;
			out.print("Nome do aluno: ");
			alunos[count].nome = sc.nextLine();
			int nota1 = 0, nota2 = 0, nota3 = 0, nota4 = 0;
			do {
				out.print("1ª Nota: ");
				nota1 = sc.nextInt();
			}while(nota1>20 || nota1<0);
			alunos[count].notas[0] = nota1;
			do {
				out.print("2ª Nota: ");
				nota2 = sc.nextInt();
			}while(nota2>20 || nota2<0);
			alunos[count].notas[1] = nota2;
			do {
				out.print("3ª Nota: ");
				nota3 = sc.nextInt();
			}while(nota3>20 || nota3<0);
			alunos[count].notas[2] = nota3;
			do {
				out.print("4ª Nota: ");
				nota4 = sc.nextInt();
			}while(nota4>20 || nota4<0);
			alunos[count].notas[3] = nota4;
			double notaFinal = 0;
			notaFinal += alunos[count].notas[0] * 0.1;
			notaFinal += alunos[count].notas[1] * 0.3;
			notaFinal += alunos[count].notas[2] * 0.1;
			notaFinal += alunos[count].notas[3] * 0.5;
			alunos[count].notaFinal = notaFinal;
			count++;
		}while(nmec!=0);
		return count;
	}
	public static void mostrarInfo(int count, Aluno[] alunos) {
		out.print("Nº mecanográfico do aluno: ");
		boolean existe = false;
		int index = 0;
		int nmec = sc.nextInt();
		for (int i = 0; i < count; i++) {
			if(nmec == alunos[i].nmec) {
				existe = true;
				index  = i;
				break;
			}
		}
		if(!existe) {
			out.println("O aluno não existe!");
		} else {
			out.println(alunos[index].nmec);
			out.println(alunos[index].nome);
			out.println(alunos[index].notas[0] + " + " + alunos[index].notas[1] + " + " + alunos[index].notas[2] + " + " + alunos[index].notas[3] + " = " + alunos[index].notaFinal);
		}
	}
	public static int alterarInfo(int count, Aluno[] alunos) {
		out.print("Nº mecanográfico do aluno: ");
		boolean existe = false;
		int index = 0;
		int nmec = sc.nextInt();
		for (int i = 0; i < count; i++) {
			if(nmec == alunos[i].nmec) {
				existe = true;
				index  = i;
				break;
			}
		}
		if(!existe) {
			out.println("O aluno não existe!");
			if(count < 20) {
				alunos[count] = new Aluno();
				out.println("Adicionar novo aluno: ");
				alunos[count].nmec = nmec;
				out.print("Nome do aluno: ");
				alunos[count].nome = sc.nextLine();
				int nota1 = 0, nota2 = 0, nota3 = 0, nota4 = 0;
				do {
					out.print("1ª Nota: ");
					nota1 = sc.nextInt();
				}while(nota1>20 || nota1<0);
				alunos[count].notas[0] = nota1;
				do {
					out.print("2ª Nota: ");
					nota2 = sc.nextInt();
				}while(nota2>20 || nota2<0);
				alunos[count].notas[1] = nota2;
				do {
					out.print("3ª Nota: ");
					nota3 = sc.nextInt();
				}while(nota3>20 || nota3<0);
				alunos[count].notas[2] = nota3;
				do {
					out.print("4ª Nota: ");
					nota4 = sc.nextInt();
				}while(nota4>20 || nota4<0);
				alunos[count].notas[3] = nota4;
				double notaFinal = 0;
				notaFinal += alunos[count].notas[0] * 0.1;
				notaFinal += alunos[count].notas[1] * 0.3;
				notaFinal += alunos[count].notas[2] * 0.1;
				notaFinal += alunos[count].notas[3] * 0.5;
				alunos[count].notaFinal = notaFinal;
				count++;
			}
		} else {
			int nota1 = 0, nota2 = 0, nota3 = 0, nota4 = 0;
			do {
				out.print("1ª Nota: ");
				nota1 = sc.nextInt();
			}while(nota1>20 || nota1<0);
			alunos[index].notas[0] = nota1;
			do {
				out.print("2ª Nota: ");
				nota2 = sc.nextInt();
			}while(nota2>20 || nota2<0);
			alunos[index].notas[1] = nota2;
			do {
				out.print("3ª Nota: ");
				nota3 = sc.nextInt();
			}while(nota3>20 || nota3<0);
			alunos[index].notas[2] = nota3;
			do {
				out.print("4ª Nota: ");
				nota4 = sc.nextInt();
			}while(nota4>20 || nota4<0);
			alunos[index].notas[3] = nota4;
			int notaFinal = 0;
			notaFinal += alunos[index].notas[0] * 0.1;
			notaFinal += alunos[index].notas[1] * 0.3;
			notaFinal += alunos[index].notas[2] * 0.1;
			notaFinal += alunos[index].notas[3] * 0.5;
			alunos[index].notaFinal = notaFinal;
		}
		return count;
	}
	public static void mostrarInfoPorNMEC(int count, Aluno[] alunos) {
		for(int i = 0; i < count; i++) {
			for(int j = i+1; j < count; j++) {
				if(alunos[i].nmec > alunos[j].nmec) {
					int temp = alunos[i].nmec;
					alunos[i].nmec = alunos[j].nmec;
					alunos[j].nmec = temp;
				}
			}
		}
		for(int index = 0; index < count; index++) {
			out.println(alunos[index].nmec);
			out.println(alunos[index].nome);
			out.println(alunos[index].notas[0] + " + " + alunos[index].notas[1] + " + " + alunos[index].notas[2] + " + " + alunos[index].notas[3] + " = " + alunos[index].notaFinal);
		}
	}
	public static void mostrarInfoPorNF(int count, Aluno[] alunos) {
		for(int i = 0; i < count; i++) {
			for(int j = i+1; j < count; j++) {
				if(alunos[i].notaFinal > alunos[j].notaFinal) {
					double temp = alunos[i].notaFinal;
					alunos[i].notaFinal = alunos[j].notaFinal;
					alunos[j].notaFinal = temp;
				}
			}
		}
		for(int index = 0; index < count; index++) {
			out.println(alunos[index].nmec);
			out.println(alunos[index].nome);
			out.println(alunos[index].notas[0] + " + " + alunos[index].notas[1] + " + " + alunos[index].notas[2] + " + " + alunos[index].notas[3] + " = " + alunos[index].notaFinal);
		}
	}
	public static void calcularMediaFinal(int count, Aluno[] alunos) {
		int total = 0;
		for(int i = 0; i < count; i++) {
			total += alunos[i].notaFinal;
		}
		double media = total/count;
		out.println("Média final da turma: "+media);
	}
	public static void mostrarMelhorAluno(int count, Aluno[] alunos) {
		double max = 0.0;
		int index = 0;
		for(int i = 0; i < count; i++) {
			if(alunos[i].notaFinal > max) {
				max = alunos[i].notaFinal;
				index = i;
			}
		}
		out.println(alunos[index].nmec);
		out.println(alunos[index].nome);
		out.println(alunos[index].notas[0] + " + " + alunos[index].notas[1] + " + " + alunos[index].notas[2] + " + " + alunos[index].notas[3] + " = " + alunos[index].notaFinal);
	}
}
class Aluno {
	int nmec;
	double notaFinal;
	String nome;
	int[] notas = new int[4];
}