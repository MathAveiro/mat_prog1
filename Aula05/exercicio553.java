import java.util.*;

public class exercicio553 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		int a, m, i=0;
		System.out.println("Introduza o ano: ");
		a = Funcoes.getintpos();
	
		System.out.print("Introduza o mês: ");
		m = Funcoes.getIntRange(13,0);

		boolean anoBis = false;

		if (((a % 4 == 0) && (a % 400 == 0)) || ((a % 4 == 0) && (a % 100 != 0)))
			anoBis = true;
		
		switch (m) {
			case 1:
				i = 31;
				break;
			case 2:
				i = (anoBis == true) ? 29 : 28;
				break;
			case 3:
				i = 31;
				break;
			case 4:
				i = 30;
				break;
			case 5:
				i = 31;
				break;
			case 6:
				i = 30;
				break;
			case 7:
				i = 31;
				break;
			case 8:
				i = 31;
				break;
			case 9:
				i = 30;
				break;
			case 10:
				i = 31;
				break;
			case 11:
				i = 30;
				break;
			case 12:
				i = 31;
				break;
		}
		System.out.println("Número de dias do mês: " + i);
		if (anoBis) System.out.println("O ano é bissexto!");

	}
}