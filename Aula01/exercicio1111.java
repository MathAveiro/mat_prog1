import java.util.*;

public class exercicio1111 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.print("Introduza a quantia em dólares: ");
		double quantia = sc.nextDouble();
		System.out.print("Introduza a taxa de conversão: ");
		double taxa = sc.nextDouble();
		double euros = quantia * taxa;
		System.out.printf("%.1f$ equivale a %.2f€", quantia, euros);
	}

}
