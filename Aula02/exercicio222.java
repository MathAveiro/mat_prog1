import java.util.*;

public class exercicio222 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.print("Introduza o primeiro número: ");
		int tp1 = sc.nextInt();
		System.out.print("Introduza o segundo número: ");
		int tp2 = sc.nextInt();
		int maior = 0;
		if (tp1 > tp2) 	maior = tp1;
		else if (tp2 > tp1) maior = tp2;
		else if (tp1 == tp2){
			System.out.println("Os dois números são iguais");
			System.exit(0);
		}
			System.out.printf("O número maior é %d", maior);
	}

}
