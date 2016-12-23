/*
 * Boas Festas!!!!!
 */

import java.util.*;
import java.io.*;
import static java.lang.System.*;
public class Pilotos{
	static Scanner sc=new Scanner (in);
	public static void main(String[]args){

		int n=0,m=0,op=0,temp=0;
		Piloto[]p=new Piloto[10];
		Piloto[]j=new Piloto[10];
		for(n=0;n<10;n++){
			p[n]=new Piloto();
		}
		for(m=0;n<10;m++){
			p[m]=new Piloto();
		}
		n = 0;

		do{
			op=funcaoMenu();
			switch(op){
				case 1:
				n=funcaoPiloto(p,n);
				break;
				case 2:
				funcaoListar(p,n);
				break;
				case 3:
				funcaoAlterar(p,n);
				break;
				case 4:
				n=funcaoRemover(p,n);
				break;
				case 5:
				funcaoListarNome(p,n);
				break;
				case 6:
				n=funcaoRemoverNome(p,j,n);
				break;
				case 7:
				validarMatricula(p,n);
				break;
				case 8:
				out.println("O programa vai terminar");
				break;
			}
		}while(op!=8);
	}
	public static int funcaoMenu(){
		out.println();
		out.println("1 - Inserir informação dos pilotos");
		out.println("2 - Listar pilotos ordenados pelo número da viatura");
		out.println("3 - Alterar informação de um piloto");
		out.println("4 - Remover piloto com base no número da viatura");
		out.println("5 - Listar pilotos ordenados pelo nome");
		out.println("6 - Remover piloto(s) com base no nome");
		out.println("7 - Validar matriculas");
		out.println("8 - Terminar programa");
		out.println();
		int op=0;
		do{
			out.print("Opção:");
			op=sc.nextInt();
			if(!((op>0&&op<9))){
				out.println("Opção inválida");
			}
		} while(!(op>0&&op<9));
		return op;
	}
	public static int funcaoPiloto(Piloto[]p,int n){
		int k=n;
		do{
			sc.nextLine();
			String[]campos;
			out.println("Introduza o nome do piloto:");
			p[n].nome=sc.nextLine();
			String temp=p[n].nome;
			if(temp.length()==0) break;
			else{
				out.println("Introduza a matricula do veículo (aa-bb-cc):");
				String matricula=sc.next();
				campos=matricula.split("-");
				out.println(campos.length);
				p[n].aa=campos[0];
				if (campos.length >= 2) {
					p[n].nn=campos[1];
					if (campos.length >= 3) {
						p[n].bb=campos[2];						
					}
				}
				p[n].nviatura=n+1;
				p[n].cont=k++;
			}
			n++;
		}while(n<10);
		return n;
	}
	public static void funcaoListar(Piloto[]p,int n){
		int i;
		for(i=0;i<n;i++){
			out.printf("Número da viatura:%d\tNome do piloto:%s\tMatrícula da viatura:%s-%s-%s\n",p[i].nviatura,p[i].nome,p[i].aa,p[i].nn,p[i].bb);
		}
	}
	public static void funcaoAlterar(Piloto[]p,int n){
		out.println("Introduza o nº da viatura à qual pretende alterar a informação do piloto:");
		int i=sc.nextInt();
		int existe=0;
		for(int temp=0;temp<=n;temp++){
			if(i==p[temp].nviatura){
				String[]campos;
				sc.nextLine();
				out.println("Introduza o novo nome do piloto:");
				p[temp].nome=sc.nextLine();
				out.println("Introduza a matricula do veículo (aa-bb-cc):");
				String matricula=sc.next();
				campos=matricula.split("-");

				p[temp].aa=campos[0];
				if (campos.length >= 2) {
					p[temp].nn=campos[1];
					if (campos.length >= 3) {
						p[temp].bb=campos[2];						
					}
				}

				existe=1;
			}
			if(existe!=1&&temp==n){
				out.println("A viatura selecionada não existe");
			}
		}
	}
	public static int funcaoRemover(Piloto[]p,int n){
		out.println("Introduza o número da viatura que pretende remover:");
		int i=sc.nextInt();
		for(int temp=0;temp<=n;temp++){
			if(i==p[temp].nviatura){
				for(int j=temp;j<=n;j++){
					p[j]=p[j+1];	
				}
			}
		}
		return n-1;
	}
	public static void funcaoListarNome(Piloto[]p,int n){

		Piloto[]temp=new Piloto[10];
		for(int u=0;u<10;u++){
			temp[u]=new Piloto();
			temp[u] = p[u];
		}

		for (int i = 0; i < n ; i++) {

			for(int j = i; j < n ; j++){
				if(temp[i].nome.compareTo(temp[j].nome)>0){
					Piloto temp1 = temp[i];
					temp[i] = temp[j];
					temp[j] = temp1;
				}
			}
		}

		for(int i=0;i<n;i++){
			out.printf("Número da viatura:%d\tNome do piloto:%s\tMatrícula da viatura:%s-%s-%s\n",temp[i].nviatura,temp[i].nome,temp[i].aa,temp[i].nn,temp[i].bb);
		}
	}
	public static int funcaoRemoverNome(Piloto[]p,Piloto[]j,int n){
		out.println("Introduza o nome do piloto que pretende remover:");
		String s1temp=sc.next();
		int op=0,k=0,o=0;
		out.println("Contacto a remover:");
		for(int i=0;i<=n;i++){
			if(p[i].nome.indexOf(s1temp)==0){
				out.printf("%d | Nome: %s\n",k+1,p[i].nome);
				j[k]=p[i];
				k++;
			}
		}
		op=sc.nextInt();
		for(int temp=0;temp<=n;temp++){
			if(j[op-1].nome==p[temp].nome){
				for(int temp2=temp;temp2<=n;temp2++){
					p[temp2]=p[temp2+1];	
				}
			}
		}
		return n-1;
	}

	public static void validarMatricula (Piloto[]p, int n) {
		for (int i = 0; i < n ; i++) {
			do {
				String[]campos;
				if (p[i].aa.length() == 0 || p[i].nn.length() == 0 || p[i].bb.length() == 0 || (p[i].aa.length() > 2 || p[i].nn.length() > 2 || p[i].bb.length() > 2)) {
					out.printf("Nome do piloto:%s\n\n",p[i].nome);
					do {
						out.println("[Parte null] Introduza a nova matricula do veículo (aa-bb-cc):");
						String matricula=sc.next();
						campos=matricula.split("-");

						p[i].aa=campos[0];
						if (campos.length >= 2) {
							p[i].nn=campos[1];
							if (campos.length >= 3) {
								p[i].bb=campos[2];						
							}
						}
						out.printf("Número da viatura:%d\tNome do piloto:%s\tMatrícula da viatura:%s-%s-%s\n",p[i].nviatura,p[i].nome,p[i].aa,p[i].nn,p[i].bb);
					} while (p[i].aa.length() == 0 || p[i].nn.length() == 0 || p[i].bb.length() == 0 || (p[i].aa.length() > 2 || p[i].nn.length() > 2 || p[i].bb.length() > 2));
				}

				if (!((soContemNumeros(p[i].aa) && soContemNumeros(p[i].bb) && soContemLetras(p[i].nn)) || (soContemNumeros(p[i].aa) && soContemLetras(p[i].bb) && soContemNumeros(p[i].nn)) || (soContemLetras(p[i].aa) && soContemNumeros(p[i].bb) && soContemNumeros(p[i].nn)))) {
					out.printf("Nome do piloto:%s\n\n",p[i].nome);
					do {
						out.println("[Parte sem validação] Introduza a nova matricula do veículo (aa-bb-cc):");
						String matricula=sc.next();
						campos=matricula.split("-");

						p[i].aa=campos[0];
						if (campos.length >= 2) {
							p[i].nn=campos[1];
							if (campos.length >= 3) {
								p[i].bb=campos[2];						
							}
						}
						out.printf("Número da viatura:%d\tNome do piloto:%s\tMatrícula da viatura:%s-%s-%s\n",p[i].nviatura,p[i].nome,p[i].aa,p[i].nn,p[i].bb);
					} while (!((soContemNumeros(p[i].aa) && soContemNumeros(p[i].bb) && soContemLetras(p[i].nn)) || (soContemNumeros(p[i].aa) && soContemLetras(p[i].bb) && soContemNumeros(p[i].nn)) || (soContemLetras(p[i].aa) && soContemNumeros(p[i].bb) && soContemNumeros(p[i].nn))));
				}
			} while ((p[i].aa.length() == 0 || p[i].nn.length() == 0 || p[i].bb.length() == 0 || (p[i].aa.length() > 2 || p[i].nn.length() > 2 || p[i].bb.length() > 2)) || !((soContemNumeros(p[i].aa) && soContemNumeros(p[i].bb) && soContemLetras(p[i].nn)) || (soContemNumeros(p[i].aa) && soContemLetras(p[i].bb) && soContemNumeros(p[i].nn)) || (soContemLetras(p[i].aa) && soContemNumeros(p[i].bb) && soContemNumeros(p[i].nn))));
		} 
	}

	public static boolean soContemNumeros(String texto) {
		return texto.matches("[0-9]*");
	}

	public static boolean soContemLetras(String texto) {
		return texto.matches( "[a-zA-Z]*");
	}

}
class Piloto{
	int nviatura;
	String nome,aa,nn,bb;
	int cont;
}