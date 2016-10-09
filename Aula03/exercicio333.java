import java.util.*;

public class exercicio333 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub

		double num, prim, max, min, media, qnt=0, vlr;
		
		System.out.print("Introduza uma lista de números: ");
		prim = sc.nextDouble();
		
		vlr = prim;
		max = vlr;
		min = vlr;
		
		do {
		
			System.out.print("Introduza uma lista de números: ");
			num = sc.nextDouble();
		
			qnt = qnt + 1;
				
			if (num != prim) {

				if (num < min) min = num;
				if (num > max) max = num;
		
				vlr = vlr + num;
			}
		} while (num != prim);
		
		media = vlr / qnt;
			
		System.out.println("O número mais elevado é: "+max+", o número mais baixo é: "+min+", a média é de: "+media+" e o número de elementos da lista é de: "+qnt);
	}

}
