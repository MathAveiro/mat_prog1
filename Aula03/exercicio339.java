import java.util.*;

public class exercicio339 {
	
		public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		
		double num;
		int positivos=0;
		int negativos=0;
		int gurpomaior=0;
		int grupomenor=0;
		
		do{
			System.out.print("Escreva um número: ");
			num = sc.nextDouble();
			
			if(num==0) break;
			if(num>0) positivos++;
			if(num<0) negativos++;
			if(num>=100 && num<=1000) gurpomaior++;
			if(num>=-1000 && num<=-100)grupomenor++;
			
		}while(num!=0);

		System.out.println("Foram inseridos " + positivos + " números positivos, " + negativos + " números negativos, "
+ gurpomaior + " números entre 100 e 1000 e " + grupomenor + " números entre -1000 e -100");
		
	}

}