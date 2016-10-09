import java.util.*;

public class exercicio335 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.print("Introduza um valor: ");
		int valor = sc.nextInt();
		
		while (valor <= 0) {
			System.out.print("O número não é válido, introduza novamente: ");
			valor = sc.nextInt();
		}
		
		
		Boolean primo = true;
		if (valor == 2) primo = true;
		else {
			for(int i = 2;i < valor; i++) {
				if (valor % i == 0) primo = false;
			}
		}
		if (primo) System.out.println("O número " + valor + " é primo!");  
		else System.out.println("O número " + valor + " não é primo!"); 
		
	}

}
