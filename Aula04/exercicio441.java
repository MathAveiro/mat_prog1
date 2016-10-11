import java.util.*;

public class exercicio441 {
	
		public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		
		int valor;
		
		
		do {
			System.out.print("Introduza o número de vezes a imprimir a mensagem: ");
			valor = sc.nextInt();
				
		} while (valor <= 0);
		
		for (int i=1; i<=valor; i++){
			
			System.out.println("P1 é fixe!");
		
		}
		
	}

}