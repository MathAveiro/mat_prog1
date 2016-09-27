import java.util.*;

public class exercicio227 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.print("Introduza o primeiro número: ");
		int tp1 = sc.nextInt();
		System.out.print("Introduza o segundo número: ");
		int tp2 = sc.nextInt();
		System.out.print("Introduza o terceiro número: ");
		int tp3 = sc.nextInt();
		int maior = tp1;
		if (tp2 >= maior) maior = tp2;
		if (tp3 >= maior) maior = tp3;
		if (tp1 == tp2 && tp2 == tp3){
			System.out.println("Os três números são iguais");
			System.exit(0);
		}
			System.out.printf("O número maior é %d", maior);
	}

}
