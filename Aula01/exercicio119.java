import java.util.*;

public class exercicio119 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.println("Introduza as medidas do rectângulo;");
		System.out.print("Largura: ");
		double l = sc.nextDouble();
		System.out.print("Comprimento: ");
		double c = sc.nextDouble();
		System.out.printf("O rectângulo tem %.1f de área e %.1f de perímetro", l*c, (l*2)+(c*2));
	}

}
