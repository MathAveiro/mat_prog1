import java.util.*;
import static java.lang.System.*;
public class Agenda {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		Contacto[] contactos = new Contacto[100];
		int count = 0;
		char op = 'T';
		do {
			op = menu();
			switch(op) {
				case 'I':
					inserirContacto(contactos, count);
					count++;
					break;
				case 'P': 
					pesquisarContacto(contactos, count);
					break;
				case 'E': 
					boolean e = eliminarContacto(contactos, count);
					if(e) count--;
					break;
				case 'M': 
					mostrarContactos(contactos, count);
					break;
				case 'O':
					mostrarContactosOrdenados(contactos, count);
					break;
				case 'V': 
					validarEmails(contactos, count);
					break;
				case 'A':
					apagarAgenda(contactos, count);
					count = 0;
					break;
				case 'T':
					out.println("O programa vai terminar!");
					break;
				default:
					out.println("Opção inválida!");
					break;
			}
		} while(op != 'T');
	}
	public static char menu() {
		out.println("Gestão de uma agenda: ");
		out.println("I - Inserir um contacto");
		out.println("P - Pesquisar um contacto");
		out.println("E - Eliminar um contacto");
		out.println("M - Mostrar os contactos");
		out.println("O - Mostrar contactos ordenados pelo nome");
		out.println("V - Validar endereços de email");
		out.println("A - Apagar agenda");
		out.println("T - Terminar programa");
		out.print("Opção: ");
		return sc.next().charAt(0);
	}
	public static void inserirContacto(Contacto[] contactos, int count) {
		contactos[count] = new Contacto();
		out.print("Nome: ");
		contactos[count].nome = sc.nextLine();
		out.print("Morada: ");
		contactos[count].morada = sc.nextLine();
		out.print("Email: ");
		contactos[count].email = sc.nextLine();
		out.print("telefone: ");
		contactos[count].telefone = sc.nextInt();
	}
	public static void pesquisarContacto(Contacto[] contactos, int count) {
		boolean existe = false;
		out.print("Nome do contacto a pesquisar: ");
		String name = sc.nextLine();
		for(int i=0; i < count; i++) {
			if(contactos[i].nome.indexOf(name) != -1) {
				existe = true;
				out.println("Nome: "+contactos[i].nome);
				out.println("Morada: "+contactos[i].morada);
				out.println("Email: "+contactos[i].email);
				out.println("Telefone: "+contactos[i].telefone);
				break;
			}
		}
		if(!existe) {
			out.println("O contacto com o nome "+name+", não existe!");
		}
	}
	public static boolean eliminarContacto(Contacto[] contactos, int count) {
		boolean existe = false;
		out.print("Número do contacto a pesquisar: ");
		int numero = sc.nextInt();
		for(int i=0; i < count; i++) {
			if(contactos[i].telefone == numero) {
				existe = true;
				for(int j = i; j < count-1; j++) {
					contactos[j] = contactos[j+1];
				}
				break;
			}
		}
		return existe;
	}
	public static void mostrarContactos(Contacto[] contactos, int count) {
		for(int i = 0; i < count; i++) {
			out.println("Nome: "+contactos[i].nome);
			out.println("Morada: "+contactos[i].morada);
			out.println("Email: "+contactos[i].email);
			out.println("Telefone: "+contactos[i].telefone);
			out.println();
		}
	}
	public static void mostrarContactosOrdenados(Contacto[] contactos, int count) {
		Contacto[] temp = new Contacto[count];
		for (int i = 0; i < count; i++) {
			temp[i] = new Contacto();
			temp[i] = contactos[i];
		}
		for (int i = 0; i < count; i++) {
			for(int j = i+1; j < count; j++) {
				if(temp[i].nome.compareTo(temp[j].nome)>=1) {
					Contacto troca = temp[i];
					temp[i] = temp[j];
					temp[j] = troca;
				}
			}
		}
		for(int i = 0; i < count; i++) {
			out.println("Nome: "+temp[i].nome);
			out.println("Morada: "+temp[i].morada);
			out.println("Email: "+temp[i].email);
			out.println("Telefone: "+temp[i].telefone);
			out.println();
		}
	}
	public static void validarEmails(Contacto[] contactos, int count) {
		boolean valido = true;
		int arrobas = 0;
		for(int i = 0; i < count; i++) {
			arrobas = 0;
			valido = true;
			String email = contactos[i].email;
			for(int j = 0; j < contactos[i].email.length(); j++) {
				if(!Character.isLetter(contactos[i].email.charAt(j)) || !Character.isDigit(contactos[i].email.charAt(j)) || contactos[i].email.charAt(j)!='.' || contactos[i].email.charAt(j)!='-' || contactos[i].email.charAt(j)!='@') {
					valido = false;
				}
				if(contactos[i].email.charAt(j)=='@') {
					arrobas++;
					if(arrobas > 1) valido = false;
				}
				if(!valido) {
					String novo_email;
					do {
						out.println("O email não é válido!");
						out.print("Insira um novo email: ");
						novo_email = sc.nextLine();
						valido = true;
						arrobas = 0;
						for(int k = 0; k < novo_email.length(); k++) {
							if(!Character.isLetter(novo_email.charAt(k)) || !Character.isDigit(novo_email.charAt(k)) || novo_email.charAt(k)!='.' ||novo_email.charAt(k)!='-' || novo_email.charAt(k)!='@') {
								valido = false;
							}
							if(novo_email.charAt(j)=='@') {
								arrobas++;
								if(arrobas > 1) valido = false;
							}
						}
					} while(!valido);
					contactos[i].email = novo_email;
				}				
			}
		}
	}
	public static void apagarAgenda(Contacto[] contactos, int count) {
		for(int i = 0; i < count; i++) {
			contactos[i] = null;
		}
	}
}
class Contacto {
	String nome, morada, email;
	int telefone;
}