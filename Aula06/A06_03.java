import java.util.*;
public class A06_03 {
	static Scanner sc = new Scanner (System.in);
	
	public static void main (String[] args) {
		int op, n= 50;
		int count = 0;
		int [] a = new int [50];
		do{
			op = menu ();
			switch(op){
				case 1: count = lerSequencia(a,count);;
					break;
				case 2: escreverSequencia(a, count);
					break;
				case 3: maxSequencia(a, count);
					break;
				case 4: minSequencia(a, count);
					break;
				case 5: mediaSequencia(a, count);
					break;
				case 6: seqPares(a, count);
					break;
				case 10: System.out.println("O programa vai terminar!");
					break;
				default: System.out.println("Opção Inválida!");
					break;
			}
		}while(op != 10);
	}
	
	public static int menu() {
		System.out.println("\nAnálise de uma sequência de números inteiros.");
		System.out.println("1 - Ler a sequência.");
		System.out.println("2 - Escrever a sequência.");
		System.out.println("3 - Calcular o máximo da sequência.");
		System.out.println("4 - Calcular o mínimo da sequência.");
		System.out.println("5 - Calcular a média da sequência.");
		System.out.println("6 - Detetar se é uma sequência só constituída por números pares.");
		System.out.println("10 - Terminar o programa.");
		System.out.print("Opção: ");
		int op = sc.nextInt();
		return op;
	}
	
	public static int lerSequencia(int[]a, int count) {
		int n = 50;
		for(int i=0; i<n; i++){
			System.out.print(" Numero " + i + ": ");
			a[i] = sc.nextInt ();
			if (a[i] <=0) {
				break;
			}
			count++;
		}
		return count;
	}
	
	public static void escreverSequencia(int[]a, int count) {
		int n = 50;
		System.out.print(" A sequencia introduzida foi: ");
		for(int i=0; i<count; i++){
			System.out.print(a[i] + ",");
		}
	}
	
	public static int maxSequencia(int[]a, int count) {
		int max;
		max = a[0];
		for (int i=0; i<count; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}
		System.out.println("O número máximo introduzido foi: " + max);	
		return count;
	}
	
	public static int minSequencia(int[]a, int count) {
		int min;
		min = a[0];
		for (int i=0; i<count; i++) {
			if (a[i] < min) {
				min = a[i];
			}
		}
		System.out.println("O número mínimo introduzido foi: " + min);	
		return count;
	}
	
	public static int mediaSequencia(int[]a, int count) {
		int soma=0;
		double media;
		double total = count;
		for (int i=0; i<(count-1) ; i++) {
			soma = soma + a[i];
		}
		media = soma/total;
		System.out.println("A média da sequência é: " + media);	
		return count;
	}
	
	public static int seqPares (int[]a, int count) {
		for (int i=0; i<1 ; i++) {
			if (a[i]%2 == 0) {
				System.out.print("A sequencia e so constituida por numeros pares.\n");
			} else System.out.println("A sequencia nao e so constituida por numeros pares.\n");
		}
		return count;
	}
}
