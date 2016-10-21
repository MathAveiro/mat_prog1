import java.util.*;

public class exercicio558 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub

		double a, b, c, e;
		
		do{
			
			System.out.print("Insira o valor inicial de X: ");
			a = sc.nextDouble();
			
			System.out.print("Insira o valor final de X: ");
			b = sc.nextDouble();
		
			if (a > b) System.out.println("O valor final deve ser superior ao inicial");
		
		}while(a > b);
		
		System.out.print("Número de elementos da sequência: ");
		
		c = sc.nextDouble();
		
		e = (b-a)/c;
		
		System.out.println("---------------------------------------");
		
		System.out.println("|   x    |  5x2+10x+3 |  7x3+3x2+5x+2 |");
		
		System.out.println("---------------------------------------");
		
		for (double x = a ; x < b ; x += e) {
		
			System.out.printf("|%8f|%12f|%15f|", x, ((Math.pow(x, 2)*5) + (10*x) + 3), Funcoes.poly4(x, x, x, 2));
			
			System.out.println("\n---------------------------------------");
		
		}

	}
}