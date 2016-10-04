import java.util.*;

public class exercicio335 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.print("Introduza um valor: ");
		int valor = sc.nextInt();
		
		String primo = " é primo";
		if (valor == 2) primo = " é primo";
		else {
			for(int i = 2;i < valor; i++) {
				if (valor % i == 0) primo = " não é primo";
			}
		}

		System.out.println("O número " + valor + primo); 
	}

}
