import java.util.*;

public class exercicio443 {
	
		public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		
		int valor;
		
		
		do {
			System.out.print("Introduza um número inteiro entre 1 e 10 (inclusive): ");
			valor = sc.nextInt();
		} while (valor <= 0 || valor >= 11);

		int total = 1;
		
		for (int i=1; i<=valor; i++){
			total = total * i;
		}
		
		System.out.println(valor + "! = " + total);	
		
	}

}