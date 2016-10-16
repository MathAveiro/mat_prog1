import java.util.*;

public class exercicio3311 {
	
		public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		
		int valor;
		boolean impar = true;
					
		do{
		
			System.out.print("Introduza um número: ");
			valor = sc.nextInt();
			
			if (valor == 0) break;
			
			if (valor % 2 == 0) impar = false;
			
		}while(valor > 0);
	
		if (impar) System.out.println("A sequência de números é somente constituída por números ímpares.");
		else System.out.println("A sequência de números não é somente constituída por números ímpares.");
		
	}

}