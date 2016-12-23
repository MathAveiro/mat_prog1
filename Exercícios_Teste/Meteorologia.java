import java.util.Scanner;
import static java.lang.System.*;
import java.io.*;

public class Meteorologia {

	static final Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) throws IOException{
		int op;	
		Data arrData[]=new Data[31];
		String nameIn = "";
		
		do{
			op = menu();
			System.out.println();		
			switch(op){
			case 1:
				nameIn = lerFicheiro(arrData);
				break;
			case 2:
				adicionarMedida(arrData, nameIn);
				break;
			case 3:
				imprimirMedidas(arrData);
				break;
			case 4:
				temperaturaCrescente(arrData);
				break;
			case 5:
				humidadeCrescente(arrData);
				break;
			case 6:
				medidasMedias(arrData);
				break;
			case 7:
				valoresExtremos(arrData);
				break;
			case 8:
				histogramaTemperatura(arrData);
				histogramaHumidade(arrData);
				break;
			case 9: 
				out.println("O programa vai terminar!");
				break;
			default:
				out.print("\n\nValor inválido!\n\n");
				break;
			}
		}while(op!=9);

	}

	public static int menu() {
		out.println("\nEstação metereológica:");
		out.println("1 - Ler ficheiro de dados");
		out.println("2 - Acrescentar medida");
		out.println("3 - Listar valores de temperatura e humidade");
		out.println("4 - Listar medidas ordenadas por valor de temperatura");
		out.println("5 - Listar medidas ordenadas por valor de humidade");
		out.println("6 - Calcular valores médios de temperatura e humidade");
		out.println("7 - Calcular valores máximos e mínimos de temperatura e humidade");
		out.println("8 - Calcular histograma das temperaturas e humidade");
		out.println("9 - Terminar programa");
		out.print("Opção: ");
		return sc.nextInt();
	}
	
	public static String lerFicheiro(Data []arrData) throws IOException{
		String nameIn;
		File fin;
		int i=countDatas(arrData);
		do{
			out.print("Nome do ficheiro: ");
			nameIn=sc.next();
			fin = new File(nameIn);
		}while(!fin.canRead()||!fin.exists()||!fin.isFile());

		Scanner scf = new Scanner (fin);
		
		while (scf.hasNextLine()){
			if(i==31) break;
			else if(!scf.hasNext()) break;
			arrData[i]=new Data();
			arrData[i].temp=scf.nextInt();
			arrData[i].hum=scf.nextInt();
			i++;
		}
		out.println("Valores lidos com sucesso!");
		scf.close();
		return nameIn;
	}

	public static void adicionarMedida(Data []arrData, String nameIn)throws IOException{
		int n=countDatas(arrData);
		int temp;
		
		if(n==31){
			out.println("\nA base de dados está completa!");
			return;
		}
		else arrData[n]=new Data();
		
		do{
			out.print("Insira uma nova temperatura: ");
			temp=sc.nextInt();
		}while(temp<-10 || temp>40);
		arrData[n].temp=temp;
		
		do{
			out.print("Insira a humidade: ");
			temp=sc.nextInt();
		}while(temp<0||temp>100);
		arrData[n].hum=temp;

		PrintWriter pw = new PrintWriter(new File(nameIn));
		for(int i = 0; i<=n; i++) {
			pw.println(arrData[i].temp+" "+arrData[i].hum);
		}
		pw.close();
		out.println("Os novos valores foram armazenados com sucesso!");


	}

	public static void imprimirMedidas(Data []arrData){
		int n=countDatas(arrData);

		out.print("Temperatura:\tHumidade:\n");
		for(int i=0;i<n;i++){
			out.printf("%12d\t%9d\n",arrData[i].temp, arrData[i].hum );
		}
	}
	
	public static void temperaturaCrescente(Data []arrData){
		int n=countDatas(arrData);
		boolean change;
		
		do{
			change=false;
			
			for(int i=0;i<n-1;i++){
				if(arrData[i].temp>arrData[i+1].temp){
					Data[]temp=new Data[1];
					temp[0]=arrData[i];
					arrData[i]=arrData[i+1];
					arrData[i+1]=temp[0];
					change=true;
				}
			}
		}while(change);
		
		imprimirMedidas(arrData);
	}

	public static void humidadeCrescente(Data []arrData){
		int n=countDatas(arrData);
		boolean change;
		
		do{
			change=false;
			
			for(int i=0;i<n-1;i++){
				if(arrData[i].hum<arrData[i+1].hum){
					Data[]temp=new Data[1];
					temp[0]=arrData[i];
					arrData[i]=arrData[i+1];
					arrData[i+1]=temp[0];
					change=true;
				}
			}
		}while(change);
		
		imprimirMedidas(arrData);
	}
	
	public static void medidasMedias(Data []arrData){
		int n=countDatas(arrData);
		int tempMed, humMed;
		boolean change;
		
		do{
			change=false;
			
			for(int i=0;i<n-1;i++){
				if(arrData[i].temp>arrData[i+1].temp){
					Data[]temp=new Data[1];
					temp[0]=arrData[i];
					arrData[i]=arrData[i+1];
					arrData[i+1]=temp[0];
					change=true;
				}
			}
		}while(change);
		
		tempMed=arrData[(n-1)/2].temp;
		
		do{
			change=false;
			
			for(int i=0;i<n-1;i++){
				if(arrData[i].hum>arrData[i+1].hum){
					Data[]temp=new Data[1];
					temp[0]=arrData[i];
					arrData[i]=arrData[i+1];
					arrData[i+1]=temp[0];
					change=true;
				}
			}
		}while(change);
		
		humMed=arrData[(n-1)/2].hum;
		
		out.println("O valor médio da temperatura é "+tempMed+" e o valor médio de humidade é "+humMed+".");
	}
	
	public static void valoresExtremos(Data []arrData){
		int n=countDatas(arrData);
		int temperaturaMaxima=-10, humidadeMaxima=0, temperaturaMinima=40, temperatiraMinima=100;
		
		for(int i=0;i<n;i++){
			if(temperaturaMaxima<arrData[i].temp) temperaturaMaxima=arrData[i].temp;
			if(humidadeMaxima<arrData[i].hum) humidadeMaxima=arrData[i].hum;
			if(temperaturaMinima>arrData[i].temp) temperaturaMinima=arrData[i].temp;
			if(temperatiraMinima>arrData[i].hum) temperatiraMinima=arrData[i].hum;
		}
		
		out.println("O valor máximo de temperatura é "+temperaturaMaxima+" e o mínimo é de "+temperaturaMinima+".");
		out.println("O valor máximo de humidade é "+humidadeMaxima+" e o mínimo é de "+temperatiraMinima+".");
		
	}
	
	public static void histogramaTemperatura(Data []arrData){
		int n=countDatas(arrData);
		
		out.print("\n\nHistograma da temperatura");
		out.print("\n---------------------------\n");
		
		for(int i=-10;i<=40;i++){
			out.printf("%3d | ",i);
			out.print(counts(i,"temp",arrData)+"\n");
		}
	}
	
	public static void histogramaHumidade(Data []arrData){
		int n=countDatas(arrData);
		
		out.print("\n\nHistograma da humidade");
		out.print("\n---------------------------\n");
		
		for(int i=0;i<=100;i++){
			out.printf("%3d | ",i);
			out.print(counts(i,"hum",arrData)+"\n");
		}
	}
	
	public static String counts(int i, String a, Data []arrData){
		String res="";
		int n=countDatas(arrData);
		
		switch(a){
		
		case "temp":
			for(int j=0;j<n;j++){
				if(i==arrData[j].temp) res+="*";
			}
			break;
			
		case "hum":
			for(int j=0;j<n;j++){
				if(i==arrData[j].hum) res+="*";
			}
			break;
		}
		
		return res;
	}
	
	public static int countDatas(Data []arrData){
		int i=0;
		
		for(int n=0;n<31;n++){
			if(arrData[n]==null) break;
			else i++;
		}
		
		return i;
	}
}

class Data{
	int temp;
	int hum;
}