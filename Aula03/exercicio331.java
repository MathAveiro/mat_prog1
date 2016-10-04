import java.util.*;

public class exercicio331 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		
		int cont = 0;
		int num;
		
		do {
			
			System.out.print("Introduza um número válido: ");
			num = sc.nextInt();
			if (num >= 0) cont++;
			
		} while(num >= 0);
		
		System.out.println(cont);
		
	}

}
