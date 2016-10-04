import java.util.*;

public class exercicio332 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		
		int cont = 0;
		int num = 0;
		int numTotal = 1;
		
		do {
			
			System.out.print("Introduza um número válido: ");
			num = sc.nextInt();
			if (num != 0) numTotal = numTotal * num;
			
		} while(num != 0);
		
		System.out.println(numTotal);
		
	}

}
