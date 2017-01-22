import java.util.*;
import static java.lang.System.*;

public class Turmas {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		Aluno[][] alunos = new Aluno[10][20];
		int count = 0;
		int op = 0;
		int turma = 0;
		do {
			op = menu();
			switch(op) {
				case 1:
					out.print("Turma: ");
					turma = sc.nextInt();
					count = inserirInfo(turma, count, alunos);
					break;
				case 2:
					out.print("Turma: ");
					turma = sc.nextInt();
					mostrarInfo(turma, count, alunos);
					break;
				case 3:
					out.print("Turma: ");
					turma = sc.nextInt();
					count = alterarInfo(turma, count, alunos);
					break;
				case 4:
					out.print("Turma: ");
					turma = sc.nextInt();
					mostrarInfoPorNMEC(turma, count, alunos);
					break;
				case 5:
					out.print("Turma: ");
					turma = sc.nextInt();
					mostrarInfoPorNF(turma, count, alunos);
					break;
				case 6:
					out.print("Turma: ");
					turma = sc.nextInt();
					calcularMediaFinal(turma, count, alunos);
					break;
				case 7:
					out.print("Turma: ");
					turma = sc.nextInt();
					mostrarMelhorAluno(turma, count, alunos);
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
		out.printf("Gestão de uma turma:\n1 - Inserir informação numa turma\n2 - Mostrar informação de um aluno\n3 - Alterar informação de um aluno\n4 - Listar alunos ordenados pelo nmec\n5 - Listar alunos ordenados pela nota final\n6 - Média das notas finais\n7 - Melhor aluno\n0 - Terminar programa\nOpção: ");
		return sc.nextInt();
	}
	public static int inserirInfo(int turma, int count, Aluno[][] alunos) {
		int nmec = 0;
		do {
			alunos[turma-1][count] = new Aluno();
			out.print("Número mecanográfico: ");
			nmec = sc.nextInt();
			if(nmec==0) break;
			alunos[turma-1][count].nmec = nmec;
			out.print("Nome do aluno: ");
			alunos[turma-1][count].nome = sc.nextLine();
			int nota1 = 0, nota2 = 0, nota3 = 0, nota4 = 0;
			do {
				out.print("1ª Nota: ");
				nota1 = sc.nextInt();
			}while(nota1>20 || nota1<0);
			alunos[turma-1][count].notas[0] = nota1;
			do {
				out.print("2ª Nota: ");
				nota2 = sc.nextInt();
			}while(nota2>20 || nota2<0);
			alunos[turma-1][count].notas[1] = nota2;
			do {
				out.print("3ª Nota: ");
				nota3 = sc.nextInt();
			}while(nota3>20 || nota3<0);
			alunos[turma-1][count].notas[2] = nota3;
			do {
				out.print("4ª Nota: ");
				nota4 = sc.nextInt();
			}while(nota4>20 || nota4<0);
			alunos[turma-1][count].notas[3] = nota4;
			double notaFinal = 0;
			notaFinal += alunos[turma-1][count].notas[0] * 0.1;
			notaFinal += alunos[turma-1][count].notas[1] * 0.3;
			notaFinal += alunos[turma-1][count].notas[2] * 0.1;
			notaFinal += alunos[turma-1][count].notas[3] * 0.5;
			alunos[turma-1][count].notaFinal = notaFinal;
			count++;
		}while(nmec!=0);
		return count;
	}
	public static void mostrarInfo(int turma, int count, Aluno[][] alunos) {
		out.print("Nº mecanográfico do aluno: ");
		boolean existe = false;
		int index = 0;
		int nmec = sc.nextInt();
		for (int i = 0; i < count; i++) {
			if(nmec == alunos[turma-1][i].nmec) {
				existe = true;
				index  = i;
				break;
			}
		}
		if(!existe) {
			out.println("O aluno não existe!");
		} else {
			out.println(alunos[turma-1][index].nmec);
			out.println(alunos[turma-1][index].nome);
			out.println(alunos[turma-1][index].notas[0] + " + " + alunos[turma-1][index].notas[1] + " + " + alunos[turma-1][index].notas[2] + " + " + alunos[turma-1][index].notas[3] + " = " + alunos[turma-1][index].notaFinal);
		}
	}
	public static int alterarInfo(int turma, int count, Aluno[][] alunos) {
		out.print("Nº mecanográfico do aluno: ");
		boolean existe = false;
		int index = 0;
		int nmec = sc.nextInt();
		for (int i = 0; i < count; i++) {
			if(nmec == alunos[turma-1][i].nmec) {
				existe = true;
				index  = i;
				break;
			}
		}
		if(!existe) {
			out.println("O aluno não existe!");
			if(count < 20) {
				alunos[turma-1][count] = new Aluno();
				out.println("Adicionar novo aluno: ");
				alunos[turma-1][count].nmec = nmec;
				out.print("Nome do aluno: ");
				alunos[turma-1][count].nome = sc.nextLine();
				int nota1 = 0, nota2 = 0, nota3 = 0, nota4 = 0;
				do {
					out.print("1ª Nota: ");
					nota1 = sc.nextInt();
				}while(nota1>20 || nota1<0);
				alunos[turma-1][count].notas[0] = nota1;
				do {
					out.print("2ª Nota: ");
					nota2 = sc.nextInt();
				}while(nota2>20 || nota2<0);
				alunos[turma-1][count].notas[1] = nota2;
				do {
					out.print("3ª Nota: ");
					nota3 = sc.nextInt();
				}while(nota3>20 || nota3<0);
				alunos[turma-1][count].notas[2] = nota3;
				do {
					out.print("4ª Nota: ");
					nota4 = sc.nextInt();
				}while(nota4>20 || nota4<0);
				alunos[turma-1][count].notas[3] = nota4;
				double notaFinal = 0;
				notaFinal += alunos[turma-1][count].notas[0] * 0.1;
				notaFinal += alunos[turma-1][count].notas[1] * 0.3;
				notaFinal += alunos[turma-1][count].notas[2] * 0.1;
				notaFinal += alunos[turma-1][count].notas[3] * 0.5;
				alunos[turma-1][count].notaFinal = notaFinal;
				count++;
			}
		} else {
			int nota1 = 0, nota2 = 0, nota3 = 0, nota4 = 0;
			do {
				out.print("1ª Nota: ");
				nota1 = sc.nextInt();
			}while(nota1>20 || nota1<0);
			alunos[turma-1][index].notas[0] = nota1;
			do {
				out.print("2ª Nota: ");
				nota2 = sc.nextInt();
			}while(nota2>20 || nota2<0);
			alunos[turma-1][index].notas[1] = nota2;
			do {
				out.print("3ª Nota: ");
				nota3 = sc.nextInt();
			}while(nota3>20 || nota3<0);
			alunos[turma-1][index].notas[2] = nota3;
			do {
				out.print("4ª Nota: ");
				nota4 = sc.nextInt();
			}while(nota4>20 || nota4<0);
			alunos[turma-1][index].notas[3] = nota4;
			int notaFinal = 0;
			notaFinal += alunos[turma-1][index].notas[0] * 0.1;
			notaFinal += alunos[turma-1][index].notas[1] * 0.3;
			notaFinal += alunos[turma-1][index].notas[2] * 0.1;
			notaFinal += alunos[turma-1][index].notas[3] * 0.5;
			alunos[turma-1][index].notaFinal = notaFinal;
		}
		return count;
	}
	public static void mostrarInfoPorNMEC(int turma, int count, Aluno[][] alunos) {
		for(int i = 0; i < count; i++) {
			for(int j = i+1; j < count; j++) {
				if(alunos[turma-1][i].nmec > alunos[turma-1][j].nmec) {
					int temp = alunos[turma-1][i].nmec;
					alunos[turma-1][i].nmec = alunos[turma-1][j].nmec;
					alunos[turma-1][j].nmec = temp;
				}
			}
		}
		for(int index = 0; index < count; index++) {
			out.println(alunos[turma-1][index].nmec);
			out.println(alunos[turma-1][index].nome);
			out.println(alunos[turma-1][index].notas[0] + " + " + alunos[turma-1][index].notas[1] + " + " + alunos[turma-1][index].notas[2] + " + " + alunos[turma-1][index].notas[3] + " = " + alunos[turma-1][index].notaFinal);
		}
	}
	public static void mostrarInfoPorNF(int turma, int count, Aluno[][] alunos) {
		for(int i = 0; i < count; i++) {
			for(int j = i+1; j < count; j++) {
				if(alunos[turma-1][i].notaFinal > alunos[turma-1][j].notaFinal) {
					double temp = alunos[turma-1][i].notaFinal;
					alunos[turma-1][i].notaFinal = alunos[turma-1][j].notaFinal;
					alunos[turma-1][j].notaFinal = temp;
				}
			}
		}
		for(int index = 0; index < count; index++) {
			out.println(alunos[turma-1][index].nmec);
			out.println(alunos[turma-1][index].nome);
			out.println(alunos[turma-1][index].notas[0] + " + " + alunos[turma-1][index].notas[1] + " + " + alunos[turma-1][index].notas[2] + " + " + alunos[turma-1][index].notas[3] + " = " + alunos[turma-1][index].notaFinal);
		}
	}
	public static void calcularMediaFinal(int turma, int count, Aluno[][] alunos) {
		int total = 0;
		for(int i = 0; i < count; i++) {
			total += alunos[turma-1][i].notaFinal;
		}
		double media = total/count;
		out.println("Média final da turma: "+media);
	}
	public static void mostrarMelhorAluno(int turma, int count, Aluno[][] alunos) {
		double max = 0.0;
		int index = 0;
		for(int i = 0; i < count; i++) {
			if(alunos[turma-1][i].notaFinal > max) {
				max = alunos[turma-1][i].notaFinal;
				index = i;
			}
		}
		out.println(alunos[turma-1][index].nmec);
		out.println(alunos[turma-1][index].nome);
		out.println(alunos[turma-1][index].notas[0] + " + " + alunos[turma-1][index].notas[1] + " + " + alunos[turma-1][index].notas[2] + " + " + alunos[turma-1][index].notas[3] + " = " + alunos[turma-1][index].notaFinal);
	}
}
class Aluno {
	int nmec;
	double notaFinal;
	String nome;
	int[] notas = new int[4];
}