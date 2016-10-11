import java.util.*;

public class exercicio444 {
	
		public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		
		System.out.print("Insira um número inteiro: ");
		int n = sc.nextInt();
		double soma = 0;
		int a = 1;
		for (int i=1; i<=n; i++) {
			soma = soma + (1.0/a)*(Math.pow(-1,i+1));
			a = a + 2;
		}
	    System.out.printf("%.15f\n", soma);
	     
		if (soma>((Math.PI)/4)) System.out.println("\nA soma é maior que pi sobre 4.");
		else if (soma<((Math.PI/4))) System.out.println("A soma é menor que pi sobre 4.");
		else System.out.println("A soma é igual a pi sobre 4.");
		
	}

}