import java.util.*;

public class exercicio1117 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.print("Introduza o valor do produto: ");
		double valorInicial = sc.nextDouble();
		System.out.print("Introduza o desconto a aplicar: ");
		double desconto = sc.nextDouble();
		System.out.print("Introduza a taxa de IVA: ");
		double iva = sc.nextDouble();
		double valorFinal = valorInicial*(1-(desconto/100)) + (valorInicial*(1-(desconto/100)))*(iva/100);
		System.out.printf("O valor final é: %.2f", valorFinal);
	}

}