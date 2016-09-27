import java.util.*;

public class exercicio1116 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.print("Quantia gasta pelo turista no primeiro dia: ");
		double dia1 = sc.nextDouble();
		double dia2 = dia1 + 0.2*dia1;
		double dia3 = dia2 + 0.2*dia2;
		double dia4 = dia3 + 0.2*dia3;
		System.out.printf("O turista gastou em média: %.2f", (dia1+dia2+dia3+dia4)/4);
	}

}