import java.util.*;
public class A06_04 {
	static Scanner sc = new Scanner (System.in);
	
	public static void main (String[] args) {
		System.out.print("Quantas notas irá introduzir?");
		int n = sc.nextInt();
		int DIM = n; 
		int cont=0, contagem=0;
		int a[] = new int [DIM]; 
		int q;
		String c = "*";
		do{
			q = sc.nextInt();
			if(q >= 0 && q <= 20)
			{
				a[cont] = q;
				cont++;
			}		
		}while(q != 0 && cont < n);
	
		System.out.print("-----------------------\n| Histograma de notas |\n-----------------------\n");
		for(int j=0; j<=20; j++){
			contagem=0;
			for(int i = 0; i<cont; i++){
				if(a[i] == j){
					contagem++;
				}
			}
			System.out.printf(" %d |",j); 
			printNtimes((50*contagem/n),c);
			System.out.print("\n");
		}
	}
	public static void printNtimes (int x, String s){ 
		for (int i = 0 ; i<x; i++){ 
			System.out.print(s);} 
	}
	
}
