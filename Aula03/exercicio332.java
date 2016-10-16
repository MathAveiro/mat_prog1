import java.util.*;

public class exercicio332 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		
		int cont = 0;
		double num = 0;
		double numTotal = 1;
		
		do {
			
			System.out.print("Introduza um número válido: ");
			num = sc.nextDouble();
			if (num != 0) numTotal = numTotal * num;
			
		} while(num != 0);
		
		System.out.println("O produto dos números introduzidos é: " + numTotal);
		
	}

}
