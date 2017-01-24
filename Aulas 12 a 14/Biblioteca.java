import java.util.*;
import static java.lang.System.*;
public class Biblioteca {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		Livro[] livros = new Livro[200];
		int op = 0;
		int count = 0;
		do {
			op = menu();
			switch(op) {
				case 1:
					introduzirLivro(count, livros);
					count++;
					break;
				case 2:
					count = removerLivro(count, livros);
					break;
				case 3:
					apagarBD(count, livros);
					count = 0;
					break;
				case 4:
					validarCotas(count, livros);
					break;
				case 5:
					alterarEstado(count, livros);
					break;
				case 6:
					printRequisitados(count, livros);
					break;
				case 7:
					printPorCota(count, livros);
					break;
				case 8:
					printPorData(count, livros);
					break;
				case 9:
					out.println("O programa vai Terminar!");
					break;
				default:
					out.println("Opção inválida!");
					break;
			}
		}while(op!=9);
	}
	public static int menu() {
		out.println("Gestão da Biblioteca");
		out.println("1 - Introduzir um Livro");
		out.println("2 - Remover um Livro");
		out.println("3 - Apagar base de dados");
		out.println("4 - Verificação de cotas repetidas");
		out.println("5 - Alterar estado de um Livro");
		out.println("6 - Listar os livros requesitados");
		out.println("7 - Listar os livros ordenados pela cota");
		out.println("8 - Listar os livros ordenados pela data");
		out.println("9 - Terminar o programa");
		out.print("Opção: ");
		return sc.nextInt();
	}
	public static void introduzirLivro(int count, Livro[] livros) {
		livros[count] = new Livro();
		boolean valido = false;
		do {
			out.print("Cota do Livro: ");
			String cota = sc.nextLine();
			if(cota.length() == 20) {
				valido = true;
				livros[count].cota = cota;
			} else {
				valido = false;
				out.println("Valor da cota inválido!");
			}
		} while(!valido);
		valido = false;
		do {
			out.print("Autor: ");
			String autor = sc.nextLine();
			if(autor.length() <= 40) {
				valido = true;
				livros[count].autor = autor;
			} else {
				valido = false;
				out.println("Nome do autor demasiado extenso!");
			}
		} while(!valido);
		valido = false;
		do {
			out.print("Título: ");
			String título = sc.nextLine();
			if(título.length() <= 20) {
				valido = true;
				livros[count].título = título;
			} else {
				valido = false;
				out.println("Nome do livro demasiado extenso!");
			}
		} while(!valido);
		out.print("Data(dd/mm/aa): ");
		String data = sc.nextLine();
		livros[count].data =100000 * Integer.parseInt(Character.toString(data.charAt(0))) + 10000 * Integer.parseInt(Character.toString(data.charAt(1))) + 1000 * Integer.parseInt(Character.toString(data.charAt(3))) + 100 * Integer.parseInt(Character.toString(data.charAt(4))) + 10*Integer.parseInt(Character.toString(data.charAt(6))) + Integer.parseInt(Character.toString(data.charAt(7)));
		valido = false;
		do {
			out.print("Estado: ");
			char estado = sc.nextLine().charAt(0);
			if(estado != 'R' || estado != 'L' || estado != 'C') {
				valido = false;
				out.println("Estado inválido!");
			} else {
				valido = true;
				livros[count].estado = estado;
			}
		} while(!valido);
	}
	public static int removerLivro(int count, Livro[] livros) {
		boolean valido = false;
		boolean existe = false;
		int index = 0;
		do {
			out.print("Cota do Livro: ");
			String cota = sc.nextLine();
			if(cota.length() == 20) {
				valido = true;
				for(int i = 0; i < count; i++) {
					if(livros[i].cota.compareTo(cota)!=0) {
						existe = false;
						break;
					} else {
						existe = true;
						index = i;
					}
				}
				if(!existe) {
					out.println("Não existe nenhum livro com essa cota!");
				} else {
					for(int i = index; i < count; i++) {
						for(int j = i + 1; j < count; j++) {
							livros[i] = livros[j];
						}
					}
					livros[count-1] = null;
					count--;
				}
			} else {
				valido = false;
				out.println("Valor da cota inválido!");
			}
		} while(!valido);
		return count;
	}
	public static void apagarBD(int count, Livro[] livros) {
		for(int i = 0; i < count; i++) {
			livros[i] = null;
		}
	}
	public static void validarCotas(int count, Livro[] livros) {
		for(int i = 0; i < count; i++) {
			for (int j = 0; j < count; j++) {
				if(i == j) j++;
				if(j == count) break;
				if(livros[i].cota.equals(livros[j].cota)) {
					boolean valido = false;
					do {
						out.print("Introduzir nova cota para o livro "+livros[j].título+": ");
						String cota = sc.nextLine();
						for(int k = 0; k < count; k++) {
							if(livros[k].cota.equals(cota)) {
								valido = false;
								break;
							} else {
								valido = true;
							}
						}
						if(valido) livros[j].cota = cota;
					} while(!valido);
				}
			}
		}
	}
	public static void alterarEstado(int count, Livro[] livros) {
		boolean valido = false;
		boolean existe = false;
		int index = 0;
		do {
			out.print("Cota do Livro: ");
			String cota = sc.nextLine();
			if(cota.length() == 20) {
				valido = true;
				for(int i = 0; i < count; i++) {
					if(livros[i].cota.compareTo(cota)!=0) {
						existe = false;
						break;
					} else {
						existe = true;
						index = i;
					}
				}
				if(!existe) {
					out.println("Não existe nenhum livro com essa cota!");
				} else {
					boolean possivel = false;
					do {
						possivel = true;
						out.println("Estado atual do Livro: "+livros[index].estado);
						out.print("Novo estado: ");
						char estado = sc.nextLine().charAt(0);
						if(estado == 'L') {
							if(estado == 'R' || estado == 'C') {
								possivel = true;
							}
						}
						else if ( estado == 'R') {
							if(estado == 'L') {
								possivel = true;
							}
						}
						else if ( estado == 'C') {
							if(estado == 'L') {
								possivel = true;
							}
						}
						if(possivel) {
							livros[index].estado = estado;
						} else {
							out.println("Mudança de estado inválida! Tente novamente!");
						}
					}while(!possivel);
				}
			} else {
				valido = false;
				out.println("Valor da cota inválido!");
			}
		} while(!valido);
	}
	public static void printLivro(int index, Livro[] livros) {
		out.println("Cota: "+livros[index].cota);
		out.println("Autor: "+livros[index].autor);
		out.println("Título: "+livros[index].título);
		out.println("Data: "+printData(livros[index].data));
		out.println("Estado: "+livros[index].estado);
	}
	public static String printData(int data) {
		String dataString = Integer.toString(data);
		String finalData = dataString.charAt(0)+dataString.charAt(1)+"/"+dataString.charAt(2)+dataString.charAt(3)+"/"+dataString.charAt(4)+dataString.charAt(5);
		return finalData;
	}
	public static void printRequisitados(int count, Livro[] livros) {
		for(int i = 0; i < count; i++) {
			if(livros[i].estado == 'R') {
				printLivro(i, livros);
			}
		}
	}
	public static void printPorCota(int count, Livro[] livros) {
		Livro[] aux = new Livro[count];
		for (int i = 0; i < count; i++) {
			aux[i] = new Livro();
			aux[i] = livros[i];
		}
		for(int i = 0; i < count; i++) {
			for (int j = i+1; j < count;  j++) {
				if(aux[i].cota.compareTo(aux[j].cota) > 0) {
					Livro temp = aux[i];
					aux[i] = aux[j];
					aux[j] = temp;
				}
			} 
		}
		for (int i = 0; i < count; i++) {
			printLivro(i, aux);
		}
	}
	public static boolean compararDatas(int data1, int data2) {
		String dataString1 = Integer.toString(data1);
		String dataString2 = Integer.toString(data2);
		int ano1 = 10*Integer.parseInt(Character.toString(dataString1.charAt(4))) + Integer.parseInt(Character.toString(dataString1.charAt(5)));
		int ano2 = 10*Integer.parseInt(Character.toString(dataString2.charAt(4))) + Integer.parseInt(Character.toString(dataString2.charAt(5)));
		if(ano1 > ano2) {
			return true;
		} else if (ano1 < ano2) {
			return false;
		} else {
			int mes1 = 10*Integer.parseInt(Character.toString(dataString1.charAt(2))) + Integer.parseInt(Character.toString(dataString1.charAt(3)));
			int mes2 = 10*Integer.parseInt(Character.toString(dataString2.charAt(2))) + Integer.parseInt(Character.toString(dataString2.charAt(3)));
			if(mes1 > mes2) {
				return true;
			} else if (mes1 < mes2) {
				return false;
			} else {
				int dia1 = 10*Integer.parseInt(Character.toString(dataString1.charAt(0))) + Integer.parseInt(Character.toString(dataString1.charAt(1)));
				int dia2 = 10*Integer.parseInt(Character.toString(dataString2.charAt(0))) + Integer.parseInt(Character.toString(dataString2.charAt(1)));
				if(dia1 > dia2) {
					return true;
				} else {
					return false;
				}
			}
		}
	}
	public static void printPorData(int count, Livro[] livros) {
		Livro[] aux = new Livro[count];
		for (int i = 0; i < count; i++) {
			aux[i] = new Livro();
			aux[i] = livros[i];
		}
		for(int i = 0; i < count; i++) {
			for (int j = i+1; j < count;  j++) {
				if(compararDatas(aux[i].data, aux[j].data)) {
					Livro temp = aux[i];
					aux[i] = aux[j];
					aux[j] = temp;
				}
			} 
		}
		for (int i = 0; i < count; i++) {
			printLivro(i, aux);
		}
	}
}
class Livro {
	String cota;
	String autor;
	String título;
	int data;
	char estado;
}