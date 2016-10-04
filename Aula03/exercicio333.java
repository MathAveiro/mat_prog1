import java.util.*;

public class exercicio333 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub

		double num, prim, a, b, media, qnt=0, vlr;
		
		System.out.print("Introduza uma lista de números: ");
		prim = sc.nextDouble();
		
		vlr = prim;
		a = vlr;
		b = vlr;
		
		do {
		
			System.out.print("Introduza uma lista de números: ");
			num = sc.nextDouble();
		
			qnt = qnt + 1;
				
			if (num != prim) {

				if (num < a) a = num;
				if (num > b) b = num;
		
				vlr = vlr + num;
			}
		} while (num != prim);
		
		media = vlr / qnt;
			
		System.out.println("O número mais elevado é: "+b+", o número mais baixo é: "+a+", a média é de: "+media+" e o número de elementos da lista é de: "+qnt);
	}

}
