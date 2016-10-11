import java.util.*;

public class exercicio442 {
	
		public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		
		int valor;
		
		
		do {
			System.out.print("Introduza um número inteiro entre 0 e 100: ");
			valor = sc.nextInt();
		} while (valor <= 0 || valor >= 100);
		System.out.println("-------------------");
		System.out.println("| Tabuada dos " + valor + "  |");
		System.out.println("-------------------");		
		for (int i=1; i<=10; i++){
			System.out.println("|  " + valor + " x " + i + " |  " + i*valor +"  |");
		}
		System.out.println("-------------------");	
		
	}

}